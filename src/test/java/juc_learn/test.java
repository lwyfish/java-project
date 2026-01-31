package juc_learn;

import org.junit.Test;

/**
 * 3
 *
 * @author lwy
 * @date 2025/09/20 11:02
 **/
public class test {


    @Test
    public void test1() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa").start();
    }

    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        // 设置为守护线程
        aa.setDaemon(true);
        aa.start();
    }

    @Test
    public void test() {
        // 3个售票员卖出30张票
        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (ticket.hasTicket()) {
                    ticket.sale();
                }
            }, "售票员" + i).start();
        }

    }

    class Ticket {
        private int number = 30;

        public synchronized void sale() {
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

        public boolean hasTicket() {
            return number > 0;
        }

    }


}
