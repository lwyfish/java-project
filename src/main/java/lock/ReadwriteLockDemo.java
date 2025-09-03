package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * @author lwy
 * @date 2025/08/28 17:15
 **/
public class ReadwriteLockDemo {
    private final static ReadWriteLock lock = new ReentrantReadWriteLock();
    private final static Map<String, String> config = new HashMap<>();

    public static String getConfig(String key) {
        // 读锁
        lock.readLock().lock();
        try {
            return config.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void updateConfig(String key, String value) {
        // 写锁
        lock.writeLock().lock();
        try {
            config.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        // 多线程获取
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String config = getConfig("11");
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    updateConfig("11","123");
                }
            }).start();
        }
    }
}

