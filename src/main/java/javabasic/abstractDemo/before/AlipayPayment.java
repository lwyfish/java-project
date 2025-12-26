package javabasic.abstractDemo.before;

// 子类只想实现支付，却被迫实现日志、认证（即使不需要）
public class AlipayPayment extends AbstractAllInOne {
    @Override
    public void pay(double amount) {
        System.out.println("支付宝支付：" + amount);
    }

    // 无用的实现，被迫重写
    @Override
    public void log(String message) {}

    // 无用的实现，被迫重写
    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }
}