package za.co.openset.dao;

import za.co.openset.model.BusinessPartner;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class BusinessPartnerRepo extends AbstractJPARepository<BusinessPartner> {
    @Inject
    private EntityManager entityManager;

    public BusinessPartnerRepo(){
        super(BusinessPartner.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }


}
