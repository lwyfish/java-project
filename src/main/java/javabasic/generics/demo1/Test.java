package javabasic.generics.demo1;

/**
 * @author lwy
 * @date 2025/09/08 15:38
 **/
public class Test {
    public static void main(String[] args) {
        ChildFirst<String> stringChildFirst = new ChildFirst<>();
        stringChildFirst.setValue("abc");

        ChildSecond childSecond = new ChildSecond();
        childSecond.setValue(123);

    }
}
