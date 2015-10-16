package za.co.openset.dao;

import za.co.openset.model.AttributeType;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class AttributeTypeRepo extends AbstractJPARepository<AttributeType> {
    @Inject
    private EntityManager entityManager;

    public AttributeTypeRepo(){
        super(AttributeType.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
