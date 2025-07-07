package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerWithBlockingQueue {
    private static final int MAX_SIZE = 10;
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>(MAX_SIZE);

    public static void main(String[] args) {
        ProducerConsumerWithBlockingQueue example = new ProducerConsumerWithBlockingQueue();
        
        // 生产者线程
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    example.produce("Data-" + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");
        
        // 消费者线程
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    example.consume();
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");
        
        // 启动线程
        producer.start();
        consumer.start();
        
        // 等待线程结束
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 生产者方法
    public void produce(String data) throws InterruptedException {
        queue.put(data);
        System.out.println(Thread.currentThread().getName() + " product: " + data);
    }

    // 消费者方法
    public void consume() throws InterruptedException {
        String data = queue.take();
        System.out.println(Thread.currentThread().getName() + " consume: " + data);
    }
}