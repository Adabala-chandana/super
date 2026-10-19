package day10;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RequestContext {
    private static final ThreadLocal<Map<String, byte[]>> SESSION_DATA =
            ThreadLocal.withInitial(HashMap::new);

    static void begin(String sessionId) {
        SESSION_DATA.get().put(sessionId, new byte[48 * 1024]);
    }

    static void end() {
        SESSION_DATA.remove(); 
    }
}

public class ThreadLocalLeak {
    static void simulateRequest(String sessionId) {
        try {
            RequestContext.begin(sessionId);
        } finally {
            RequestContext.end();  
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try {
            for (int i = 0; i < 500_000; i++) {
                String sessionId = "user-" + (i % 10_000);
                pool.submit(() -> simulateRequest(sessionId)).get();
                if (i % 2_000 == 0) {
                    System.out.println("requestsss=" + i);
                }
            }
        } finally {
            pool.shutdown();
        }
    }
}
