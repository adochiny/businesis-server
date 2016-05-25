package za.co.openset.dao.businesis;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.businesis.Certificate;
import za.co.openset.model.businesis.CertificateSummary;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 *
 */
public class CertificateSummaryRepo extends AbstractJPARepository<CertificateSummary> {

    @Inject
    private EntityManager entityManager;

    public CertificateSummaryRepo(){
        super(CertificateSummary.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
