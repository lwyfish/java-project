package javabasic.queue;

import java.util.concurrent.*;

// 1. 定义延迟元素，必须实现Delayed接口
class DelayedItem<T> implements Delayed {
    private final T item;
    private final long expireTime; // 到期时间戳(毫秒)

    public DelayedItem(T item, long delayMillis) {
        this.item = item;
        this.expireTime = System.currentTimeMillis() + delayMillis;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // 返回剩余延迟时间
        long remaining = expireTime - System.currentTimeMillis();
        return unit.convert(remaining, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        // 按到期时间排序
        return Long.compare(this.expireTime, ((DelayedItem<?>)o).expireTime);
    }
    
    public T getItem() {
        return item;
    }
}

// 2. 使用示例
public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedItem<String>> queue = new DelayQueue<>();
        
        // 添加延迟元素
        queue.put(new DelayedItem<>("Task1", 5000)); // 5秒后可用
        queue.put(new DelayedItem<>("Task2", 2000)); // 2秒后可用
        queue.put(new DelayedItem<>("Task3", 8000)); // 8秒后可用

        // 消费元素(会阻塞等待)
        while (!queue.isEmpty()) {
            DelayedItem<String> item = queue.take();
            System.out.printf("[%tT] consumer: %s%n", System.currentTimeMillis(), item.getItem());
        }
    }
}