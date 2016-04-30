package za.co.openset.service.businesis;

import za.co.openset.dao.AddressRepo;
import za.co.openset.dao.businesis.CompanyBusinessRepo;
import za.co.openset.dao.businesis.DiagnosisRepo;
import za.co.openset.model.Address;
import za.co.openset.model.businesis.CompanyBusiness;
import za.co.openset.model.businesis.Diagnosis;
import za.co.openset.utils.AManagerUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by adonis on 2015/06/28.
 *
 */

@Stateless
public class DiagnosisService {

    @Inject
    private CompanyBusinessRepo companyBusinessRepo;

    @Inject
    private DiagnosisRepo diagnosisRepo;

    @Inject
    private AManagerUtils aManagerUtils;

    // diagnosis functions
    public Diagnosis update(Diagnosis diagnosis) throws Exception {

        if (diagnosis.getDiagnosisId() != null) {
            aManagerUtils.setCommonFieldsUpdate(diagnosis, AManagerUtils.CREATED_BY);
        } else {
            aManagerUtils.setCommonFieldsCreate(diagnosis, AManagerUtils.CREATED_BY);
        }

        Diagnosis updated = diagnosisRepo.update(diagnosis);

        return updated;
    }

    public Diagnosis getCompanyBusinessById(Long id) throws Exception {
        Diagnosis byId = diagnosisRepo.findById(id);
        return byId;
    }

    public List<Diagnosis> getAllCompanyDiagnosis(String companySectionId) throws Exception {
        // addressRepo.findByParent(byId.getCompanyBusinessId())
        List<Diagnosis> all = diagnosisRepo.getAllCompanyDiagnosis(companySectionId);
        return all;
    }



}
