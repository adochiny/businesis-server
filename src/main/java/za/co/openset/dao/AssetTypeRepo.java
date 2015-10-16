package za.co.openset.dao;

import za.co.openset.model.AssetType;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/06.
 */
public class AssetTypeRepo extends AbstractJPARepository<AssetType> {
    @Inject
    private EntityManager entityManager;

    public AssetTypeRepo(){
        super(AssetType.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
