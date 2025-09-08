package performance.query;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 抽象生产者消费者
 *
 * @author lwy
 * @date 2025/09/05 15:59
 **/
public abstract class AbstractPerfWorker implements Runnable {

    private LinkedBlockingQueue queue;

    private CountDownLatch countDownLatch;

    public AbstractPerfWorker(LinkedBlockingQueue queue) {
        this.queue = queue;
        this.countDownLatch = new CountDownLatch(1);
    }
}
