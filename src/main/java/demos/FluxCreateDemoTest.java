package demos;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxCreateDemoTest {
    public static void main(String[] args) throws InterruptedException {

        demo2();

    }

    public static void demo2() throws InterruptedException {
        Flux<Object> objectFlux = Flux.create(fluxSink -> {
                    for (int i = 1; i <= 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                }).delayElements(Duration.ofMillis(200))
                .share();


        objectFlux.subscribe(i -> System.out.println("Subscriber 1: " + i));

        Thread.sleep(600);
        objectFlux.subscribe(i -> System.out.println("Subscriber 2: " + i));

        Thread.sleep(3000);  // Allow time for all items to be emitted
    }


    public static void demo1() throws InterruptedException {
        Flux<Object> objectFlux = Flux.create(fluxSink -> {
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        });

        objectFlux.subscribe(i -> System.out.println("Subscriber 1: " + i));
        objectFlux.subscribe(i -> System.out.println("Subscriber 2: " + i));

    }
}
