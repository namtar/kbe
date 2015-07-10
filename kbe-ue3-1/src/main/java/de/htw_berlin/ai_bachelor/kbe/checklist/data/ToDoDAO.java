package de.htw_berlin.ai_bachelor.kbe.checklist.data;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by mdrummer on 09.07.15.
 */
@Singleton
public class ToDoDAO extends GenericDAO<ToDo> {

	@Override
	protected Class<ToDo> getClazz() {
		return ToDo.class;
	}

	public void save(ToDo toDo) {

		try {
			beginTransaction();
			super.save(toDo);
			commit();
		} catch (Exception e) {
			// not good to catch all, but if any goes wrong we want a rollback
			rollback();
		}
	}

	public ToDo update(ToDo toDo) {

		// merge would also be possible i think.

		beginTransaction();
		ToDo fromDatabase = find(toDo.getId());

		fromDatabase.setPriority(toDo.getPriority());
		fromDatabase.setDone(toDo.isDone());
		fromDatabase.setDueDate(toDo.getDueDate());
		fromDatabase.setName(toDo.getName());

		commit();

		return fromDatabase;
	}

	public List<ToDo> getAllTodos() {

		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ToDo> crit = cb.createQuery(getClazz());
		crit.from(getClazz());

		return getEntityManager().createQuery(crit).getResultList();
	}
}
