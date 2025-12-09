package javabasic.validator.demo1;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MsObject {

    String test() default "test";

}
