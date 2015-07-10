package de.htw_berlin.ai_bachelor.kbe.checklist.data;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by mdrummer on 09.07.15.
 */
public class EntityManagerProducer {

	@Inject
	private EntityManagerFactory emf;

	@Produces
	public EntityManager create() {
		return emf.createEntityManager();
	}

	public void destroy(@Disposes EntityManager em) {
		em.close();
	}
}
