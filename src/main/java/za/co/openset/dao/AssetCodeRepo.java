package za.co.openset.dao;

import za.co.openset.model.AssetCode;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class AssetCodeRepo extends AbstractJPARepository<AssetCode> {
    @Inject
    private EntityManager entityManager;

    public AssetCodeRepo(){
        super(AssetCode.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
