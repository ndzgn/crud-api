package learn.spring_boot.crud.validator;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PriceValidatorTest {

    PriceValidator priceValidator = new PriceValidator();

    @Mock
    ConstraintValidatorContext ex;

    public ValidPrice createValidPrice()
    {
        return new ValidPrice() {

            /**
             * Returns the annotation interface of this annotation.
             *
             * @return the annotation interface of this annotation
             * @apiNote Implementation-dependent classes are used to provide
             * the implementations of annotations. Therefore, calling {@link
             * Object#getClass getClass} on an annotation will return an
             * implementation-dependent class. In contrast, this method will
             * reliably return the annotation interface of the annotation.
             * @see Enum#getDeclaringClass
             */
            @Override
            public Class<? extends Annotation> annotationType() {
                return ValidPrice.class;
            }

            @Override
            public String message() {
                return "";
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }
        };
    }

    @Test
    void shouldReturnTrueWhenPriceIsCorrect()
    {
        ValidPrice validPrice = createValidPrice();
        priceValidator.initialize(validPrice);
        assertTrue(priceValidator.isValid(new BigDecimal("7000"), ex));
    }
}