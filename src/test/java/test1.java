import java.util.*;

/**
 * @author lwy
 * @date 2025/04/25 17:34
 **/
public class test1 {
    public static void main(String[] args) {
        test2();
        test3();
        String a = "123";
        test4(a);
        System.out.println(a);
    }

    public static void test2() {
        Map<String, String> map = null;
        if (map == null) {
            map = new HashMap<>();
        }
    }

    public static void test3() {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(4);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(5);
        a.retainAll(b);
        System.out.println(a);

        List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "b", "c"));
        List<String> list2 = new ArrayList<>(Arrays.asList("b", "c", "d"));

        list1.retainAll(list2);
        System.out.println(list1); // 输出: [b, b, c]
    }

    public static String test4(String text) {
        text = text + "...";
        return text;
    }
}
