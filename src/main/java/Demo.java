import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import publisher.EmailPublisher;
import publisher.EmailSubscription;
import subscriber.EmailSubscriber;

public class Demo {
    private static final Logger logger = LoggerFactory.getLogger(Demo.class);
    public static void main(String[] args) {
        logger.info("executing");
        EmailPublisher publisher = new EmailPublisher();
        EmailSubscriber subscriber = new EmailSubscriber();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
    }
}
