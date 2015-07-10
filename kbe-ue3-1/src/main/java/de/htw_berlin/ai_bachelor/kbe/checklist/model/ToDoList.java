package de.htw_berlin.ai_bachelor.kbe.checklist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);

		toDos.add(new ToDo("KBE: Aufgabenzettel 2 bearbeiten", cal.getTime()));
		toDos.add(new ToDo("KBE: Zweite Vorlesung nacharbeiten", cal.getTime()));
		toDos.add(new ToDo("Lebensmittel einkaufen ", cal.getTime()));
		toDos.add(new ToDo("Leergut wegbringen", cal.getTime()));
		toDos.add(new ToDo("Geburtstagsgeschenk besorgen", cal.getTime()));
		toDos.add(new ToDo("Putzen", cal.getTime()));
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
