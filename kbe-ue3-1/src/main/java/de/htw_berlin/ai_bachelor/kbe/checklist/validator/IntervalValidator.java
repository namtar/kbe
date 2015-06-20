package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import de.htw_berlin.ai_bachelor.kbe.checklist.mb.EditIntervalMB;

import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom jsr 303 interval validator
 * <p/>
 * Created by drummer on 20.06.2015.
 */
public class IntervalValidator implements ConstraintValidator<MyInterval, Integer> {

	private MyInterval myInterval;

	@Override
	public void initialize(MyInterval myInterval) {
		this.myInterval = myInterval;
	}

	@Override
	public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
		if (integer != null) {

			// http://stackoverflow.com/questions/2633112/get-jsf-managed-bean-by-name-in-any-servlet-related-class

			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			Object bean = elContext.getELResolver().getValue(elContext, null, "upperIntervalBorder");
			System.out.println(elContext);
		}
		return true;
	}
}
