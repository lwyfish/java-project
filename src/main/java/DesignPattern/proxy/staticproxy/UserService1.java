package DesignPattern.proxy.staticproxy;

/**
 * @author lwy
 * @date 2025/12/20 16:21
 **/
public class UserService1 implements IUserService {

    @Override
    public void getUserInfo() {
        System.out.println("UserService1");
    }

    public void getUserInfo2() {
        System.out.println("getUserInfo2");
    }
}
