package publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailPublisher implements Publisher<String> {

    private static final Logger logger = LoggerFactory.getLogger(EmailPublisher.class);
    @Override
    public void subscribe(Subscriber<? super String> subscriber) {
        EmailSubscription subscription = new EmailSubscription(subscriber);
        subscriber.onSubscribe(subscription);
    }
}
