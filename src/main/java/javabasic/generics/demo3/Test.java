package javabasic.generics.demo3;

import java.util.ArrayList;

/**
 * @author lwy
 * @date 2025/09/08 17:22
 **/
public class Test {
    public static void main(String[] args) {
        MethodDemo<String> demo = new MethodDemo<>();
        String s = demo.testMethod1(new String("123"));
        System.out.println(s);

        MethodDemo.printType(123,2,3);
        MethodDemo.getValue(444);


        ArrayList<? extends Number> list = new ArrayList<>();
//        list.add(new Integer(1));// 编译错误
//        list.add(new Float(1.0));// 编译错误
//        list.add(new Number() {
//            @Override
//            public int intValue() {
//                return 0;
//            }
//
//            @Override
//            public long longValue() {
//                return 0;
//            }
//
//            @Override
//            public float floatValue() {
//                return 0;
//            }
//
//            @Override
//            public double doubleValue() {
//                return 0;
//            }
//        })
        // 那为什么还需要引入上界统配符的概念？---- 答：是为了拓展方法形参中类型参数的范围。

    }
}
