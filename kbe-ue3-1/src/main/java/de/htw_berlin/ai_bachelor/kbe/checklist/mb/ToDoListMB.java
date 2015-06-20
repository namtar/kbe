package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import java.io.Serializable;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

/**
 * @See: https://mobiarch.wordpress.com/2013/07/18/user-friendly-validation-error-message-in-jsf-2/
 */
@ManagedBean(name = "todoListMB")
@SessionScoped
public class ToDoListMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private ToDoList toDoList;
	private String testMessage = "Dies ist ein Test";

	public ToDoListMB() {
		super();

		this.toDoList = new ToDoList();
	}

	public ToDoList getToDoList() {
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
		return null;
	}
}
