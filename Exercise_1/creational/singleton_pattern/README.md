# Singleton Pattern Example – Global Session Manager

## 1. Pattern Name
**Singleton Pattern** – Ensures that a class has only one instance and provides a global point of access to it.

## 2. Use Case
**Global Session Management** in an application:  

- Only **one instance** of GlobalSessionManager exists to manage all active user sessions.  
- Multiple parts of the application access the same instance, ensuring **consistent session data**.  
- The system uses a **token generator** (TokenGenerator) to create unique session tokens for users.  

**Example Scenario**:
- A web or desktop application where multiple users log in and out.  
- All session operations (createSession, invalidateSession, isSessionActive) are handled by the **same global instance**.  
- Demonstrates that two references to the session manager point to the **same object**, maintaining shared state.

## 3. Why it is Singleton Pattern
- **Private Constructor**: Prevents creating instances from outside the class.  
- **Static Instance**: A single static variable stores the only instance.  
- **Global Access Method**: getInstance() provides controlled access to the instance.  
- **Thread Safety**: synchronized ensures safe access in multi-threaded environments.  

**Key Demonstration in Code**:
```java
GlobalSessionManager sessionManager1 = GlobalSessionManager.getInstance(tokenGen);
GlobalSessionManager sessionManager2 = GlobalSessionManager.getInstance(tokenGen);
System.out.println("Both instances same? " + (sessionManager1 == sessionManager2)); - true

## Output screenshot
<img width="775" height="183" alt="image" src="https://github.com/user-attachments/assets/8deff0ea-b425-4d7f-b575-25db1c554767" />

