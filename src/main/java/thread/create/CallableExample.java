package thread.create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 实现 Callable 接口，指定返回值类型为 Integer
class MyCallable implements Callable<Integer> {
    private final int taskId;

    public MyCallable(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Task " + taskId + " started.");
        // 模拟耗时操作
        Thread.sleep(1000); 
        int result = taskId * 2;
        System.out.println("Task " + taskId + " finished. Result: " + result);
        return result;
    }
}

public class CallableExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // 存储 Future 对象的列表
        List<Future<Integer>> futures = new ArrayList<>();

        // 提交多个任务
        for (int i = 1; i <= 3; i++) {
            MyCallable callable = new MyCallable(i);
            Future<Integer> future = executor.submit(callable);
            futures.add(future);
        }

        // 获取每个任务的结果
        for (Future<Integer> future : futures) {
            try {
                Integer result = future.get();
                System.out.println("Final result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error occurred while getting result: " + e.getMessage());
            }
        }

        // 关闭线程池
        executor.shutdown();
    }
}
