package sessionManager.manager;
import sessionManager.interfaces.SessionHandler;
import sessionManager.interfaces.TokenGenerator;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalSessionManager implements SessionHandler {
    private static GlobalSessionManager instance;
    private ConcurrentHashMap<String, String> activeSessions;
    private TokenGenerator tokenGenerator;

    
    private GlobalSessionManager(TokenGenerator tokenGenerator) {
        this.activeSessions = new ConcurrentHashMap<>();
        this.tokenGenerator = tokenGenerator;
        System.out.println("Global Session Manager Initialized.");
    }

    public static synchronized GlobalSessionManager getInstance(TokenGenerator tokenGenerator) {
        if (instance == null) {
            instance = new GlobalSessionManager(tokenGenerator);
        }
        return instance;
    }

    @Override
    public void createSession(String userId) {
        String token = tokenGenerator.generateToken(userId);
        activeSessions.put(userId, token);
        System.out.println("Session created for " + userId + " with token: " + token);
    }

    @Override
    public void invalidateSession(String userId) {
        activeSessions.remove(userId);
        System.out.println("Session invalidated for " + userId);
    }

    @Override
    public boolean isSessionActive(String userId) {
        return activeSessions.containsKey(userId);
    }

    public String getToken(String userId) {
        return activeSessions.get(userId);
    }
}
