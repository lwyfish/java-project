package thread.syn;

import thread.create.InterruptDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 并发写入list
 *
 * @author lwy
 * @date 2025/08/07 16:09
 **/
public class demo1 {
    public static void main(String[] args) {
        while (true) {
            test();
        }
    }

    public static void test() {
        int count = 10000;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        List<Long> list = new ArrayList<>();
//        List<Long> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                long current = System.currentTimeMillis();
                list.add(current);
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
