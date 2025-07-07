package thread.threadpool;

import java.util.concurrent.*;

public class ThreadPoolProducerConsumer {
    private static final int PRODUCER_THREADS = 2;
    private static final int CONSUMER_THREADS = 2;
    private static final int TASK_COUNT = 10;
    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
    private static final CountDownLatch latch = new CountDownLatch(PRODUCER_THREADS + CONSUMER_THREADS);

    public static void main(String[] args) {
        // 创建生产者线程池
        ExecutorService producerThreadPool = Executors.newFixedThreadPool(PRODUCER_THREADS);
        // 创建消费者线程池
        ExecutorService consumerThreadPool = Executors.newFixedThreadPool(CONSUMER_THREADS);

        // 提交生产者任务
        for (int i = 0; i < PRODUCER_THREADS; i++) {
            producerThreadPool.submit(new Producer());
        }

        // 提交消费者任务
        for (int i = 0; i < CONSUMER_THREADS; i++) {
            consumerThreadPool.submit(new Consumer());
        }

        try {
            // 等待所有生产者和消费者任务完成
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 关闭线程池
        producerThreadPool.shutdown();
        consumerThreadPool.shutdown();

        System.out.println("所有任务完成，主线程继续执行");
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < TASK_COUNT; i++) {
                    System.out.println(Thread.currentThread().getName() + " 生产: " + i);
                    queue.put(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 生产者任务完成，计数器减 1
                latch.countDown();
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    // 模拟一段时间后判断是否继续消费
                    if (latch.getCount() <= CONSUMER_THREADS && queue.isEmpty()) {
                        break;
                    }
                    Integer item = queue.poll(1, TimeUnit.SECONDS);
                    if (item != null) {
                        System.out.println(Thread.currentThread().getName() + " 消费: " + item);
                        Thread.sleep(200);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 消费者任务完成，计数器减 1
                latch.countDown();
            }
        }
    }
}