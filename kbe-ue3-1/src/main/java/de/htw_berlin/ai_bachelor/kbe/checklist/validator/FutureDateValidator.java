package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

/**
 * Validator to be used for date validation. The date must lie in the future.
 *
 * @See: http://jsfatwork.irian.at/book_de/jsf.html#!idx:/jsf.html:2
 * <p/>
 * Created by drummer on 20.06.2015.
 */
public class FutureDateValidator implements ConstraintValidator<FutureDate, Date> {

	private FutureDate futureDate;

	@Override
	public void initialize(FutureDate futureDate) {
		this.futureDate = futureDate;
	}

	@Override
	public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
		if (date == null) {
			return true;
		}

		Calendar dateFromForm = Calendar.getInstance();
		dateFromForm.setTime(date);
		// clear up milliseconds
		dateFromForm.set(Calendar.MILLISECOND, 0);
		dateFromForm.set(Calendar.SECOND, 0);
		dateFromForm.set(Calendar.MINUTE, 0);
		dateFromForm.set(Calendar.HOUR_OF_DAY, 0);

		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);

		if (cal.getTimeInMillis() > dateFromForm.getTimeInMillis()) {
			return false;
		}

		return true;
	}

	Calendar cal = Calendar.getInstance();
}
