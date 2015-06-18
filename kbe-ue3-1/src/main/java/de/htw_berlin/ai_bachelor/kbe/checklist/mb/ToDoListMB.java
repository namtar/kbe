package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import java.io.Serializable;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//TODO
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
}
