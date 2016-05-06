package za.co.openset.service.businesis;

import za.co.openset.dao.AddressRepo;
import za.co.openset.dao.businesis.CertificateRepo;
import za.co.openset.dao.businesis.CompanyBusinessRepo;
import za.co.openset.dao.businesis.DiagnosisRepo;
import za.co.openset.model.businesis.Certificate;
import za.co.openset.model.businesis.CompanyBusiness;
import za.co.openset.model.businesis.Diagnosis;
import za.co.openset.utils.AManagerUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.*;

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
    private CertificateRepo certificateRepo;

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


    public Certificate updateCertificate(Certificate certificate) throws Exception {
        certificate.setCompanySectionId(certificate.getCompanyId() + "_" + certificate.getCompanySection());
        if (certificate.getCertificateId() != null) {
            aManagerUtils.setCommonFieldsUpdate(certificate, AManagerUtils.CREATED_BY);
        } else {
            aManagerUtils.setCommonFieldsCreate(certificate, AManagerUtils.CREATED_BY);
        }
        Certificate updated = certificateRepo.update(certificate);
        return updated;
    }

    public List<Certificate> getAllCompanyCerts(Long companyId, String companySection) {
        Map<String, Object> map = new HashMap<>();
        map.put("companyId", companyId);
        map.put("companySection", companySection);
        return certificateRepo.findEntityByFieldNames(map);
    }

    public Certificate getCompanyCertificate(Long companyId, String companySection) {
        Map<String, Object> map = new HashMap<>();
        map.put("companyId", companyId);
        map.put("companySection", companySection);
        return certificateRepo.findEntityByFieldName(map);
    }

    public List<Certificate> generateCertificates(List<Diagnosis> diagnosisList) throws Exception {
        // todo: get the fomulars from papa
        List<Certificate> certificates = new ArrayList<>();
        for (Diagnosis diagnosis : diagnosisList) {
            // todo: select cert from the db.
            Certificate cert = generateCertificate(diagnosis);
            certificates.add(cert);
        }
        return certificates;
    }

    public List<Certificate> generateCertificates(Long companyId) throws Exception {
        // todo: get the fomulars from papa
        List<Diagnosis> diagnosisList = diagnosisRepo.findByFieldName("companyId", companyId);

        List<Certificate> certificates = new ArrayList<>();
        for (Diagnosis diagnosis : diagnosisList) {
            // todo: select cert from the db.
            Certificate cert = generateCertificate(diagnosis);
            // save first.
            cert = updateCertificate(cert);
            certificates.add(cert);
        }
        return certificates;
    }

    /**
     *   diagnose Governance
         diagnose TaxCompliance
         diagnose Labour
         diagnose SafetyHealth
         diagnose Standards
         diagnose BBBEE Broad Based Black Economic Empowerment (B-BBEE)
         diagnose Production
         diagnose SalesMarketing
         diagnose InformationTechnology
         diagnose FinancialControlsManagement
         //diagnose TechnicalSiteVisit
         diagnose IntellectualProperty
         diagnose RiskManagement
     * @param diagnosis
     * @return
     * @throws Exception
     */
    public Certificate generateCertificate(Diagnosis diagnosis) throws Exception {
        Certificate cc = getCompanyCertificate(diagnosis.getCompanyId(), diagnosis.getCompanySection());
        if (cc == null) {
            cc = new Certificate();
        }
        cc.setCompanyId(diagnosis.getCompanyId());
        cc.setCompanySection(diagnosis.getCompanySection());

        switch (diagnosis.getCompanySection()) {
            case "Governance":  cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "TaxCompliance":  cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "Labour": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "SafetyHealth": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "Standards": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "BBBEE": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "Production": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "SalesMarketing": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "InformationTechnology": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "FinancialControlsManagement": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "IntellectualProperty": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "RiskManagement": cc = calculateCertValue(cc, diagnosis, 7);
                break;

        }
        return cc;
    }

    private Certificate calculateCertValue(Certificate cert, Diagnosis d, int total) {
        // put the diagnosis values in array
        Long [] darray = new Long[13];
        darray[0] = d.getQ0(); darray[1] = d.getQ1(); darray[2] = d.getQ2(); darray[3] = d.getQ3(); darray[4] = d.getQ4();
        darray[5] = d.getQ5(); darray[6] = d.getQ6(); darray[7] = d.getQ7(); darray[8] = d.getQ8(); darray[9] = d.getQ9();
        darray[10] = d.getQ10(); darray[11] = d.getQ11(); darray[12] = d.getQ12();
        int totalNumber1 = 0;
        int totalNumber2 = 0;
        int totalNumber3 = 0;
        int totalNumber4 = 0;
        for (int i = 0; i < total ; i++) {
            if (new Long(1).equals(darray[i])) {
              totalNumber1++;
            }
            if (new Long(2).equals(darray[i])) {
              totalNumber2++;
            }
            if (new Long(3).equals(darray[i])) {
              totalNumber3++;
            }
            if (new Long(4).equals(darray[i])) {
              totalNumber4++;
            }
        }
        if (totalNumber1/total > 0.25) {
            cert.setValue("1");
            cert.setDescription("1");
        } else if (totalNumber2/total > 0.25) {
            cert.setValue("2");
            cert.setDescription("2");
        } else if (totalNumber3/total > 0.25) {
            cert.setValue("3");
            cert.setDescription("3");
        } else if (totalNumber4/total > 0.25) {
            cert.setValue("4");
            cert.setDescription("4");
        } else {
            cert.setValue("2");
            cert.setDescription("2");
        }

       return cert;
    }

}
