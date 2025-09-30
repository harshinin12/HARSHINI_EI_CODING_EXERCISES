package subject;

import observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class UserPost {
    private String content;
    private final List<Observer> observers;

    public UserPost() {
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void createPost(String content) {
        this.content = content;
        System.out.println("[UserPost] New post created: " + content);
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(content);
        }
    }
}
