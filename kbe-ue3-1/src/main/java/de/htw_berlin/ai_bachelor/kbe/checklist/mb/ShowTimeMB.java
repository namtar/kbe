package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by matthias.drummer on 11.06.15.
 */
@Named("showTimeMB")
@SessionScoped
public class ShowTimeMB implements Serializable {

	public Date getActualTime() {
		return new Date();
	}

	public String toChecklist() {
		return "checklist";
	}
}
