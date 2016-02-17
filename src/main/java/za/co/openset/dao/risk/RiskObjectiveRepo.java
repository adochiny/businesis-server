package za.co.openset.dao.risk;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.risk.RiskObjective;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/06.
 *
 */
public class RiskObjectiveRepo extends AbstractJPARepository<RiskObjective> {

    @Inject
    private EntityManager entityManager;

    public RiskObjectiveRepo() {
        super(RiskObjective.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
