package observer;

public class AnalyticsModule implements Observer {
    @Override
    public void update(String postContent) {
        System.out.println("[AnalyticsModule] Post logged for analytics: " + postContent);
    }
}
