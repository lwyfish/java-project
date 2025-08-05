package thread.create;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方法
 *
 * @author lwy
 * @date 2025/07/23 21:10
 **/
public class CreateThread {
    // 1. 继承thread类，重写run方法
    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println("mythread1 start.");
        }
    }

    public static class Runnable2 implements Runnable {
        @Override
        public void run() {
            System.out.println("mythread2 start.");
        }
    }

    public static class Callable5 implements Callable {
        @Override
        public Long call() {
            System.out.println("Callable5 start.");
            return 1L;
        }
    }


    public static void main(String[] args) {
        // 1. 继承thread类，重写run方法
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        // 2. 实现runnable接口，重写run方法
        Thread myThread2 = new Thread(new Runnable2());
        myThread2.start();

        // 3. 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("mythread3 start.");
            }
        }).start();

        // 4. lambda表达式
        new Thread(() -> System.out.println("mythread4 start.")).start();

        // 5. 使用 Callable 和 Future
        Callable5 callable5 = new Callable5();
        FutureTask futureTask = new FutureTask(callable5);
        new Thread(futureTask).start();
        try {
            Long num = (Long) futureTask.get();
            System.out.println(num);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
