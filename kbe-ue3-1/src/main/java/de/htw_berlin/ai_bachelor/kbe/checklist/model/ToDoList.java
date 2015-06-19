package de.htw_berlin.ai_bachelor.kbe.checklist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ToDoList implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ToDo> toDos = new ArrayList<ToDo>();

	public ToDoList() {
		super();
		this.setToDos();
	}

	public List<ToDo> getToDos() {
		return toDos;
	}

	private void setToDos() {
		toDos.add(new ToDo("KBE: Aufgabenzettel 2 bearbeiten", new Date()));
		toDos.add(new ToDo("KBE: Zweite Vorlesung nacharbeiten", new Date()));
		toDos.add(new ToDo("Lebensmittel einkaufen ", new Date()));
		toDos.add(new ToDo("Leergut wegbringen", new Date()));
		toDos.add(new ToDo("Geburtstagsgeschenk besorgen", new Date()));
		toDos.add(new ToDo("Putzen", new Date()));
	}

	public Integer getDoneTodos() {
		Integer numberOfDone = 0;
		for (ToDo toDo : toDos) {
			if (toDo.isDone()) {
				numberOfDone++;
			}
		}
		return numberOfDone;
	}

	public Integer getTotalNumberOfTodos() {
		return toDos.size();
	}
}
