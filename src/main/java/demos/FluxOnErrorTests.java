package demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxOnErrorTests {

    private static final Logger log = LoggerFactory.getLogger(FluxOnErrorTests.class);

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> integerFlux = Flux.range(1, 10)
                .map(i -> i == 3 ? i / 0 : i)
                .onErrorContinue((ex, obj) -> {
                    log.info("error {}", ex);
                    log.info("object {}", obj);
                });


        integerFlux.delayElements(Duration.ofMillis(100))
                .subscribe(System.out::println);


        Thread.sleep(3000);

    }
}
