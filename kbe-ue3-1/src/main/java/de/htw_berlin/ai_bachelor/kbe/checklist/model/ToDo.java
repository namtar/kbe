package de.htw_berlin.ai_bachelor.kbe.checklist.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Class that represents one todo entry
 *
 * @author Matthias Drummer
 */
public class ToDo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private boolean done = false;
	private Date dueDate;
	private boolean editable;

	private ToDo(String name, boolean done, Date dueDate) {
		super();
		this.name = name;
		this.done = done;
		this.dueDate = dueDate;
	}

	public ToDo(String name, Date dueDate) {
		this(name, false, dueDate);
	}

	public ToDo(String name) {
		this(name, false, null);
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "ToDo{" +
				"name='" + name + '\'' +
				", done=" + done +
				", dueDate=" + dueDate +
				'}';
	}
}