package astronaut.schedule.observer;
public interface ScheduleObserver {
    void onConflict(String message);
}
