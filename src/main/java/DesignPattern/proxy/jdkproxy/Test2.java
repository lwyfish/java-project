package DesignPattern.proxy.jdkproxy;

import DesignPattern.proxy.staticproxy.IUserService;
import DesignPattern.proxy.staticproxy.UserService1;

import java.lang.reflect.Proxy;

/**
 * 定义一个接口及其实现类；
 * 自定义 InvocationHandler 并重写invoke方法，在 invoke 方法中我们会调用原生方法（被代理类的方法）并自定义一些处理逻辑；
 * 通过 Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h) 方法创建代理对象;
 * 原文链接：https://javaguide.cn/java/basis/proxy.html
 *
 * 总结：只能强转成接口，不能转成接口的实现类。必须有接口的实现类
 * @author lwy
 * @date 2025/12/20 16:33
 **/
public class Test2 {
    public static void main(String[] argsInput) {
        IUserService proxy = new Test2().getjdkProxy();
        proxy.getUserInfo();
    }
    public IUserService getjdkProxy() {
        UserService1 userService = new UserService1();
        return (IUserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("UserServiceProxy before");
                    Object result = method.invoke(userService, args);
                    System.out.println("UserServiceProxy after");
                    return result;
                }
        );
    }
}
