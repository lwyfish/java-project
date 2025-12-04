package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池+Future+Callable
 *
 * @author lwy
 * @date 2025/08/14 15:40
 **/
public class ThreadDemo02 {
    public static void main(String[] args) {
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        threadDemo02.demo1();
    }
    public void demo1() {
        // 定义线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 7, 30,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<String> future = threadPool.submit(new CallableTask());
            futureList.add(future);
        }

        // 从future中取出
        for (Future<String> future : futureList) {
            try {
                String s = future.get();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * callable
     *
     */
    class CallableTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "123";
        }
    }


}
