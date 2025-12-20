package DesignPattern.proxy.staticproxy;

/**
 * @author lwy
 * @date 2025/12/20 16:23
 **/
public class Test1 {
    public static void main(String[] args) {
        UserServiceProxy userServiceProxy = new UserServiceProxy(new UserService1());
        userServiceProxy.getUserInfo();
    }
}
