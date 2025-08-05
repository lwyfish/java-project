package javabasic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型定义
 *
 * @author lwy
 * @date 2025/08/03 17:11
 **/
public class GenericDemo {

    public static void main(String[] args) {
        GenericClass01<Integer> genericClass01 = new GenericClass01(1);
        GenericClass02<String> genericClass02 = new GenericClass02();
        Integer integer = genericClass02.get(1);
        String s = genericClass02.get("123");

        ArrayList<? extends Number> list02 = new ArrayList<Integer>();

        PairHelper pairHelper = new PairHelper();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        pairHelper.addPair2(list);


    }
}
// 类的泛型
class GenericClass01 <T> {
    private T key;
    public GenericClass01(T key) {
        this.key = key;
    }
    public T getKey() {
        return this.key;
    }
}
class GenericClass02<T>{
    public static <E> E show(E e) {
        return null;
    }
    public <F> F get(F f) {
        System.out.println(f);
        return f;
    }
}

class GenericClass03 <T,E> {
    private T key;
    private E value;
    public GenericClass03(T key) {
        this.key = key;
    }
    public T getKey() {
        return this.key;
    }
}
interface Inter01<T>{
    void show(T t);
}
class PairHelper {
    static int addPair1(List<Number> p) {
        Number first = p.get(0);
        Number last = p.get(1);
        return first.intValue() + last.intValue();
    }
    static int addPair2(List<? extends Number> p) {
        Number first = p.get(0);
        Number last = p.get(1);
        return first.intValue() + last.intValue();
    }
}

class Test {
    public static void main(String[] args) {
        // 创建一个 ArrayList<? super Number> 集合
        ArrayList<Number> list = new ArrayList();
        // 往集合中添加 Number 类及其子类对象
        list.add(new Integer(1));
        list.add(new Float(1.1));
        // 调用 fillNumList() 方法，传入 ArrayList<Number> 集合
        fillNumList(list);
        System.out.println(list);
    }

    public static void fillNumList(ArrayList<? super Number> list) {
        list.add(new Integer(0));
        list.add(new Float(1.0));
    }
}

