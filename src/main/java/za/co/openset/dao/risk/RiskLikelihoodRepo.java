package za.co.openset.dao.risk;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.risk.RiskLikelihood;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/06.
 */
public class RiskLikelihoodRepo extends AbstractJPARepository<RiskLikelihood> {

    @Inject
    private EntityManager entityManager;

    public RiskLikelihoodRepo(){
        super(RiskLikelihood.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
