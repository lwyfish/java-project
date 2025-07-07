package javabasic.abstractDemo;

/**
 * xxx
 *
 * @author lwy
 * @date 2025/05/30 17:35
 **/
public class abstractDemo1 {
    public static void main(String[] args) {

    }

    public interface IExecutor {
        public static final int a = 0;

        public abstract void execute();
    }

    public class A implements IExecutor{
        @Override
        public void execute() {
            System.out.println("a");
        }
    }

    public abstract class Template {
        public abstract void execute();

        public void run() {
            System.out.println("start");
        }
    }
}
