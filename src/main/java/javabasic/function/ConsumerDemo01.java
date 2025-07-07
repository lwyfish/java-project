package javabasic.function;

import java.util.function.Consumer;

/**
 * Consumer（消费型），Supplier（供给型）、Predicate（判断型）与Function（转换型）
 */
public class ConsumerDemo01 {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        Consumer consumer1 = i -> System.out.println(i);

        //调用method方法,传递字符串姓名,方法的另一个参数是Consumer接口,是一个函数式接口,所以可以传递Lambda表达式
        method("zjq666", (String name) -> {
            //对传递的字符串进行消费
            //消费方式:直接输出字符串
            System.out.println(name);

            //消费方式:把字符串进行反转输出
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });

        method("zjq666", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    /**
     * 定义一个方法
     * 方法的参数传递一个字符串的姓名
     * 方法的参数传递Consumer接口,泛型使用String
     * 可以使用Consumer接口消费字符串的姓名
     */
    public static void method(String name, Consumer<String> con) {
        con.accept(name);
    }
}