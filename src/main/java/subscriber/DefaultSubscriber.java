package subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSubscriber<T> implements Subscriber<T> {

    private static final Logger logger = LoggerFactory.getLogger(EmailSubscriber.class);

    private final String name;
    public DefaultSubscriber(String name){
        this.name = name;
    }
    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(100);
    }

    @Override
    public void onNext(T t) {
        logger.info("{} received {}",this.name,t);
    }

    @Override
    public void onError(Throwable throwable) {
        logger.error("error {}",throwable);
    }

    @Override
    public void onComplete() {
        logger.info("completed");
    }
}
