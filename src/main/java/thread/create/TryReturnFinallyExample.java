package thread.create;

public class TryReturnFinallyExample {
    public static int testMethod() {
        int result = 0;
        try {
            System.out.println("进入 try 块");
            result = 10;
            return result;
        } catch (Exception e) {
            System.out.println("捕获到异常: " + e.getMessage());
        } finally {
            System.out.println("进入 finally 块");
            result = 20;
            System.out.println("finally 块中修改 result 的值为: " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        int value = testMethod();
        System.out.println("方法返回的值是: " + value);
    }
}    