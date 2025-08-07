package thread.syn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
 
/**
 * ReentrantLockCase1
 * 使用ReentrantLock调用方法超时处理
 *
 * @author wxy
 * @date 2023-02-16
 */
public class ReentrantLockCase1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReentrantLockCase1.class);
 
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int index = 0; index < 2; index++) {
            new Thread(() -> {
                /*---修改前代码---*/
                try {
                    lock.lock();
                    // 调用某个方法，这个方法会超时60s(偶现)
                    timeoutApi();
                } finally {
                    lock.unlock();
                }
 
                /*---修改后代码---*/
//                try {
//                    // 设置如果线程1正在调用，线程2等待5秒，5秒后你可以对线程2进行处理: 比如返回提示、线程处理...
//                    // 如果你不设置超时时间，那么所有的线程就会等待前一个线程解锁，具体怎么等待请看AQS详解
//                    // 备注: 正常情况下超时时间应该在配置文件中配置，可以按照业务随时进行调整
//                    if (lock.tryLock(5, TimeUnit.SECONDS)) {
//                        // 调用某个方法，这个方法会超时60s(偶现)
//                        timeoutApi();
//                    } else {
//                        /// 你可以写一些业务逻辑，来处理超时的线程2和超时期间的后续线程
//                        LOGGER.info("operation timeout");
//                    }
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                } finally {
//                    // 一定要在finally解锁
//                    lock.unlock();
//                }


            }).start();
        }
    }
 
    /**
     * 超时的API
     */
    private static void timeoutApi() {
        LOGGER.info("timeout api start.");
        sleep(60);
        LOGGER.info("timeout api end.");
    }
 
    /**
     * 设置超时时间
     *
     * @param timeOut 超时时间(秒)
     */
    private static void sleep(long timeOut) {
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}