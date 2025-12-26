package javabasic.abstractDemo.before;

// 一个包揽所有功能的“大而全”抽象类
public abstract class AbstractAllInOne {
    // 支付相关抽象方法
    public abstract void pay(double amount);

    // 日志相关抽象方法
    public abstract void log(String message);

    // 用户认证相关抽象方法
    public abstract boolean authenticate(String username, String password);
}
