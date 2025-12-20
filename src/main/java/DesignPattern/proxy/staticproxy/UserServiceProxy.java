package DesignPattern.proxy.staticproxy;

/**
 * @author lwy
 * @date 2025/12/20 16:22
 **/
public class UserServiceProxy implements IUserService {
    private IUserService userService;

    public UserServiceProxy(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void getUserInfo() {
        System.out.println("UserServiceProxy before");
        userService.getUserInfo();
        System.out.println("UserServiceProxy after");
    }
}
