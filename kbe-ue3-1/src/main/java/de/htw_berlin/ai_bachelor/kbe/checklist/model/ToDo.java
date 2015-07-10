package de.htw_berlin.ai_bachelor.kbe.checklist.model;

import de.htw_berlin.ai_bachelor.kbe.checklist.validator.MyInterval;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Class that represents one todo entry
 *
 * @author Matthias Drummer
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "todo")
public class ToDo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;
	private boolean done = false;

	private Date dueDate;

	private Integer priority = 1;

	public ToDo() {
	}

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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	protected void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "done")
	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "dueDate")
	@NotNull
	@Future(message = "{de.htw_berlin.ai_bachelor.kbe.checklist.no_future_date}")
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "priority", columnDefinition = "int default 1")
	@MyInterval
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ToDo toDo = (ToDo) o;

		if (done != toDo.done)
			return false;
		if (id != null ? !id.equals(toDo.id) : toDo.id != null)
			return false;
		if (name != null ? !name.equals(toDo.name) : toDo.name != null)
			return false;
		if (dueDate != null ? !dueDate.equals(toDo.dueDate) : toDo.dueDate != null)
			return false;
		return !(priority != null ? !priority.equals(toDo.priority) : toDo.priority != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (done ? 1 : 0);
		result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
		result = 31 * result + (priority != null ? priority.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ToDo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", done=" + done +
				", dueDate=" + dueDate +
				", priority=" + priority +
				'}';
	}
}
