package za.co.openset.dao.businesis;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.businesis.Certificate;
import za.co.openset.model.businesis.Diagnosis;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by adonis on 2015/06/05.
 *
 */
public class CertificateRepo extends AbstractJPARepository<Certificate> {

    @Inject
    private EntityManager entityManager;

    public CertificateRepo(){
        super(Certificate.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
