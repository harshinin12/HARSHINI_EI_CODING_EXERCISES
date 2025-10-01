package astronaut.schedule.cli;

import astronaut.schedule.factory.TaskFactory;
import astronaut.schedule.manager.ScheduleManager;
import astronaut.schedule.model.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private final ScheduleManager manager = ScheduleManager.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n==== Astronaut Daily Schedule ====");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Daily Summary");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            switch (scanner.nextLine()) {
                case "1" -> addTask();
                case "2" -> removeTask();
                case "3" -> viewTasks();
                case "4" -> editTask();
                case "5" -> markCompleted();
                case "6" -> viewByPriority();
                case "7" -> manager.printDailySummary();
                case "8" -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addTask() {
        try {
            System.out.print("Description: ");
            String desc = scanner.nextLine();

            System.out.print("Start time (HH:MM): ");
            LocalTime start = parseTime(scanner.nextLine());
            if (start == null) return;

            System.out.print("End time (HH:MM): ");
            LocalTime end = parseTime(scanner.nextLine());
            if (end == null) return;

            System.out.print("Priority (LOW/MEDIUM/HIGH): ");
            Priority p = Priority.valueOf(scanner.nextLine().toUpperCase());

            Task newTask = TaskFactory.createTask(desc, start, end, p);

            try {
                manager.addTask(newTask);
                System.out.println("Task added successfully. No conflicts.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

                LocalTime suggestedStart = manager.suggestNextAvailableSlot(start, end);
                if (suggestedStart != null) {
                    LocalTime suggestedEnd = suggestedStart.plusMinutes(Duration.between(start, end).toMinutes());
                    System.out.println("Suggested next available slot: " + suggestedStart + " to " + suggestedEnd);
                    System.out.print("Do you want to schedule the task at this slot? (yes/no): ");
                    String choice = scanner.nextLine().trim().toLowerCase();
                    if (choice.equals("yes")) {
                        newTask.setStartTime(suggestedStart);
                        newTask.setEndTime(suggestedEnd);
                        manager.addTask(newTask);
                        System.out.println("Task added successfully at suggested slot.");
                    } else {
                        System.out.println("Task not added.");
                    }
                } else {
                    System.out.println("No available slot today.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void removeTask() {
        System.out.print("Enter description to remove: ");
        if (manager.removeTask(scanner.nextLine()))
            System.out.println("Task removed successfully.");
        else
            System.out.println("Error: Task not found.");
    }

    private void viewTasks() {
        List<Task> tasks = manager.getAllTasks();
        if (tasks.isEmpty()) System.out.println("No tasks scheduled for the day.");
        else tasks.forEach(System.out::println);
    }

    private void editTask() {
        try {
            System.out.print("Enter task to edit: ");
            String oldDesc = scanner.nextLine();

            System.out.print("New description: ");
            String newDesc = scanner.nextLine();

            System.out.print("New start (HH:MM): ");
            LocalTime start = parseTime(scanner.nextLine());
            if (start == null) return;

            System.out.print("New end (HH:MM): ");
            LocalTime end = parseTime(scanner.nextLine());
            if (end == null) return;

            System.out.print("New priority (LOW/MEDIUM/HIGH): ");
            Priority p = Priority.valueOf(scanner.nextLine().toUpperCase());

            if (manager.editTask(oldDesc, newDesc, start, end, p))
                System.out.println("Task updated successfully.");
            else
                System.out.println("Error: Task not found.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void markCompleted() {
        System.out.print("Enter task to mark completed: ");
        if (manager.markTaskCompleted(scanner.nextLine()))
            System.out.println("Task marked as completed.");
        else
            System.out.println("Error: Task not found.");
    }

    private void viewByPriority() {
        System.out.print("Enter priority (LOW/MEDIUM/HIGH): ");
        try {
            Priority p = Priority.valueOf(scanner.nextLine().toUpperCase());
            List<Task> tasks = manager.getTasksByPriority(p);
            if (tasks.isEmpty()) System.out.println("No tasks with " + p + " priority.");
            else tasks.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: Invalid priority.");
        }
    }

    private static LocalTime parseTime(String input) {
        try {
            return LocalTime.parse(input);
        } catch (Exception e) {
            System.out.println("Error : Invalid time format.");
            return null;
        }
    }
}
