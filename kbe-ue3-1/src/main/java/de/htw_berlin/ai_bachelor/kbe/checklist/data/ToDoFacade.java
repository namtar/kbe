package de.htw_berlin.ai_bachelor.kbe.checklist.data;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Facade to orchestrate the needed calls for entity.
 * <p/>
 * Created by mdrummer on 09.07.15.
 */
public class ToDoFacade implements Serializable {

	@Inject
	private ToDoDAO toDoDAO;

	public boolean save(ToDo toDo) {

		toDoDAO.save(toDo);

		//		System.out.println(toDo.toString());

		return true;
	}

	public void update(ToDo toDo) {

		ToDo updated = toDoDAO.update(toDo);
		System.out.println(updated);
	}

	public List<ToDo> getAllTodos() {
		return toDoDAO.getAllTodos();
	}
}
