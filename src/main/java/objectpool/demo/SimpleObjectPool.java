package objectpool.demo;

import javabasic.reflection.User;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleObjectPool<T> {
    // 空闲对象队列
    private final Queue<T> idleQueue = new LinkedList<>();
    private final ObjectFactory<T> factory;
    // 最大对象总数
    private final int maxTotal;
    // 当前已创建对象总数
    private int activeCount = 0;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public SimpleObjectPool(ObjectFactory<T> factory, int maxTotal) {
        this.factory = factory;
        this.maxTotal = maxTotal;
    }

    /**
     * 获取对象，带超时
     */
    public T borrowObject(long timeout, TimeUnit unit) throws InterruptedException {
        lock.lock();
        try {
            long remainNanos = unit.toNanos(timeout);
            for (; ; ) {
                // 1. 优先拿空闲对象
                if (!idleQueue.isEmpty()) {
                    T obj = idleQueue.poll();
                    // 校验有效性，无效直接销毁重试
                    if (factory.isValid(obj)) {
                        return obj;
                    } else {
                        factory.destroy(obj);
                        activeCount--;
                    }
                }
                // 2. 还能新建对象
                if (activeCount < maxTotal) {
                    activeCount++;
                    return factory.create();
                }
//                // 3. 达到上限，等待归还
//                if (remainNanos <= 0) {
//                    return null; // 获取超时
//                }
//                remainNanos = condition.awaitNanos(remainNanos);
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 归还对象
     */
    public void returnObject(T obj) {
        if (obj == null) return;
        lock.lock();
        try {
            // 重置对象状态，成功则放回队列；失败直接销毁
            if (factory.reset(obj)) {
                idleQueue.offer(obj);
                condition.signal(); // 唤醒等待获取对象的线程
            } else {
                factory.destroy(obj);
                activeCount--;
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 销毁失效对象
     */
    public void invalidateObject(T obj) {
        lock.lock();
        try {
            factory.destroy(obj);
            activeCount--;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public int getActiveCount() {
        lock.lock();
        try {
            return activeCount - idleQueue.size();
        } finally {
            lock.unlock();
        }
    }

    public int getIdleCount() {
        lock.lock();
        try {
            return idleQueue.size();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SimpleObjectPool<User> userSimpleObjectPool = new SimpleObjectPool<User>(new ObjectFactory<User>() {
            @Override
            public User create() {
                return new User();
            }

            @Override
            public boolean reset(User obj) {
                return false;
            }

            @Override
            public void destroy(User obj) {

            }

            @Override
            public boolean isValid(User obj) {
                return false;
            }
        }, 1);


        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    User user = userSimpleObjectPool.borrowObject(1, TimeUnit.SECONDS);
                    System.out.println(user);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
