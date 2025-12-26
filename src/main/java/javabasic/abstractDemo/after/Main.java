package javabasic.abstractDemo.after;

/**
 * @author lwy
 * @date 2025/12/26 17:03
 **/
public class Main {
    public static void main(String[] args) {
        AbstractPayment payment = new AliPayment();
        payment.pay(100);
    }
}
