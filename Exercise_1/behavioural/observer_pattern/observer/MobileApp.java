package observer;

public class MobileApp implements Observer {
    @Override
    public void update(String postContent) {
        System.out.println("[MobileApp] Push notification: " + postContent);
    }
}
