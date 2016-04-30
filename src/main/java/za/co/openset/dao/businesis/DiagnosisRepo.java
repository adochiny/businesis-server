package za.co.openset.dao.businesis;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.businesis.Diagnosis;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by adonis on 2015/06/05.
 *
 */
public class DiagnosisRepo extends AbstractJPARepository<Diagnosis> {

    @Inject
    private EntityManager entityManager;

    public DiagnosisRepo(){
        super(Diagnosis.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Diagnosis> getAllCompanyDiagnosis(String companySectionId) {
        return findByFieldName("companySectionId", companySectionId);
    }
}
