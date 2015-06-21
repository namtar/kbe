package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import de.htw_berlin.ai_bachelor.kbe.checklist.mb.EditIntervalMB;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
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

			ExpressionFactory expressionFactory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			ValueExpression expression = expressionFactory.createValueExpression(elContext, "#{editIntervalMB.upperIntervalBorder}", Integer.class);
			Integer value = (Integer) expression.getValue(elContext);
			//			System.out.println(expression);
			//			System.out.println(value);
			if (integer < 1 || integer > value) {
				return false;
			}
		}
		return true;
	}
}
