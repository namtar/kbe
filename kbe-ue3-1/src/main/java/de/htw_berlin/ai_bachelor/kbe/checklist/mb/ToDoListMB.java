package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import de.htw_berlin.ai_bachelor.kbe.checklist.data.ToDoFacade;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * @See: https://mobiarch.wordpress.com/2013/07/18/user-friendly-validation-error-message-in-jsf-2/
 */
@Named("todoListMB")
@SessionScoped
public class ToDoListMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private ToDoList toDoList;
	private String testMessage = "Dies ist ein Test";

	@Inject
	private ToDoFacade toDoFacade;

	public ToDoListMB() {
		super();
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.GERMAN);
		this.toDoList = new ToDoList();
	}

	@PostConstruct
	private void afterCreation() {
		// persist all initial created todos to database for more fun.
		for (ToDo toDo : toDoList.getToDos()) {
			toDoFacade.save(toDo);
		}
	}

	public ToDoList getToDoList() {
		// hacky... only for practice.....
		this.toDoList.getToDos().clear();
		this.toDoList.getToDos().addAll(toDoFacade.getAllTodos());
		return toDoList;
	}

	public void setToDoList(ToDoList toDoList) {
		this.toDoList = toDoList;
	}

	public String getTestMessage() {
		return testMessage;
	}

	//Should be called if the Button "Speichern" is pushed.
	//Needs configuration in the faces-config.xml.
	public String save() {
		// @See: http://stackoverflow.com/questions/13070537/difference-between-hbutton-and-hcommandbutton

		// durch den Form POST wird offensichtlich der State an sich schon submitted. Das heißt, wir können zur Persistierung in der DB einfach auf die Todolist
		// zugreifen und Spass haben.
		for(ToDo toDo : toDoList.getToDos()) {
			toDoFacade.update(toDo);
		}

		return "save";
	}

	public String reset(final String componentId) {
		// http://javaevangelist.blogspot.de/2013/08/jsf-tip-of-day-how-do-i-reset-input.html
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		UIComponent component = viewRoot.findComponent(componentId);
		if (component != null) {

			for (UIComponent child : component.getChildren()) {
				if (child instanceof UIInput) {
					((UIInput) child).resetValue();
				}
			}
		}
		return "cancel";
	}
}
