package demos;

import reactor.core.publisher.Flux;

public class FluxUsingRangeDemo {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.range(20, 30)
                .filter(i -> i > 30)
                .switchIfEmpty(Flux.range(10, 2));

        integerFlux.subscribe(System.out::println);


    }
}
