package za.co.openset.utils;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by adonis on 2015/06/07.
 *
 */
public class Resources {

    @SuppressWarnings("unused")
    @Produces
    @PersistenceContext(unitName="BUSINESIS-PERSISTENCE-UNIT")
    private EntityManager entityManager;

}
