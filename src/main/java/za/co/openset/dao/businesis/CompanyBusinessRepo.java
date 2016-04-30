package za.co.openset.dao.businesis;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.businesis.CompanyBusiness;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 *
 */
public class CompanyBusinessRepo extends AbstractJPARepository<CompanyBusiness> {
    public static final int TOTAL_NUMBER_OF_PERMISSABLE_RECORDS = 200;

    @Inject
    private EntityManager entityManager;

    public CompanyBusinessRepo(){
        super(CompanyBusiness.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }


}
