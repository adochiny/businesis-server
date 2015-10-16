package za.co.openset.dao;

import za.co.openset.dto.AssetSearchDto;
import za.co.openset.model.Asset;
import za.co.openset.model.AssetWarehouse;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by adonis on 2015/07/08.
 */
public class AssetWarehouseRepo extends AbstractJPARepository<AssetWarehouse>  {
    @Inject
    private EntityManager entityManager;

    public AssetWarehouseRepo(){
        super(AssetWarehouse.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<AssetWarehouse> getAssetWarehouses(Long assetId) throws Exception {
        // SELECT c, p.name FROM Country c LEFT OUTER JOIN c.capital p
        // AND pe.createDate BETWEEN :startDate AND :endDate ORDER BY createDate DESC";
        StringBuilder squery = new StringBuilder("SELECT aw FROM AssetWarehouse aw JOIN aw.asset ass ");
        squery.append(" WHERE ass.assetId =:assetId ");
        squery.append(" ORDER BY aw.created DESC ");

        TypedQuery<AssetWarehouse> query = getEntityManager().createQuery(squery.toString(), AssetWarehouse.class);
            query.setParameter("assetId", assetId);

        return query.getResultList();

    }
}
