package za.co.openset.dao;

import za.co.openset.model.Request;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class RequestRepo extends AbstractJPARepository<Request> {
    @Inject
    private EntityManager entityManager;

    public RequestRepo(){
        super(Request.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
