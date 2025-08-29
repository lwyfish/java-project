package thread;

public class InterruptedExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("线程正在运行...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("在sleep时被中断，中断状态: " + Thread.interrupted());
                    Thread.currentThread().interrupt(); // 重新设置中断状态
                    break;
                }
            }
            System.out.println("线程退出，最终中断状态: " + Thread.interrupted());
        });
        
        thread.start();
        
        try {
            Thread.sleep(3000);
            thread.interrupt();
            System.out.println("已发送中断信号");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}