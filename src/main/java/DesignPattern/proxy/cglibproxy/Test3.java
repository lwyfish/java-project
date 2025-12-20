package DesignPattern.proxy.cglibproxy;

import DesignPattern.proxy.staticproxy.UserService1;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 定义一个类；
 * 自定义 MethodInterceptor 并重写 intercept 方法，intercept 用于拦截增强被代理类的方法，和 JDK 动态代理中的 invoke 方法类似；
 * 通过 Enhancer 类的 create()创建代理类
 * 原文链接：https://javaguide.cn/java/basis/proxy.html
 *
 * 总结：给一个类中的每一个方法都执行了动态代理
 * @author lwy
 * @date 2025/12/20 17:14
 **/
public class Test3 {
    public Object getCglibProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //调用方法之前，我们可以添加自己的操作
                System.out.println("before method " + method.getName());
                Object object = methodProxy.invokeSuper(o, args);
                //调用方法之后，我们同样可以添加自己的操作
                System.out.println("after method " + method.getName());
                return object;
            }
        });
        // 创建代理类
        return enhancer.create();
    }

    public static void main(String[] args) {
        UserService1 userService1 = (UserService1) new Test3().getCglibProxy(UserService1.class);
        userService1.getUserInfo();
        userService1.getUserInfo2();
    }
}
