package javabasic.abstractDemo.after;

/**
 * @author lwy
 * @date 2025/12/26 16:57
 **/
public abstract class AbstractPayment extends BaseAbstractComponent {

    // 支付相关抽象方法
    public abstract void pay(double amount);

    // 支付专属默认方法（可选重写）
    public void checkBalance(double amount) {
        System.out.println("检查余额：" + amount + " 元");
    }

    // 可选：重写基础类的日志方法，定制支付场景的日志
    @Override
    public void log(String message) {
        System.out.println("[支付日志] " + message);
    }
}
