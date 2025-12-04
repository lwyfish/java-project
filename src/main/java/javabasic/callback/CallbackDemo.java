package javabasic.callback;

// 回调接口
interface Callback {
    void onComplete(String result);
}

// 执行某些工作的类
class Worker {
    public void doWork(Callback callback) {
        System.out.println("开始执行工作...");

        // 模拟工作执行（成功或失败）
        boolean success = Math.random() > 0.5;

        try {
            Thread.sleep(1000); // 模拟耗时操作
        } catch (InterruptedException e) {
            return;
        }

        if (success) {
            callback.onComplete("工作成功完成!");
        } else {
            callback.onComplete("工作执行失败");
        }
    }
}

// 使用回调的类
public class CallbackDemo {
    public static void main(String[] args) {
        Worker worker = new Worker();

        // 创建回调实现
        // 执行工作并传递回调
        worker.doWork(new Callback() {
            @Override
            public void onComplete(String result) {
                System.out.println("回调结果: " + result);
            }
        });

        System.out.println("主线程继续执行...");
    }
}