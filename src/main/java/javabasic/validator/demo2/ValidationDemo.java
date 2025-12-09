package javabasic.validator.demo2;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.annotation.Annotation;
import java.util.Set;

public class ValidationDemo {
    public void test() {
        // 1. 获取校验器工厂
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User addUser = new User();
        addUser.setUsername(null); // 违反 AddGroup 规则
        addUser.setPassword(null); // 违反 AddGroup 规则
        addUser.setEmail("test@example.com");

        Set<javax.validation.ConstraintViolation<User>> addViolations = validator.validate(addUser);
        System.out.println("新增用户校验结果：");
        for (javax.validation.ConstraintViolation<User> violation : addViolations) {
            Annotation annotation = violation.getConstraintDescriptor().getAnnotation();
            System.out.println(violation.getMessage());
        }
    }

    public static void main(String[] args) {
        ValidationDemo validationDemo = new ValidationDemo();
        validationDemo.test();
    }
}