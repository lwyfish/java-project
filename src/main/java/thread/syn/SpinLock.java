package thread.syn;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁：
 */
public class SpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<Thread>();

    public void lock() {
        Thread currentThread = Thread.currentThread();
        // 如果锁未被占用，则设置当前线程为锁的拥有者
        while (!owner.compareAndSet(null, currentThread)) {
            System.out.println(currentThread.getName() + " wait.");
        }
    }

    public void unlock() {
        Thread currentThread = Thread.currentThread();
        // 只有锁的拥有者才能释放锁
        owner.compareAndSet(currentThread, null);
    }

    public static void main(String[] args) {
        // compareAndSet方法
        test();

        //
        test2();
    }

    /**
     * 预期是2，不会更新成功
     */
    public static void test() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        boolean b = atomicInteger.compareAndSet(2, 3);
        System.out.println(b);
    }

    /**
     * 一个线程拿到锁，其他线程只能一直重试
     */
    public static void test2() {
        SpinLock spinLock = new SpinLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                spinLock.lock();

            }).start();

        }
    }
}
