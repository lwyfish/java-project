package javabasic.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock锁
 *
 * @author lwy
 * @date 2025/08/06 13:47
 **/
public class ReentrantLockdemo1 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println("first get lock");
            lock.lock();
            try {
                System.out.println("second get lock");
            } finally {

            }
        } finally {
            lock.unlock();
        }
    }
}
