package juc_learn;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，降级
 *
 * @author lwy
 * @date 2026/01/28 21:17
 **/
public class test7 {
    /**
     * 演示读写锁降级：先获取写锁，然后获取读锁，释放写锁，最后释放读锁
     * 这是一种典型的锁降级模式，在某些并发场景下可以提高性能
     */
    public static void main(String[] args) {
//        new test7().test();
        new test7().test2();

    }

    public void test() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

        // 获取写锁 - 此时其他线程不能获取读锁或写锁
        writeLock.lock();
        System.out.println("获取了写锁");

        // 在持有写锁的情况下获取读锁 - 这是允许的
        readLock.lock();
        System.out.println("在持有写锁的同时获取了读锁");

        // 释放写锁 - 此时仍持有读锁，其他线程可以获取读锁但不能获取写锁
        writeLock.unlock();
        System.out.println("释放了写锁，但仍持有读锁");

        // 释放读锁 - 最后完全释放锁
        readLock.unlock();
        System.out.println("释放了读锁");
    }

    public void test2() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        // 尝试获取读锁 - 由于没有其他写锁占用，这里可以成功获取
        readLock.lock();
        System.out.println("获取了读锁");

        // 尝试获取写锁 - 但由于当前线程已经持有读锁，而写锁是独占的，
        // 并且读锁也存在，所以这里会发生死锁，程序会阻塞
        // 注意：这与test方法中的降级不同，test是先写后读，这里是先读后写
        System.out.println("尝试获取写锁...");
        writeLock.lock();
        System.out.println("获取了写锁");

        // 在持有写锁的情况下获取读锁 - 这是允许的


        // 释放写锁 - 此时仍持有读锁，其他线程可以获取读锁但不能获取写锁
        writeLock.unlock();
        System.out.println("释放了写锁");

        // 释放读锁 - 最后完全释放锁
        readLock.unlock();
        System.out.println("释放了读锁");
    }
}
