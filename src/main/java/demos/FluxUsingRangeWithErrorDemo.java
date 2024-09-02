package demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class FluxUsingRangeWithErrorDemo {


    private static final Logger log = LoggerFactory.getLogger(FluxUsingRangeWithErrorDemo.class);

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(20, 10)
                .map(i -> i == 25 ? 10 / 0 : i)
                .doOnNext(i -> System.out.println("next is : " + (i)))
                .onErrorContinue((ex, val) -> log.error("error {}",ex));
        integerFlux.subscribe(System.out::println);



    }
}
