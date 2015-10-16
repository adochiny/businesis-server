package za.co.openset.dao;

import za.co.openset.model.AssetModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/06.
 */
public class AssetModelRepo extends AbstractJPARepository<AssetModel> {
    @Inject
    private EntityManager entityManager;

    public AssetModelRepo(){
        super(AssetModel.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
