package za.co.openset.dao;

import za.co.openset.model.Attribute;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class AttributeRepo extends AbstractJPARepository<Attribute> {
    @Inject
    private EntityManager entityManager;

    public AttributeRepo(){
        super(Attribute.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    

}
