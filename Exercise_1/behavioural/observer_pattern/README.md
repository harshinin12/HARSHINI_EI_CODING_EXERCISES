# Observer Pattern – Social Media Notification System

The Observer Pattern is a behavioral design pattern where an object (Subject) maintains a list of dependents (Observers) and notifies them automatically whenever its state changes.  
It enables loose coupling and dynamic subscription of event listeners.

## Use Case: Social Media Post Notifications
In this project, a UserPost (Subject) represents new social media posts, while multiple modules act as Observers (MobileApp, EmailService, AnalyticsModule).  
When a user creates a post, all subscribed observers are notified instantly. Observers can also be added or removed dynamically at runtime.


## Why It Is Observer Pattern
- A single subject (UserPost) manages a list of observers.  
- Observers are automatically notified when the subject’s state changes (new post).  
- The subject and observers are loosely coupled — the subject doesn’t need to know what observers do.  
- Observers can be added or removed at runtime without altering the subject’s code.  
- This matches the core definition of the Observer Pattern, where dependents react to state changes in a subject.  

**Key Demonstartion in code**
```java
UserPost post = new UserPost();
post.registerObserver(new MobileApp());
post.registerObserver(new EmailService());
post.registerObserver(new AnalyticsModule());

post.createPost("Observer Pattern implemented successfully!");
```
## Output Screenshot
<img width="817" height="212" alt="image" src="https://github.com/user-attachments/assets/013ee036-60ad-453e-b59d-c2edb617ce0c" />

