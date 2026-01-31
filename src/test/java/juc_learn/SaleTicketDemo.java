package juc_learn;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个售票员卖出30张票
 *
 * @author lwy
 * @date 2026/01/25 11:19
 **/
public class SaleTicketDemo {
    public static void main(String[] args) {
        new SaleTicketDemo().test();
    }

    public void test() {
        // 3个售票员卖出30张票
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (ticket.hasTicket()) {
//                    ticket.saleSyn();
                    ticket.saleLock();
                    // 线程 A 拿到 synchronized 锁执行 saleSyn() 时，
                    // 线程 B 仍能拿到 Lock 锁执行 saleLock()，两者同时修改 number；
                }
                System.out.println(Thread.currentThread().getName() + "售完票了");
            }, "售票员" + i).start();
        }
    }

    class Ticket {
        private int number = 30;
        private final Lock lock = new ReentrantLock(true);

        /**
         * 使用synchronized
         */
        public void saleSyn() {
            /**
             * 锁对象是同一个：你创建了 1 个 Ticket task 对象，然后把它传给 3 个售票员线程。
             * 这意味着 3 个线程看到的 this 都是同一个 task 对象—— 它们争抢的是同一把 “锁钥匙”。
             */
            synchronized (this) {
                if (number > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + number + "张票");
                    number--;
                }
            }

        }

        public void saleLock() {
            // 不要把lock放在这里，要放在变量中，这样锁对象是同一个
            // private Lock lock = new ReentrantLock();

            try {
                lock.lock();
                if (number > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + number + "张票");
                    number--;
                }
            } finally {
                lock.unlock();
            }
        }

        public boolean hasTicket() {
            return number > 0;
        }

    }
}
