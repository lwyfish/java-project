package javabasic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 测试
 *
 * @author lwy
 * @date 2025/04/30 11:14
 **/
public class demo2 {
    private int a;
    private static int b;

    public static void main(String[] args) {
        demo2 demo2 = new demo2();
//        System.out.println(demo2.a);
//        System.out.println(b);
        demo2.test();

        List<Long> list = new ArrayList<>();
        list.add(1111L);
        list.add(1112L);
        list.add(1113L);
        list.add(1115L);
        list.sort(Long::compareTo);
        System.out.println(list);

    }

    public void test() {
        String a = "aaa-perf-000-109";
        String b = "aaa-perf-000-0-109";
        String[] split = b.split("-");
        boolean b1 = split[split.length - 2].length() == 1;

        System.out.println(b1);

        System.out.println(a);
    }
}
