package javabasic.abstractDemo.after;

/**
 * 基础抽象类：封装所有模块的通用能力
 *
 * @author lwy
 * @date 2025/12/26 16:56
 **/
public abstract class BaseAbstractComponent {
    // 通用日志方法（所有子类都能继承/重写）
    public abstract void log(String message);

    // 通用配置方法（提供默认实现，子类可选择性重写）
    public void initConfig() {
        System.out.println("初始化通用配置：加载基础参数");
    }

}
