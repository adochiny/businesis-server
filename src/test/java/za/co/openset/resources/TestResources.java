package za.co.openset.resources;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

/**
 * Provides injectable resources to the application tests. This class provides alternatives to the resources used in
 * the app server environment.
 */
@Alternative
public class TestResources {

	@Produces
	@Singleton
	@SuppressWarnings("unused")
	private EntityManager createEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("amanager_test");
		return emf.createEntityManager();
	}
}
