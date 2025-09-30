package sessionManager.interfaces;

public interface SessionHandler {
    void createSession(String userId);
    void invalidateSession(String userId);
    boolean isSessionActive(String userId);
}