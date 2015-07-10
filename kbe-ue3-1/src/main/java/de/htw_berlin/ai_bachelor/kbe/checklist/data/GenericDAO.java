package de.htw_berlin.ai_bachelor.kbe.checklist.data;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mdrummer on 09.07.15.
 */
public abstract class GenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

//	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("check");

	@Inject
	private EntityManager em;

	private Class<T> entityClass;

	public GenericDAO() {
		this.entityClass = getClazz();
	}

	protected abstract Class<T> getClazz();

	public EntityManager getEntityManager() {
		return em;
	}

	public void beginTransaction() {
//		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void rollback() {
		em.getTransaction().rollback();
	}

	public void closeTransaction() {
		// if one does that the entity manager is not useable anymore after this.
		em.close();
	}

	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	public void flush() {
		em.flush();
	}

	public void save(T entity) {
		em.persist(entity);
	}

	protected void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = em.getReference(classe, id);

		em.remove(entityToBeRemoved);
	}

	public T update(T entity) {
		return em.merge(entity);
	}

	public T find(int entityID) {
		return em.find(entityClass, entityID);
	}

	public T findReferenceOnly(int entityID) {
		return em.getReference(entityClass, entityID);
	}

	@SuppressWarnings({ "unchecked" })
	public List<T> findByQuery(String q) {
		return em.createNamedQuery(q).getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

//	@Produces
//	private EntityManager produceEntityManager() {
////		http://www.widecodes.com/7ixJVgVqVP/how-to-manage-entitymanager-lifecycle-in-cdi-environement-using-tomcat.html
//
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("check");
//		return emf.createEntityManager();
//	}
}
