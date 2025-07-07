package javabasic.exception;

/**
 * 异常处理
 *
 * @author lwy
 * @date 2025/04/17 15:00
 **/
public class TryCatchDemo01 {
    Exception a = new Exception();

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int a;
        try {
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                System.out.println("catch");
                throw new RuntimeException();
            }
        } catch (Exception e) {
            System.out.println("catch2");
        } finally {
            a = 0;
        }

    }
}
