package day10;



import java.util.HashMap;
import java.util.Map;

class SessionToken {
    final String userId;

    SessionToken(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SessionToken)) return false;
        return userId.equals(((SessionToken) o).userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }
}

class SessionStore {
    private static final Map<SessionToken, byte[]> ACTIVE = new HashMap<>();

    static void login(SessionToken token) {
        ACTIVE.put(token, new byte[32 * 1024]);
    }

    static int size() {
        return ACTIVE.size();
    }
}

public class SessionKeyLeak {
    public static void main(String[] args) {
        for (int i = 0; i < 2_000_000; i++) {
            String userId = "user-" + (i % 100);
            SessionStore.login(new SessionToken(userId));
            if (i % 500 == 0) {
                System.out.println("logins=" + i + " mapSize=" + SessionStore.size());
            }
        }
    }
}
