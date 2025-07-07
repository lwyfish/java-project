package thread.threadlocal;

/**
 * ThreadLocal 类的主要作用是为使用该变量的每个线程都单独创建一个独立的副本，每个线程都可以独立地改变自己的副本，而不会影响其他线程所对应的副本
 */
public class ThreadLocalBasicExample {
    // 创建一个 ThreadLocal 实例，初始值为 0
    private static final ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 创建并启动两个线程
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                // 获取当前线程的计数器值
                int value = threadLocalCounter.get();
                // 计数器值加 1
                threadLocalCounter.set(value + 1);
                System.out.println(Thread.currentThread().getName() + " 计数器值: " + threadLocalCounter.get());
            }
            // 移除当前线程的 ThreadLocal 变量副本
            threadLocalCounter.remove();
        }, "线程 1");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                int value = threadLocalCounter.get();
                threadLocalCounter.set(value + 1);
                System.out.println(Thread.currentThread().getName() + " 计数器值: " + threadLocalCounter.get());
            }
            threadLocalCounter.remove();
        }, "线程 2");

        thread1.start();
        thread2.start();
    }
}    