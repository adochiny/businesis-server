package za.co.openset.service.businesis;

import za.co.openset.dao.AddressRepo;
import za.co.openset.dao.businesis.CertificateRepo;
import za.co.openset.dao.businesis.CertificateSummaryRepo;
import za.co.openset.dao.businesis.CompanyBusinessRepo;
import za.co.openset.dao.businesis.DiagnosisRepo;
import za.co.openset.model.businesis.Certificate;
import za.co.openset.model.businesis.CertificateSummary;
import za.co.openset.model.businesis.CompanyBusiness;
import za.co.openset.model.businesis.Diagnosis;
import za.co.openset.utils.AManagerUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
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
    private CertificateRepo certificateRepo;

    @Inject
    private CertificateSummaryRepo certificateSummaryRepo;

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


    public CertificateSummary getCertSummaryById(Long certId) throws Exception {
        return certificateSummaryRepo.findById(certId);
    }
    public CertificateSummary getCompanyCertSummaryId(Long compId) throws Exception {
        return certificateSummaryRepo.findEntityByFieldName("companyId", compId);
    }

    public CertificateSummary updateCertificateSummary(CertificateSummary certificate) throws Exception {
        if (certificate.getCertificateSummaryId() != null) {
            aManagerUtils.setCommonFieldsUpdate(certificate, AManagerUtils.CREATED_BY);
        } else {
            aManagerUtils.setCommonFieldsCreate(certificate, AManagerUtils.CREATED_BY);
        }
        CertificateSummary updated = certificateSummaryRepo.update(certificate);
        return updated;
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
        Certificate cc = new Certificate();
        try {
            cc = getCompanyCertificate(diagnosis.getCompanyId(), diagnosis.getCompanySection());
        } catch (Exception e) {
            // do nothing because its expected error if there is no record.
            e.printStackTrace();
        }

        cc.setCompanyId(diagnosis.getCompanyId());
        cc.setCompanySection(diagnosis.getCompanySection());

        switch (diagnosis.getCompanySection()) {
            case "Governance":  cc = calculateCertValue(cc, diagnosis, 9);
                break;
            case "TaxCompliance":  cc = calculateCertValue(cc, diagnosis, 3);
                break;
            case "Labour": cc = calculateCertValue(cc, diagnosis, 5);
                break;
            case "SafetyHealth": cc = calculateCertValue(cc, diagnosis, 4);
                break;
            case "Standards": cc = calculateCertValue(cc, diagnosis, 1);
                break;
            case "BBBEE": cc = calculateCertValue(cc, diagnosis, 2);
                break;
            case "Production": cc = calculateCertValue(cc, diagnosis, 12);
                break;
            case "SalesMarketing": cc = calculateCertValue(cc, diagnosis, 10);
                break;
            case "InformationTechnology": cc = calculateCertValue(cc, diagnosis, 8);
                break;
            case "FinancialControlsManagement": cc = calculateCertValue(cc, diagnosis, 9);
                break;
            case "IntellectualProperty": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "RiskManagement": cc = calculateCertValue(cc, diagnosis, 7);
                break;
            case "TechnicalSiteVisit": cc = calculateCertValue(cc, diagnosis, 15);
                break;

        }
        return cc;
    }

    private Certificate calculateCertValue(Certificate cert, Diagnosis d, int totalNumberOfQues) {
        // put the diagnosis values in array
        Long [] darray = new Long[16];
        darray[0] = d.getQ0(); darray[1] = d.getQ1(); darray[2] = d.getQ2(); darray[3] = d.getQ3(); darray[4] = d.getQ4();
        darray[5] = d.getQ5(); darray[6] = d.getQ6(); darray[7] = d.getQ7(); darray[8] = d.getQ8(); darray[9] = d.getQ9();
        darray[10] = d.getQ10(); darray[11] = d.getQ11(); darray[12] = d.getQ12();
        darray[13] = d.getQ13(); darray[14] = d.getQ14(); darray[15] = d.getQ15();

        int totalOfNumber1s = 0;
        int totalOfNumber2s = 0;
        int totalOfNumber3s = 0;
        int totalOfNumber4s = 0;
        for (int i = 0; i < totalNumberOfQues + 1 ; i++) {
            if (darray[i] != null){
                if (1 == darray[i]) {
                    totalOfNumber1s++;
                } else if (2 == darray[i]) {
                    totalOfNumber2s++;
                } else if (3 == darray[i]) {
                    totalOfNumber3s++;
                } else if (4 == darray[i]) {
                    totalOfNumber4s++;
                }
            }
        }

        /**
         *
         * % number of ones.
         *
         */

        int percentageOf1s = (totalOfNumber1s / totalNumberOfQues) * 100;
        if (percentageOf1s == 100) {
            cert.setValue("1");
            cert.setDescription("High");

        } else if (percentageOf1s > 75) {
            cert.setValue("2");
            cert.setDescription("Medium");

        } else if (percentageOf1s < 75) {
            cert.setValue("3");
            cert.setDescription("Low");

        }

        /*
        if (totalOfNumber1s > (totalNumberOfQues/2)) {
            cert.setValue("1");
            cert.setDescription("High");
        } else if (totalOfNumber2s > (totalNumberOfQues/2)) {
            cert.setValue("2");
            cert.setDescription("2");
        } else if (totalOfNumber3s > (totalNumberOfQues/2)) {
            cert.setValue("3");
            cert.setDescription("3");
        } else if (totalOfNumber4s > (totalNumberOfQues/2)) {
            cert.setValue("4");
            cert.setDescription("4");
        } else {
            cert.setValue("2");
            cert.setDescription("2");
        }*/

       return cert;
    }

}
