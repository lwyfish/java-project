package thread.create;

/**
 * 打断
 *
 * @author lwy
 * @date 2025/08/07 10:17
 **/
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
        System.out.println(" 打断状态: {}" + t1.isInterrupted());// 打断状态: {}false
    }
}
