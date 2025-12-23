package flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxDemo {



    public static void main(String[] args) throws  Exception {

        Flux<String> fluxed = Flux.just("A", "B", "C")
                .doOnSubscribe(s -> System.out.println("subscribed"))
                .doOnNext(e -> System.out.println("flux on next: " + e))
                .doOnComplete(() -> System.out.println("completed (flux)"))
                .doOnError(e -> System.out.println("do on error"))
                .doFinally(signal -> System.out.println("finally: " + signal));

        fluxed.subscribe(
                value -> System.out.println("value=" + value),
                err -> System.err.println("error=" + err),
                () -> System.out.println("completed (subscriber)")
        );

    }
}
