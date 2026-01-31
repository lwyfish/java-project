package juc_learn;

import cn.hutool.core.collection.ConcurrentHashSet;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lwy
 * @date 2026/01/25 15:37
 **/
public class test3 {
    public static void main(String[] args) {
        test3 test3 = new test3();
        test3.setNotSafe();
    }
    public void listNotSafe(){
//        List<String> list = new ArrayList<>();
//        List<String> list1 = Collections.synchronizedList(list);
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 3000; i++) {
            new Thread(()  -> {
                list1.add(UUID.randomUUID().toString());
                System.out.println(list1);
            }).start();
        }
    }

    public void setNotSafe(){
//        Set<String> set = new HashSet<>();
        ConcurrentHashSet<String> set = new ConcurrentHashSet<>();
        for (int i = 0; i < 3000; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString());
                System.out.println(set);
            }).start();
        }
    }

}
