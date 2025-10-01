package astronaut.schedule.util;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AppLogger {
    private static final String LOG_FILE = "schedule_app.log";

    public static void log(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}
