package observer;
public class EmailService implements Observer {
    @Override
    public void update(String postContent) {
        System.out.println("[EmailService] Email sent: " + postContent);
    }
}
