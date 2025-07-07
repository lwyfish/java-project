package javabasic.gc;

import java.util.ArrayList;
import java.util.List;

public class GCDemo {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        // 循环创建大对象，触发 GC
        for (int i = 0; i < 1000; i++) {
            list.add(new byte[1024 * 1024]); // 每次创建 1MB 对象

            if (i % 100 == 0) {
                System.out.println("Created " + i + " MB");
            }
        }
    }
}