package astronaut.schedule.manager;
import astronaut.schedule.model.*;
import astronaut.schedule.observer.ScheduleObserver;
import astronaut.schedule.exception.InvalidTaskException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<ScheduleObserver> observers = new ArrayList<>();

    private ScheduleManager() {}

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) instance = new ScheduleManager();
        return instance;
    }

    public void addObserver(ScheduleObserver observer) {
        observers.add(observer);
    }

    public void addTask(Task task) throws InvalidTaskException {
        for (Task existing : tasks) {
            if (task.getStartTime().isBefore(existing.getEndTime()) &&
                task.getEndTime().isAfter(existing.getStartTime()) &&
                !existing.isCompleted()) {
                notifyObservers("Task conflicts with existing task: " + existing.getDescription());
                throw new InvalidTaskException("Task conflicts with " + existing.getDescription());
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
    }

    public boolean removeTask(String description) {
        return tasks.removeIf(t -> t.getDescription().equalsIgnoreCase(description));
    }

    public boolean editTask(String oldDesc, String newDesc, LocalTime start, LocalTime end, Priority priority) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(oldDesc)) {
                task.setDescription(newDesc);
                task.setStartTime(start);
                task.setEndTime(end);
                task.setPriority(priority);
                return true;
            }
        }
        return false;
    }

    public boolean markTaskCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markCompleted();
                return true;
            }
        }
        return false;
    }

    public List<Task> getTasksByPriority(Priority priority) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority() == priority) result.add(task);
        }
        return result;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    private void notifyObservers(String message) {
        for (ScheduleObserver observer : observers) observer.onConflict(message);
    }

    public List<Task> viewTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public LocalTime suggestNextAvailableSlot(LocalTime desiredStart, LocalTime desiredEnd) {
    LocalTime candidateStart = desiredStart;
    LocalTime candidateEnd = desiredEnd;

    tasks.sort(Comparator.comparing(Task::getStartTime));

    for (Task task : tasks) {
        if (candidateStart.isBefore(task.getEndTime()) && candidateEnd.isAfter(task.getStartTime())) {
            candidateStart = task.getEndTime();
            candidateEnd = candidateStart.plusMinutes(Duration.between(desiredStart, desiredEnd).toMinutes());
        }
    }
    return candidateStart;
}

    public void printDailySummary() {
        List<Task> completedTasks = tasks.stream().filter(Task::isCompleted).toList();
        List<Task> pendingTasks = tasks.stream().filter(t -> !t.isCompleted()).toList();

        long high = tasks.stream().filter(t -> t.getPriority() == Priority.HIGH).count();
        long medium = tasks.stream().filter(t -> t.getPriority() == Priority.MEDIUM).count();
        long low = tasks.stream().filter(t -> t.getPriority() == Priority.LOW).count();

        System.out.println("\n==== Daily Summary ====");
        System.out.println("Total tasks: " + tasks.size());

        System.out.println("\nHigh priority tasks: " + high);
        System.out.println("Medium priority tasks: " + medium);
        System.out.println("Low priority tasks: " + low);

        System.out.println("\nCompleted tasks (" + completedTasks.size() + "):");
        if (completedTasks.isEmpty()) System.out.println("None");
        else completedTasks.forEach(t ->
                System.out.println(" - " + t.getDescription() + " [" + t.getPriority() + "]")
        );

        System.out.println("\nPending tasks (" + pendingTasks.size() + "):");
        if (pendingTasks.isEmpty()) System.out.println("None");
        else pendingTasks.forEach(t ->
                System.out.println(" - " + t.getDescription() + " [" + t.getPriority() + "]")
        );

        
    }
}
