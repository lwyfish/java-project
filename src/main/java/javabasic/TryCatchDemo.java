package javabasic;

/**
 * try catch
 *
 * @author lwy
 * @date 2025/07/31 15:59
 **/
public class TryCatchDemo {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        try {
            test2();
        } catch (Exception e2) {
            // 只能处理runtimeException
            throw e2;
        }
    }

    private static void test2() {
        try {
            int a = 3 / 0;
        } catch (ArithmeticException e) {
            // 处理ArithmeticException异常
            throw new RuntimeException("error");
        } catch (Exception e) {
            // 处理其他异常，保底
            throw new RuntimeException("error test2");
        }
    }
}
