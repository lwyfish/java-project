package juc_learn;

import org.aspectj.weaver.ast.Call;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author lwy
 * @date 2026/01/25 17:32
 **/
public class test4 {
    public static void main(String[] args) {
        new test4().test();
    }

    public void test() {
//        new Thread(new MyThread()).start();
        FutureTask futureTask = new FutureTask(new MyCallable());
        new Thread(futureTask).start();

        try {
            String s = (String) futureTask.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("Callable start.");
            return "aaa";
        }
    }
}
