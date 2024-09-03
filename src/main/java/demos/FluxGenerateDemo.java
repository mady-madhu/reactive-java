package demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxGenerateDemo {

    private static Logger log = LoggerFactory.getLogger(FluxGenerateDemo.class);

    public static void main(String[] args) throws InterruptedException {
        Flux<Object> generated = Flux.generate(
                () -> 1,
                (state, sink) -> {
                    log.info("generate {}", state);
                    sink.next(state);
                    return ++state;
                });


        generated.delayElements(Duration.ofMillis(100))
                .subscribe(i -> System.out.println("received ::" + i));


        Thread.currentThread().join();
    }
}
