package za.co.openset.dao;

import za.co.openset.model.Warehouse;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class WarehouseRepo extends AbstractJPARepository<Warehouse> {
    @Inject
    private EntityManager entityManager;

    public WarehouseRepo(){
        super(Warehouse.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
