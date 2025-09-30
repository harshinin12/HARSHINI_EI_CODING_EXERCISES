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

This project demonstrates how the Observer Pattern decouples the subject (post creation) from its observers (notification services), ensuring scalability and flexibility.
