package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interface for interval validation
 * <p/>
 * Created by drummer on 20.06.2015.
 */
@Constraint(validatedBy = IntervalValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface MyInterval {

	String message() default "{de.htw_berlin.ai_bachelor.kbe.checklist.wrong.interval}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
