package sessionManager.manager;

import sessionManager.interfaces.TokenGenerator;
import java.util.UUID;

public class UUIDTokenGenerator implements TokenGenerator {
    @Override
    public String generateToken(String userId) {
        return UUID.randomUUID().toString();
    }
}
