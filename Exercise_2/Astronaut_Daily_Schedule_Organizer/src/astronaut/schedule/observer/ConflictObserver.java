package astronaut.schedule.observer;
public class ConflictObserver implements ScheduleObserver {
    @Override
    public void onConflict(String message) {
        System.out.println("Conflict Alert: " + message);
    }
}
