package javabasic.validator.demo1;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.annotation.Annotation;
import java.util.Set;

public class ValidationDemo {

    public void test1() {
        User user = new User();
        Annotation[] annotations = user.getClass().getAnnotations();
        MsObject msObject = user.getClass().getAnnotation(MsObject.class);
        String test = msObject.test();
        System.out.println(test);
        System.out.println(annotations);

    }
    public void test() {
        // 1. 获取校验器工厂
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // 场景 1：新增用户（触发 AddGroup 分组校验）
        User addUser = new User();
        addUser.setUsername(null); // 违反 AddGroup 规则
        addUser.setPassword(null); // 违反 AddGroup 规则
        addUser.setEmail("test@example.com");

        Set<javax.validation.ConstraintViolation<User>> addViolations = validator.validate(addUser, AddGroup.class);
        System.out.println("新增用户校验结果：");
        addViolations.forEach(v -> System.out.println(v.getMessage()));
        // 输出：
        // 用户名不能为空
        // 新增用户时密码不能为空

        // 场景 2：更新用户（触发 UpdateGroup 分组校验）
        User updateUser = new User();
        updateUser.setId(null); // 违反 UpdateGroup 规则
        updateUser.setUsername("zhangsan");
        updateUser.setPassword("123456");
        updateUser.setEmail(null); // 属于 Default 分组，UpdateGroup 不触发

        Set<javax.validation.ConstraintViolation<User>> updateViolations = validator.validate(updateUser, UpdateGroup.class);
        System.out.println("\n更新用户校验结果：");
        updateViolations.forEach(v -> System.out.println(v.getMessage()));
        // 输出：
        // 更新用户时ID不能为空

        // 场景 3：触发 Default 分组（无 groups 的字段）
        User defaultUser = new User();
        defaultUser.setEmail(null); // 违反 Default 规则
        Set<javax.validation.ConstraintViolation<User>> defaultViolations = validator.validate(defaultUser);
        System.out.println("\n默认分组校验结果：");
        defaultViolations.forEach(v -> System.out.println(v.getMessage()));
        // 输出：
        // 邮箱不能为空
    }
    public static void main(String[] args) {
        ValidationDemo validationDemo = new ValidationDemo();
        validationDemo.test();
        validationDemo.test1();

    }
}