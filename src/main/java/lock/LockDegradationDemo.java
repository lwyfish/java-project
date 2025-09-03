package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁的降级：在不释放当前持有的写锁的情况下，同时获取读锁，随后再释放写锁的过程。
 */
public class LockDegradationDemo {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();
    private volatile boolean dataUpdated = false; // 示例数据
    private int data = 0; // 示例数据

    public void processData() {
        // 1. 获取读锁，检查条件
        readLock.lock();
        if (!dataUpdated) {
            // 条件不满足，必须先释放读锁，因为无法直接升级为写锁
            readLock.unlock();
            
            // 2. 获取写锁
            writeLock.lock();
            try {
                // 再次检查条件，因为可能在释放读锁和获取写锁之间，条件已被其他线程改变
                if (!dataUpdated) {
                    // 修改数据
                    data = 100;
                    dataUpdated = true;
                }
                // 3. ！！！在释放写锁之前，先获取读锁！！！（锁降级开始）
                readLock.lock();
            } finally {
                // 4. 释放写锁（锁降级完成，此时线程只持有读锁）
                writeLock.unlock();
            }
        }

        try {
            // 5. 使用读锁来读取数据，此时数据一定是最新且不会被其他写线程修改
            System.out.println("Data is: " + data);
        } finally {
            // 6. 最终释放读锁
            readLock.unlock();
        }
    }
}