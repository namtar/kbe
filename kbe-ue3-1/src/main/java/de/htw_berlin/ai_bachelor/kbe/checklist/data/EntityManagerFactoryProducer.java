package de.htw_berlin.ai_bachelor.kbe.checklist.data;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by mdrummer on 09.07.15.
 */
public class EntityManagerFactoryProducer {

	private static final String UNIT_NAME = "check";

	@Produces
	@ApplicationScoped
	public EntityManagerFactory create() {
		return Persistence.createEntityManagerFactory(UNIT_NAME);
	}

	public void destroy(@Disposes EntityManagerFactory factory) {
		factory.close();
	}
}
