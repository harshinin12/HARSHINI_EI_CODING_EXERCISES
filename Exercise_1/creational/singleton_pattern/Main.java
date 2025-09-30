
import sessionManager.manager.GlobalSessionManager;
import sessionManager.manager.UUIDTokenGenerator;
import sessionManager.interfaces.TokenGenerator;

public class Main {
    public static void main(String[] args) {
        TokenGenerator tokenGen = new UUIDTokenGenerator();

        GlobalSessionManager sessionManager1 = GlobalSessionManager.getInstance(tokenGen);
        GlobalSessionManager sessionManager2 = GlobalSessionManager.getInstance(tokenGen);

        sessionManager1.createSession("Harshini");
        sessionManager1.createSession("Parvathi");

        System.out.println("Is Harshini active? " + sessionManager2.isSessionActive("Harshini"));

        sessionManager2.invalidateSession("Harshini");
        System.out.println("Is Harshini active? " + sessionManager1.isSessionActive("Harshini"));
        System.out.println("Both instances same? " + (sessionManager1 == sessionManager2));
    }
}
