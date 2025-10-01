package astronaut.schedule.factory;
import astronaut.schedule.model.Priority;
import astronaut.schedule.model.Task;
import java.time.LocalTime;

public class TaskFactory {

    public static Task createTask(String description, LocalTime start, LocalTime end, Priority priority) {
        return new Task(description, start, end, priority);
    }
}
