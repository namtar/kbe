package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import de.htw_berlin.ai_bachelor.kbe.checklist.data.ToDoFacade;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Calendar;

/**
 * Created by mdrummer on 09.07.15.
 */
@Named("newTodoMB")
@RequestScoped
public class NewTodoMB {

	private ToDo toDo;

	@Inject
	private ToDoFacade toDoFacade;

	public NewTodoMB() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1); // set tomorrow

		toDo = new ToDo(null, cal.getTime());
		toDo.setPriority(1);
	}

	public ToDo getToDo() {
		return toDo;
	}

	public void setToDo(ToDo toDo) {
		this.toDo = toDo;
	}

	public String save() {

		if (toDoFacade.save(toDo)) {
			return "success";
		}
		return "fail";
	}
}
