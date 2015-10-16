package za.co.openset.dao;

import za.co.openset.model.Storage;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class StorageRepo extends AbstractJPARepository<Storage> {
    @Inject
    private EntityManager entityManager;

    public StorageRepo(){
        super(Storage.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
