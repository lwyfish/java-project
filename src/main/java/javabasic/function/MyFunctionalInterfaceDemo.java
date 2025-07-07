package javabasic.function;

/**
 * 函数式接口:有且只有一个抽象方法的接口,称之为函数式接口
 *
 * @FunctionalInterface注解作用:可以检测接口是否是一个函数式接口
 */
public class MyFunctionalInterfaceDemo {

    /**
     * 接口
     */
    @FunctionalInterface
    public interface MyFunctionalInterface {
        /**
         * 定义一个抽象方法
         */
        public abstract void method();

    }

    //定义一个方法,参数使用函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface myInter) {
        myInter.method();
    }

    public static void main(String[] args) {
        //调用show方法,方法的参数是一个接口,所以我们可以传递接口的匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        //调用show方法,方法的参数是一个函数式接口,所以我们可以Lambda表达式
        show(() -> {
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });

        //简化Lambda表达式
        show(() -> System.out.println("使用Lambda表达式重写接口中的抽象方法"));
    }
}