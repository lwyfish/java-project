package javabasic.validator.demo2;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MsNotBlankValidator.class)
public @interface MsNotBlank {

    /**
     * 错误信息
     *
     * @return
     */
    String message() default "字段不能为空";

    /**
     * 分组
     *
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * 负载
     *
     * @return
     */
    Class<? extends Annotation>[] payload() default {};
}
