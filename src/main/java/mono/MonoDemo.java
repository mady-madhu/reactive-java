package mono;

import reactor.core.publisher.Mono;
import subscriber.DefaultSubscriber;

public class MonoDemo {



    public static void main(String[] args) throws  Exception {

        Mono<String> justed = Mono.just("Hello")
                .doOnSubscribe( s -> System.out.println("subscribed"))
                .doOnNext(e -> System.out.println("mono on next"))
                .doOnSuccess(e -> System.out.println("success"))
                .doOnError(e -> System.out.println("do on Error"))
                .doFinally(e -> System.out.println("finally"));
        justed.subscribe(
                value -> System.out.println("value=" + value),
                err -> System.err.println("error=" + err),
                () -> System.out.println("completed")
        );

    }
}
