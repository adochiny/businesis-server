package za.co.openset.dao;

import za.co.openset.model.AssetCost;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class AssetCostRepo extends AbstractJPARepository<AssetCost> {
    @Inject
    private EntityManager entityManager;

    public AssetCostRepo(){
        super(AssetCost.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
