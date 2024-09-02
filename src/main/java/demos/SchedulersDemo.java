package demos;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class SchedulersDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux = Flux.just(1, 2, 3)
                .map(i -> i * 2)  // This map is upstream of `publishOn`
                .doOnNext(i -> System.out.println("Before publishOn: " + Thread.currentThread().getName()+"::"+i))
                .delayElements(Duration.ofSeconds(2))
                .publishOn(Schedulers.parallel()) // Changes thread for subsequent operations
                .doOnNext(i -> System.out.println("After publishOn: " + Thread.currentThread().getName()+"::"+i))
                .subscribeOn(Schedulers.boundedElastic()); // Changes thread for upstream operations



        flux.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(Thread.currentThread().getName()+"Element ::" +integer);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });

        Thread.sleep(7000);

    }
}
