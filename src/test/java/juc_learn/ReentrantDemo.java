package juc_learn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 *
 * @author lwy
 * @date 2026/01/25 17:06
 **/
public class ReentrantDemo {
    public static void main(String[] args) {
        ReentrantDemo ReentrantDemo = new ReentrantDemo();
        ReentrantDemo.testSync();
        ReentrantDemo.testLock();
    }

    public void testSync() {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + "外层");
                synchronized (o) {
                    System.out.println(Thread.currentThread().getName() + "内层");
                }
            }
        }, "t1").start();
    }

    public void testLock() {
        // 重复获取锁有一个加锁计数器，同一个对象获取同一个锁时+1，离开时-1，到0就完全释放锁
        Lock lock = new ReentrantLock();
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "外层");

                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "内层");
                } finally {
                    // 如果不归还会导致t3线程阻塞
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 1");

            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 2");

            } finally {
                lock.unlock();
            }
        }, "t3").start();
    }
}
