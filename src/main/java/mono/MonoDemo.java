package mono;

import reactor.core.publisher.Mono;
import subscriber.DefaultSubscriber;

public class MonoDemo {


    public static void main(String[] args) {
        Mono.fromSupplier(() -> "hello")
                .subscribe(new DefaultSubscriber<>("sub1"));
    }

}
