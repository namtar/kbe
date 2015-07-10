package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by drummer on 20.06.2015.
 */
@Named("editIntervalMB")
@ApplicationScoped
public class EditIntervalMB implements Serializable {

	@Min(1)
	private Integer upperIntervalBorder = 1;

	public Integer getUpperIntervalBorder() {
		return upperIntervalBorder;
	}

	public void setUpperIntervalBorder(Integer upperIntervalBorder) {
		this.upperIntervalBorder = upperIntervalBorder;
	}

	public String save() {


		return "success";
	}
}
