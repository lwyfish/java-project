package javabasic.abstractDemo.after;

/**
 * @author lwy
 * @date 2025/12/26 16:59
 **/
public class AliPayment extends AbstractPayment {
    //    @Override
//    public void pay(double amount) {
//        System.out.println("使用支付宝支付：" + amount + "元");
//    }
    @Override
    public void pay(double amount) {
        // 继承基础类的通用配置
        super.initConfig();
        // 继承支付抽象类的余额检查
        super.checkBalance(amount);

        // 核心业务逻辑
        System.out.println("支付宝支付：" + amount + " 元");

        // 继承并使用定制化的日志方法
        super.log("支付宝支付成功，金额：" + amount);
    }
}
