package za.co.openset.dao.risk;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.risk.RiskControlEffectiveness;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/06.
 */
public class RiskControlEffectivenessRepo extends AbstractJPARepository<RiskControlEffectiveness> {

    @Inject
    private EntityManager entityManager;

    public RiskControlEffectivenessRepo(){
        super(RiskControlEffectiveness.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
