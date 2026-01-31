package learn.spring_boot.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class PriceValidator implements ConstraintValidator<ValidPrice, BigDecimal> {
    private final int MIN_PRICE = 6500;
    @Override
    public void initialize(ValidPrice constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return false;
        return value.doubleValue() >= this.MIN_PRICE && value.doubleValue() <= 10_000;
    }
}
