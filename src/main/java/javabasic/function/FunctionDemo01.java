package javabasic.function;

import java.util.function.Function;

public class FunctionDemo01 {
    public static void main(String[] args) {
        //定义一个字符串类型的整数
        String s = "1234";
        //调用change方法,传递字符串类型的整数,和Lambda表达式
        change(s, (String str) -> {
            //把字符串类型的整数,转换为Integer类型的整数返回
            return Integer.parseInt(str);
        });
        //优化Lambda
        change(s, str -> Integer.parseInt(str));
    }

    /**
     * 定义一个方法
     * 方法的参数传递一个字符串类型的整数
     * 方法的参数传递一个Function接口,泛型使用<String,Integer>
     * 使用Function接口中的方法apply,把字符串类型的整数,转换为Integer类型的整数
     */
    public static void change(String s, Function<String, Integer> fun) {
        // Integer in = fun.apply(s);
        int in = fun.apply(s);//自动拆箱 Integer->int
        System.out.println(in);
    }
}