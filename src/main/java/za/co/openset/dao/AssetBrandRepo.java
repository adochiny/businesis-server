package za.co.openset.dao;

import za.co.openset.model.AssetBrand;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/06.
 */
public class AssetBrandRepo extends AbstractJPARepository<AssetBrand> {
    @Inject
    private EntityManager entityManager;

    public AssetBrandRepo(){
        super(AssetBrand.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
