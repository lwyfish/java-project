package javabasic.function;

import java.util.function.Supplier;


public class SupplierDemo {

    public static void main(String[] args) {
        String s0 = getString(new Supplier<String>() {
            @Override
            public String get() {
                return "zjq666";
            }
        });
        System.out.println(s0);
        //调用getString方法,方法的参数Supplier是一个函数式接口,所以可以传递Lambda表达式
        String s = getString(() -> {
            //生产一个字符串,并返回
            return "zjq666";
        });
        System.out.println(s);

        //优化Lambda表达式
        String s2 = getString(() -> "zjq666");
        System.out.println(s2);
    }

    //定义一个方法,方法的参数传递Supplier<T>接口,泛型执行String,get方法就会返回一个String
    public static String getString(Supplier<String> sup) {
        return sup.get();
    }

}