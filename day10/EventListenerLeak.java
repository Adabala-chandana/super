package day10;



import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class EventBus {
    private  static final List<Consumer<String>> listeners = new ArrayList<>();

    static void subscribe(Consumer<String> listener) {
        listeners.add(listener);
    }
    static void unsubscribe(Consumer<String> listener) {
        listeners.remove(listener);
    }

    static void publish(String event) {
        for (Consumer<String> listener : listeners) {
            listener.accept(event);
        }
    }
}

public class EventListenerLeak {
    static void handleRequest(int id) {
        byte[] payload = new byte[64 * 1024];
        payload[0] = (byte) id;

       
        Consumer<String> listener = msg -> {
            if (!msg.isEmpty() && payload[0] == (byte) id) {
            }
        };

        EventBus.subscribe(listener);         
        EventBus.publish("order-" + id);     
        EventBus.unsubscribe(listener);
      
        
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            handleRequest(i);
            if (i % 100 == 0) {
                System.out.println("requests=" + i);
            }
        }
    }
}
