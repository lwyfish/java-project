package javabasic.generics.demo3;

import java.util.ArrayList;
import java.util.List;

public class MethodDemo<U> {
    // 该方法只是使用了泛型类定义的类型参数，不是泛型方法
    public void testMethod(U u) {
        System.out.println(u);
    }

    // <T> 真正声明了下面的方法是一个泛型方法
    public <T> T testMethod1(T t) {
        return t;
    }

    /**
     * 静态的泛型方法，采用多个泛型类型
     *
     * @param t
     * @param e
     * @param k
     * @param <T>
     * @param <E>
     * @param <K>
     */
    public static <T, E, K> void printType(T t, E e, K k) {
        System.out.println(t + "\t" + t.getClass().getSimpleName());
        System.out.println(e + "\t" + e.getClass().getSimpleName());
        System.out.println(k + "\t" + k.getClass().getSimpleName());
    }


    public static <T extends Number> void getValue(T t) {
        int i = t.intValue();
        System.out.println(i);
    }

    /**
     * extends指定上界，可读，但不可写
     * 不可写原因：无法指定extends Integer还是extends Long
     * @param t
     * @param <T>
     */
    public static <T> void getValue2(List<? extends Number> t) {
//        t.add(123); // 编译报错
        Number number = t.get(0);
    }

    /**
     * super指定下届，可写入，但不可读
     * @param t
     * @param <T>
     */
    public static <T> void getValue3(List<? super Number> t) {
        t.add(123);
        t.add(211L);
        t.get(0);
    }

    public static void main(String[] args) {
//        List<Object> list = new ArrayList<>();
//        MethodDemo.getValue2(list); // 编译错误，因为指定了上界
    }
}
