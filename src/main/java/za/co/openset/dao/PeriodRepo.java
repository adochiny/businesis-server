package za.co.openset.dao;

import za.co.openset.model.Period;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class PeriodRepo extends AbstractJPARepository<Period> {
    @Inject
    private EntityManager entityManager;

    public PeriodRepo(){
        super(Period.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }


}
