package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for future date validation.
 * @See: http://jxee.iteye.com/blog/1679065
 *
 * Created by drummer on 20.06.2015.
 */
@Constraint(validatedBy = FutureDateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FutureDate {

	String message() default "{de.htw_berlin.ai_bachelor.kbe.checklist.no_future_date}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
