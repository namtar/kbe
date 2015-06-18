package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by matthias.drummer on 11.06.15.
 */
@ManagedBean(name = "showTimeMB")
@SessionScoped
public class ShowTimeMB implements Serializable {

	public Date getActualTime() {
		return new Date();
	}

	public String toChecklist() {
		return "checklist";
	}
}
