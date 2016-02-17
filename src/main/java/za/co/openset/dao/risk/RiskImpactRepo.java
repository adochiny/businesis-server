package za.co.openset.dao.risk;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.risk.RiskImpact;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/06.
 *
 */
public class RiskImpactRepo extends AbstractJPARepository<RiskImpact> {

    @Inject
    private EntityManager entityManager;

    public RiskImpactRepo(){
        super(RiskImpact.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
