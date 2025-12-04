package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * notify
 *
 * @author lwy
 * @date 2025/10/29 19:51
 **/
public class NotifyDemo2 {
//    public static void main(String[] args) throws InterruptedException {
//        List<String> list = new ArrayList<>();
//        // 启动10个个线程
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                synchronized (list) {
//                    list.add("123");
//                }
//            }).start();
//        }
//    }
    public static void main(String[] args) throws InterruptedException {
        // 启动10个个线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
            }).start();
        }
    }
}
