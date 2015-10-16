package za.co.openset.dao;

import za.co.openset.model.AssetSoftware;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class AssetSoftwareRepo extends AbstractJPARepository<AssetSoftware> {
    @Inject
    private EntityManager entityManager;

    public AssetSoftwareRepo(){
        super(AssetSoftware.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
