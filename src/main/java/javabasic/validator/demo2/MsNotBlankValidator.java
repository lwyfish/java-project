package javabasic.validator.demo2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 验证类
 *
 * @author lwy
 * @date 2025/12/09 14:06
 **/
public class MsNotBlankValidator implements ConstraintValidator<MsNotBlank, CharSequence> {
    @Override
    public void initialize(MsNotBlank constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            // 校验失败
            return false;
        }
        return value.toString().trim().length() > 0;
    }
}
