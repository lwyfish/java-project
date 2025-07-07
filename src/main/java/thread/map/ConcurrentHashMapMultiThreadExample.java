package thread.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建了一个 ConcurrentHashMap 实例和一个固定大小为 4 的线程池。
 * 使用 ExecutorService 提交 10 个任务，每个任务向 ConcurrentHashMap 中写入一个键值对。由于 ConcurrentHashMap 是线程安全的，多个线程可以同时进行写入操作而不会出现数据竞争问题。
 * 关闭线程池并等待所有任务完成。
 * 输出最终的 ConcurrentHashMap 内容。
 */
public class ConcurrentHashMapMultiThreadExample {
    public static void main(String[] args) {
        // 创建 ConcurrentHashMap 实例
//        ConcurrentHashMap<String, Integer> javabasic.map = new ConcurrentHashMap<>();
        Map<String, Integer> map = new HashMap<>();
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 模拟多个线程同时写入数据
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.submit(() -> {
                map.put("key" + index, index);
                System.out.println(Thread.currentThread().getName() + " put key" + index + " = " + index);
            });
        }

        // 关闭线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
            // 等待所有任务完成
        }

        // 输出最终的 javabasic.map 内容
        System.out.println("Final javabasic.map: " + map);
    }
}