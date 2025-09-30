import subject.UserPost;
import observer.MobileApp;
import observer.EmailService;
import observer.AnalyticsModule;

public class SocialMediaDemo {
    public static void main(String[] args) {
        
        UserPost post = new UserPost();

        MobileApp mobileApp = new MobileApp();
        EmailService emailService = new EmailService();
        AnalyticsModule analytics = new AnalyticsModule();

        post.registerObserver(mobileApp);
        post.registerObserver(emailService);
        post.registerObserver(analytics);

        post.createPost("Observer Pattern implemented successfully!");
        System.out.println("----");

        post.removeObserver(emailService);
        post.createPost("Second post without email notification.");
    }
}
