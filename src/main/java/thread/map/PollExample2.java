package thread.map;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PollExample2 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        Thread producer = new Thread(() -> {
            try {
                // 模拟一段时间后向队列添加元素
                Thread.sleep(2000);
                queue.add(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();

        // 尝试从队列中取出元素，等待 3 秒
        Integer element = queue.poll(3, TimeUnit.SECONDS);
        System.out.println("poll 等待后的结果: " + element);
    }
}