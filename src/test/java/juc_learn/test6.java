package juc_learn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lwy
 * @date 2026/01/28 20:47
 **/
public class test6 {

    class MyCache {
        private Map<String, Object> map = new HashMap<>();
        // 读写锁
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        /**
         * 放
         */
        public void put(String key, Object value) {
            readWriteLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "::" + "put " + key);
                // 暂停一会
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put(key, value);
                System.out.println(Thread.currentThread().getName() + "::" + "put " + key + " done");
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }

        /**
         * 取
         */
        public Object get(String key) {
            readWriteLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "::" + "get ");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "::" + "get " + " done");
                return map.get(key);
            } finally {
                readWriteLock.readLock().unlock();
            }
        }
    }

    /**
     * 加读写锁前：
     * 问题所在：还没有写完就已经读了
     * <p>
     * 加读写锁后：
     * 写锁：独占锁，读锁：共享锁
     * 保证先写完后再读
     *
     * @param args
     */
    public static void main(String[] args) {
        MyCache myCache = new test6().new MyCache();
        for (int i = 0; i < 7; i++) {
            int num = i;
            new Thread(() -> {
                myCache.put(String.valueOf(num), num);
            }).start();
        }

        for (int i = 0; i < 7; i++) {
            int num = i;
            new Thread(() -> {
                myCache.get(String.valueOf(num));
            }).start();
        }
    }
}
