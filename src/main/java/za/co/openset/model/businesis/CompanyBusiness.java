package za.co.openset.model.businesis;

import za.co.openset.model.Address;
import za.co.openset.model.BasePo;
import za.co.openset.model.ContactDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adonis on 2015/06/03.
 *
 */

@Entity
@Table(name="company_business",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CompanyBusiness extends BasePo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "company_business_seq")
    @SequenceGenerator(name = "company_business_seq", sequenceName = "company_business_seq")
    @Column(name = "company_business_id")
    private Long companyBusinessId;

    @OneToOne(optional=true,cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "contact_details_id")
    private ContactDetails contactDetails;

    @OneToOne(optional=true,cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "postal_address_id")
    private Address postalAddress;

    @Transient
    private List<Address> addresses = new ArrayList<>();

    @Column(name = "name", length = 150, unique = true)
    private String name;

    @Column(name = "trading_as", length = 150)
    private String tradingAs;

    @Column(name = "registration_number", length = 150)
    private String registrationNumber;

    @Column(name = "registartion_type", length = 150)
    private String registartionType;

    @Column(name = "date_of_registration")
    @Temporal(TemporalType.DATE)
    private Date dateOfRegistration;

    @Column(name = "industry", length = 150)
    private String industry;

    @Column(name = "years_in_business", length = 150)
    private String yearsInBusiness;

    @Column(name = "number_of_employees", length = 150)
    private String numberOfEmployees;

    @Column(name = "annual_turnover", length = 150)
    private String annualTurnover;

    @Column(name = "income_tax_number", length = 150)
    private String incomeTaxNumber;

    @Column(name = "VAT_number", length = 150)
    private String vatNumber;

    @Column(name = "PAYE_number", length = 150)
    private String payeNumber;

    @Column(name = "UIF_number", length = 150)
    private String uifNumber;

    @Column(name = "COID_number", length = 150)
    private String coidNumber;

    @Column(name = "professional_standards_number", length = 150)
    private String professionalStandardsNumber;

    @Column(name = "bee_contributer", length = 150)
    private String beeContributer;

    @Column(name = "BBBEE_certificate_number", length = 150)
    private String bbbeeCertificateNumber;

    @Column(name = "BBBEE_status_level", length = 150)
    private String bbbeeStatusLevel;

    // new, inprogress and completed
    @Column(name = "status", length = 25)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCompanyBusinessId() {
        return companyBusinessId;
    }

    public void setCompanyBusinessId(Long companyBusinessId) {
        this.companyBusinessId = companyBusinessId;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradingAs() {
        return tradingAs;
    }

    public void setTradingAs(String tradingAs) {
        this.tradingAs = tradingAs;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistartionType() {
        return registartionType;
    }

    public void setRegistartionType(String registartionType) {
        this.registartionType = registartionType;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getYearsInBusiness() {
        return yearsInBusiness;
    }

    public void setYearsInBusiness(String yearsInBusiness) {
        this.yearsInBusiness = yearsInBusiness;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(String annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public String getIncomeTaxNumber() {
        return incomeTaxNumber;
    }

    public void setIncomeTaxNumber(String incomeTaxNumber) {
        this.incomeTaxNumber = incomeTaxNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getPayeNumber() {
        return payeNumber;
    }

    public void setPayeNumber(String payeNumber) {
        this.payeNumber = payeNumber;
    }

    public String getUifNumber() {
        return uifNumber;
    }

    public void setUifNumber(String uifNumber) {
        this.uifNumber = uifNumber;
    }

    public String getCoidNumber() {
        return coidNumber;
    }

    public void setCoidNumber(String coidNumber) {
        this.coidNumber = coidNumber;
    }

    public String getBbbeeCertificateNumber() {
        return bbbeeCertificateNumber;
    }

    public void setBbbeeCertificateNumber(String bbbeeCertificateNumber) {
        this.bbbeeCertificateNumber = bbbeeCertificateNumber;
    }

    public String getBbbeeStatusLevel() {
        return bbbeeStatusLevel;
    }

    public void setBbbeeStatusLevel(String bbbeeStatusLevel) {
        this.bbbeeStatusLevel = bbbeeStatusLevel;
    }

    public String getProfessionalStandardsNumber() {
        return professionalStandardsNumber;
    }

    public void setProfessionalStandardsNumber(String professionalStandardsNumber) {
        this.professionalStandardsNumber = professionalStandardsNumber;
    }

    public String getBeeContributer() {
        return beeContributer;
    }

    public void setBeeContributer(String beeContributer) {
        this.beeContributer = beeContributer;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
