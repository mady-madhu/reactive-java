package demos;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxRangeHotPublishDemo {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> sharedFlux = Flux.range(1, 10)
                .delayElements(Duration.ofMillis(200))
                .share();  // Converts to a hot Flux

        // First subscriber
        sharedFlux.subscribe(i -> System.out.println("Subscriber 1: " + i));

        // Adding a delay before the second subscriber
        Thread.sleep(500);

        // Second subscriber
        sharedFlux.subscribe(i -> System.out.println("Subscriber 2: " + i));

        Thread.sleep(3000);  // Allow time for all items to be emitted
    }

    public static void  demo1() throws InterruptedException {
        ConnectableFlux<Integer> hotFlux = Flux.range(1, 5)
                .delayElements(Duration.ofMillis(200)) //if you remove this statement, in this case Subscribers Are Too Late
                .publish();

        hotFlux.connect(); // Start emitting

        // First subscriber starts immediately
        hotFlux.subscribe(i -> System.out.println("Subscriber 1: " + i));

        Thread.sleep(500); // Wait before subscribing the second subscriber

        // Second subscriber starts later and misses the initial items
        hotFlux.subscribe(i -> System.out.println("Subscriber 2: " + i));

        Thread.sleep(1000); // Give it some time to complete
    }
}
