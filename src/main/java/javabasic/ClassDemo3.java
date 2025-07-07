package javabasic;

/**
 * 测试
 *
 * @author lwy
 * @date 2025/04/30 11:14
 **/
public class ClassDemo3 {
    private int a;
    private static int b;

    public ClassDemo3() {
        Class<? extends ClassDemo3> aClass = this.getClass();
        System.out.println(aClass.getName());
    }

    public static void main(String[] args) {
        ClassDemo3 classDemo3 = new ClassDemo3();
    }


}
