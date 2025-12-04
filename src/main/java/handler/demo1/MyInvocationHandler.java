package handler.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    // 目标对象（被代理的原始对象）
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法执行前增强：日志记录
        System.out.println("调用方法：" + method.getName());
        System.out.println("参数：" + (args != null ? args[0] : "无"));

        // 执行目标方法
        Object result = method.invoke(target, args);

        // 方法执行后增强
        System.out.println("方法执行完成");
        return result;
    }
}