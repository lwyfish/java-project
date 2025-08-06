package javabasic.function;

import java.util.function.Predicate;

public class PredicateDemo01 {
    public static void main(String[] args) {
        //定义一个字符串
        String s = "abcdef";

        //调用checkString方法对字符串进行校验,参数传递字符串和Lambda表达式
        /**boolean b = checkString(s,(String str)->{
         //对参数传递的字符串进行判断,判断字符串的长度是否大于5,并把判断的结果返回
         return str.length()>5;
         });*/

        //优化Lambda表达式
        checkString(s, str -> str.length() > 5);

        checkString(s, new Predicate<String>() {

            @Override
            public boolean test(String s) {
                return s.length() > 5;
            }
        });
    }

    /**
     * 定义一个方法
     * 参数传递一个String类型的字符串
     * 传递一个Predicate接口,泛型使用String
     * 使用Predicate中的方法test对字符串进行判断,并把判断的结果返回
     */
    public static void checkString(String s, Predicate<String> pre) {
        System.out.println("checkString方法被调用");
        boolean test = pre.test(s);
        if (test) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}