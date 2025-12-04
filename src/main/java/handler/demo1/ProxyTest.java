package handler.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 1. 目标对象
        UserService target = new UserServiceImpl();

        // 2. 创建InvocationHandler
        InvocationHandler handler = new MyInvocationHandler(target);

        // 3. 生成动态代理对象（JDK动态代理，基于接口）
        UserService proxy = (UserService) Proxy.newProxyInstance(
            target.getClass().getClassLoader(), // 类加载器
            target.getClass().getInterfaces(),  // 目标对象实现的接口
            handler                             // 调用处理器
        );

        // 4. 调用代理对象方法（触发InvocationHandler的invoke方法）
        proxy.getUser(100L);
    }
}