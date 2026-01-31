package learn.spring_boot.crud.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PriceValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPrice {
    String message() default "{jakarta.validation.constraints.ValidPrice.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
