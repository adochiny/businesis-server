package za.co.openset.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by adonis on 2015/06/04.
 */
@Entity
@Table(name="business_partner")
public class BusinessPartner extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "business_partner_seq")
    @SequenceGenerator(name = "business_partner_seq", sequenceName = "business_partner_seq")
    @Column(name = "business_partner_id")
    private Long businessPartnerId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "name1", length = 100)
    private String name1;

    @Column(name = "registration", length = 100)
    private String registration;

    @Column(name = "industry", length = 100)
    private String industry;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_registration")
    private Date dateOfRegistration;

    @Column(name = "registartion_type", length = 100)
    private String  registartionType;

    @Column(name = "notes", length = 50)
    private String notes;

    @Column(name = "number_of_members")
    private Long numberOfMembers;

    @Column(name = "years_in_operation")
    private Long yearsInOperation;

    /*@Column(name = "black_ownership", length = 50)
    private String blackOwnership;

    @Column(name = "black_female_ownership", length = 50)
    private String blackFemaleOwnership;

    @Column(name = "black_disable", length = 50)
    private String blackDisable;

    @Column(name = "black_youth", length = 50)
    private String blackYouth;

    @Column(name = "black_rural", length = 50)
    private String blackRural;

    @Column(name = "bee_level", length = 50)
    private String beeLevel;*/

    @Column(name = "company_type", length = 100)
    private String companyType;


    public Long getBusinessPartnerId() {
        return businessPartnerId;
    }

    public void setBusinessPartnerId(Long businessPartnerId) {
        this.businessPartnerId = businessPartnerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getRegistartionType() {
        return registartionType;
    }

    public void setRegistartionType(String registartionType) {
        this.registartionType = registartionType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(Long numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public Long getYearsInOperation() {
        return yearsInOperation;
    }

    public void setYearsInOperation(Long yearsInOperation) {
        this.yearsInOperation = yearsInOperation;
    }

    /*public String getBlackOwnership() {
        return blackOwnership;
    }

    public void setBlackOwnership(String blackOwnership) {
        this.blackOwnership = blackOwnership;
    }

    public String getBlackFemaleOwnership() {
        return blackFemaleOwnership;
    }

    public void setBlackFemaleOwnership(String blackFemaleOwnership) {
        this.blackFemaleOwnership = blackFemaleOwnership;
    }

    public String getBlackDisable() {
        return blackDisable;
    }

    public void setBlackDisable(String blackDisable) {
        this.blackDisable = blackDisable;
    }

    public String getBlackYouth() {
        return blackYouth;
    }

    public void setBlackYouth(String blackYouth) {
        this.blackYouth = blackYouth;
    }

    public String getBlackRural() {
        return blackRural;
    }

    public void setBlackRural(String blackRural) {
        this.blackRural = blackRural;
    }

    public String getBeeLevel() {
        return beeLevel;
    }

    public void setBeeLevel(String beeLevel) {
        this.beeLevel = beeLevel;
    }
*/
    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
}
