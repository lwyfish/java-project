package interfaceDemo;

/**
 * 函数式
 * @author lwy
 * @date 2025/10/29 14:25
 **/
public class InterfaceDemo01 {
    public static void main(String[] args) {
        InterfaceDemo01 interfaceDemo01 = new InterfaceDemo01();
        interfaceDemo01.test1(() -> System.out.println(1));
    }

    public void test1(IExecutor executor) {
        executor.exec();
    }

    public interface IExecutor {
        void exec();
    }
}
