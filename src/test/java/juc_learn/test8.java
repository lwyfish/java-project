package juc_learn;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * blockingqueue
 * @author lwy
 * @date 2026/01/29 14:55
 **/
public class test8 {
    public static void main(String[] args) {
        new test8().test();
    }
    public void test() {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        arrayBlockingQueue.add("1");
        arrayBlockingQueue.add("1");
        try {
            arrayBlockingQueue.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
