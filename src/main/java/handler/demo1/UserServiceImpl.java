package handler.demo1;

public class UserServiceImpl implements UserService {
    @Override
    public void getUser(Long id) {
        System.out.println("查询用户ID：" + id);
    }
}