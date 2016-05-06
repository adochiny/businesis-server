package za.co.openset.dao.businesis;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.businesis.CompanyBusiness;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by adonis on 2015/06/05.
 *
 */
public class CompanyBusinessRepo extends AbstractJPARepository<CompanyBusiness> {
    public static final int TOTAL_NUMBER_OF_PERMISSABLE_RECORDS = 200;

    @Inject
    private EntityManager entityManager;

    public CompanyBusinessRepo(){
        super(CompanyBusiness.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }


    public List<CompanyBusiness> getBPInCompleted() throws Exception {
        //
        Query query = getEntityManager().createQuery("SELECT DISTINCT bp FROM CompanyBusiness bp, CompanyBusiness co " +
            " WHERE bp.companyBusinessId = co.parentId "
            + " AND co.status != 'COMPLETED' AND bp.bpcType = 'BP' AND co.bpcType = 'COMPANY' ORDER BY bp.updated DESC");
            //+ " AND co.status !=:suburbId AND pe.createDate BETWEEN :startDate AND :endDate ORDER BY pe.createDate DESC");
        return (List<CompanyBusiness>)query.getResultList();
    }

    public List<CompanyBusiness> getBPCompleted() throws Exception {
        //
        Query query = getEntityManager().createQuery("SELECT DISTINCT bp FROM CompanyBusiness bp, CompanyBusiness co " +
            " WHERE bp.companyBusinessId = co.parentId "
            + " AND co.status = 'COMPLETED' AND bp.bpcType = 'BP' AND co.bpcType = 'COMPANY' ORDER BY bp.updated DESC");
            //+ " AND co.status !=:suburbId AND pe.createDate BETWEEN :startDate AND :endDate ORDER BY pe.createDate DESC");
        return (List<CompanyBusiness>)query.getResultList();
    }

    public List<CompanyBusiness> getAllCompaniesForBp(Long bpId, String companyStatus) throws Exception {
        //
        Query query = null;
        if (companyStatus.equalsIgnoreCase("COMPLETED")) {
            query = getEntityManager().createQuery("SELECT DISTINCT co FROM CompanyBusiness co " +
                " WHERE co.parentId =:bpId "
                + " AND co.status = 'COMPLETED' AND co.bpcType = 'COMPANY' ORDER BY co.updated DESC");
        } else {
            query = getEntityManager().createQuery("SELECT DISTINCT co FROM CompanyBusiness co " +
                " WHERE co.parentId =:bpId "
                + " AND co.status != 'COMPLETED' AND co.bpcType = 'COMPANY' ORDER BY co.updated DESC");
        }
        query.setParameter("bpId", bpId);
        return (List<CompanyBusiness>)query.getResultList();
    }

}
