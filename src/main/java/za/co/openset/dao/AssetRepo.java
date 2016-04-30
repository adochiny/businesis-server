package za.co.openset.dao;

import za.co.openset.dto.AssetSearchDto;
import za.co.openset.model.Asset;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by adonis on 2015/06/05.
 *
 */
public class AssetRepo extends AbstractJPARepository<Asset> {
    public static final int TOTAL_NUMBER_OF_PERMISSABLE_RECORDS = 200;
    @Inject
    private EntityManager entityManager;

    public AssetRepo(){
        super(Asset.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public Long countAssets(Query query) throws Exception {
        // String squery = "SELECT COUNT(ass) FROM Asset ass";
        // Query query = getEntityManager().createQuery(squery);
        Long assetCount = (Long) query.getSingleResult();
        return assetCount;
    }

    /**
     *
     * @param assetSearchDto
     * @return
     * @throws Exception
     */
    public List<Asset> findAssets(AssetSearchDto assetSearchDto) throws Exception {
        // SELECT c, p.name FROM Country c LEFT OUTER JOIN c.capital p
        // AND pe.createDate BETWEEN :startDate AND :endDate ORDER BY createDate DESC";
        StringBuilder squery = new StringBuilder("SELECT ass FROM Asset ass LEFT JOIN ass.assetCode ac ");
            squery.append("WHERE ass.assetCode is not null ");
                if (assetSearchDto.getAssetCodeId() != null) {
                    squery.append(" AND ac.assetCodeId =:assetCodeId");
                }
                if (assetSearchDto.getAssetTypeId() != null) {
                    squery.append(" AND ac.assetType.assetTypeId =:assetTypeId");
                }
                if (assetSearchDto.getAssetBrandId() != null) {
                    squery.append(" AND ac.assetBrand.assetBrandId =:assetBrandId");
                }
                if (assetSearchDto.getAssetModelId() != null) {
                    squery.append(" AND ac.assetModel.assetModelId =:assetModelId");
                }
                if (assetSearchDto.getSerialNumber() != null) {
                    squery.append(" AND lower(ass.serialNumber) LIKE :serialNumber");
                    //squery.append("AND ac.serialNumber like :" +  "%" + assetSearchDto.getSerialNumber() + "%");
                }


        TypedQuery<Asset> query = getEntityManager().createQuery(squery.toString(), Asset.class);
            if (assetSearchDto.getAssetCodeId() != null) {
                query.setParameter("assetCodeId", assetSearchDto.getAssetCodeId());
            }
            if (assetSearchDto.getAssetTypeId() != null) {
                query.setParameter("assetTypeId", assetSearchDto.getAssetTypeId());
            }
            if (assetSearchDto.getAssetBrandId() != null) {
                query.setParameter("assetBrandId", assetSearchDto.getAssetBrandId());
            }
            if (assetSearchDto.getAssetModelId() != null) {
                query.setParameter("assetModelId", assetSearchDto.getAssetModelId());
            }
            if (assetSearchDto.getSerialNumber() != null) {
                query.setParameter("serialNumber", assetSearchDto.getSerialNumber().toLowerCase());
            }

        /*
          Todo:
          String squery = "SELECT COUNT(ass) FROM Asset ass LEFT JOIN ass.assetCode ac";
          Query query = getEntityManager().createQuery(squery);*/

        List<Asset> list = query.setMaxResults(TOTAL_NUMBER_OF_PERMISSABLE_RECORDS).getResultList();
        return list;

        /*
        if (list != null && list.size() < TOTAL_NUMBER_OF_PERMISSABLE_RECORDS) {
            return list;
        }*/
    }

}
