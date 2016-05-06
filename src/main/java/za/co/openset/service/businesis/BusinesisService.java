package za.co.openset.service.businesis;

import za.co.openset.dao.AddressRepo;
import za.co.openset.dao.businesis.CompanyBusinessRepo;
import za.co.openset.dao.businesis.DiagnosisRepo;
import za.co.openset.model.businesis.CompanyBusiness;
import za.co.openset.model.businesis.Diagnosis;
import za.co.openset.utils.AManagerUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adonis on 2015/06/28.
 *
 */

@Stateless
public class BusinesisService {

    @Inject
    private CompanyBusinessRepo companyBusinessRepo;

    @Inject
    private DiagnosisRepo diagnosisRepo;

    @Inject
    private AddressRepo addressRepo;

    @Inject
    private AManagerUtils aManagerUtils;

    // CompanyBusiness functions
    public CompanyBusiness update(CompanyBusiness companyBusiness) throws Exception {

        if (companyBusiness.getCompanyBusinessId() != null) {
            aManagerUtils.setCommonFieldsUpdate(companyBusiness, AManagerUtils.CREATED_BY);
        } else {
            aManagerUtils.setCommonFieldsCreate(companyBusiness, AManagerUtils.CREATED_BY);
        }

        if (companyBusiness.getContactDetails() != null) {
            if (companyBusiness.getContactDetails().getContactDetailsId() != null) {
                aManagerUtils.setCommonFieldsUpdate(companyBusiness.getContactDetails(), AManagerUtils.CREATED_BY);
            } else {
                aManagerUtils.setCommonFieldsCreate(companyBusiness.getContactDetails(), AManagerUtils.CREATED_BY);
            }
        }

        if (companyBusiness.getAddress() != null) {
            if (companyBusiness.getAddress().getAddressId() != null) {
                aManagerUtils.setCommonFieldsUpdate(companyBusiness.getAddress(), AManagerUtils.CREATED_BY);
            } else {
                aManagerUtils.setCommonFieldsCreate(companyBusiness.getAddress(), AManagerUtils.CREATED_BY);
            }
        }

        // if (companyBusiness.getAddresses() != null) {
        //     for (Address address : companyBusiness.getAddresses()) {
        //         if (address.getAddressId() != null) {
        //             aManagerUtils.setCommonFieldsUpdate(address, AManagerUtils.CREATED_BY);
        //         } else {
        //             aManagerUtils.setCommonFieldsCreate(address, AManagerUtils.CREATED_BY);
        //         }
        //     }
        // }

        return companyBusinessRepo.update(companyBusiness);
    }

    public CompanyBusiness getCompanyBusinessById(Long id) throws Exception {
        CompanyBusiness byId = companyBusinessRepo.findById(id);
        // byId.setAddresses(addressRepo.findByParent(byId.getCompanyBusinessId()));
        return byId;
    }

    public List<CompanyBusiness> getAllCompanyBusiness(String type) throws Exception {
        List<CompanyBusiness> all = companyBusinessRepo.findByFieldName("bpcType", type);
        /*for (CompanyBusiness companyBusiness : all) {
            // add addresses for each.
            companyBusiness.setAddresses(addressRepo.findByParent(companyBusiness.getCompanyBusinessId()));
        }*/
        return all;
    }

    public List<CompanyBusiness> getAllCompaniesForBp(String bpId) {
        return companyBusinessRepo.findByFieldName("parentId", bpId);
    }

    public List<Diagnosis> getAllDiagnosisForCompany(Long companyId) {
        return diagnosisRepo.findByFieldName("companyId", companyId);
    }

    public Diagnosis getDiagnosisForCompany(Long companyId, String companySection) {
        Map<String, Object> map = new HashMap<>();
        map.put("companyId", companyId);
        map.put("companySection", companySection);
        return diagnosisRepo.findEntityByFieldName(map);
    }

    public List<CompanyBusiness> getAllCompaniesForBp(Long bpId, String companyStatus) throws Exception {
        return companyBusinessRepo.getAllCompaniesForBp(bpId, companyStatus);
    }

    //    public List<CompanyBusiness> getAllCompaniesForBp(Long bpId, String companyStatus) {
    //        Map<String, Object> map = new HashMap<>();
    //        map.put("parentId", bpId);
    //        map.put("status", companyStatus);
    //        return companyBusinessRepo.findEntityByFieldNames(map);
    //    }

    public CompanyBusiness getCompanyBpById(Long bpId) throws Exception {
        return companyBusinessRepo.findById(bpId);
    }

    public List<CompanyBusiness> getBPInCompleted() throws Exception {
        return companyBusinessRepo.getBPInCompleted();
    }

    public List<CompanyBusiness> getBPCompleted() throws Exception {
        return companyBusinessRepo.getBPCompleted();
    }

}
