package juc_learn;

import org.yaml.snakeyaml.nodes.CollectionNode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有两个线程，实现对一个初始值是0的变量，一个线程对值+1，另一个-1，交替执行
 *
 * @author lwy
 * @date 2026/01/25 11:56
 **/
public class test1 {
    public static void main(String[] args) {
        Share share = new test1().new Share();
        new Thread(() -> {
            while (true) {
                try {
                    // share不能再这里创建线程，因为share是线程共享的，不能再多个线程中创建share对象
//                        Share share = new test1().new Share();
//                    share.increment();
                    share.incrementLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            while (true) {
                try {
                    // share不能再这里创建线程，因为share是线程共享的，不能再多个线程中创建share对象
//                        Share share = new test1().new Share();
//                    share.decrement();
                    share.decrementLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            while (true) {
                try {
                    // share不能再这里创建线程，因为share是线程共享的，不能再多个线程中创建share对象
//                        Share share = new test1().new Share();
//                    share.increment();
                    share.incrementLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            while (true) {
                try {
                    // share不能再这里创建线程，因为share是线程共享的，不能再多个线程中创建share对象
//                        Share share = new test1().new Share();
//                    share.decrement();
                    share.decrementLock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }

    class Share {
        private int number;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void change() {
            if (number == 0) {
                number++;
            } else if (number == 1) {
                number--;
            }
        }

        public synchronized void increment() throws InterruptedException {
            if (number == 0) {
                number++;
                System.out.println(Thread.currentThread().getName() + "::" + number);
                // 通知其他线程
                notify();
            } else {
                // 不是0就等待
                wait();
            }
        }

        public synchronized void decrement() throws InterruptedException {
            if (number == 1) {
                number--;
                System.out.println(Thread.currentThread().getName() + "::" + number);
                // 通知其他线程
                notify();

            } else {
                wait();
            }
        }

        public void incrementLock() throws InterruptedException {
            try {
                lock.lock();
                if (number == 0) {
                    number++;
                    System.out.println(Thread.currentThread().getName() + "::" + number);
                    // 通知其他线程
                    condition.signalAll();
                } else {
                    // 不是0就等待
                    condition.await();
                }
            } finally {
                lock.unlock();
            }
        }

        public void decrementLock() throws InterruptedException {
            try {
                lock.lock();
                if (number == 1) {
                    number--;
                    System.out.println(Thread.currentThread().getName() + "::" + number);
                    // 通知其他线程
                    condition.signalAll();
                } else {
                    condition.await();
                }

            } finally {
                lock.unlock();
            }
        }
    }

}
