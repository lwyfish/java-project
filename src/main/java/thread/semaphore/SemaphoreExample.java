package thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    // 创建一个 Semaphore 实例，初始许可数量为 2
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {
        // 创建一个固定大小为 5 的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 提交 5 个任务
        for (int i = 0; i < 5; i++) {
            // 获取许可，获取不到会阻塞
            semaphore.acquire();

            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 获得许可，开始访问资源");
                    // 模拟资源访问
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " 访问资源结束，释放许可");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
//                    // 释放许可
//                    semaphore.release();
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}    