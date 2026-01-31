package juc_learn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程顺序控制，A->B->C
 *
 * @author lwy
 * @date 2026/01/25 15:21
 **/
public class test2 {
    public static void main(String[] args) {
        test2 test2 = new test2();
        Share share = test2.new Share();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    share.testAA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    share.testBB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    share.testCC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

    }

    class Share {
        private int flag = 1;
        private Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        public void testAA() throws InterruptedException {
            lock.lock();
            try {
                while (flag != 1) {
                    c1.await();
                }
                for (int i = 0; i < 1; i++) {
                    System.out.println(Thread.currentThread().getName() + "::" + i);
                }
                flag = 2;
                c2.signal();

            } finally {
                lock.unlock();
            }
        }

        public void testBB() throws InterruptedException {
            lock.lock();
            try {
                while (flag != 2) {
                    c2.await();
                }
                for (int i = 0; i < 2; i++) {
                    System.out.println(Thread.currentThread().getName() + "::" + i);
                }
                flag = 3;
                c3.signal();

            } finally {
                lock.unlock();
            }
        }

        public void testCC() throws InterruptedException {
            lock.lock();
            try {
                while (flag != 3) {
                    c3.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + "::" + i);
                }
                flag = 1;
                c1.signal();

            } finally {
                lock.unlock();
            }
        }

    }
}
