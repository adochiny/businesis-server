package za.co.openset.dao.risk;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.risk.RiskCategory;
import za.co.openset.model.risk.RiskSubCategory;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/06.
 *
 */
public class RiskSubCategoryRepo extends AbstractJPARepository<RiskSubCategory> {

    @Inject
    private EntityManager entityManager;

    public RiskSubCategoryRepo(){
        super(RiskSubCategory.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
