package za.co.openset.model;

import za.co.openset.model.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adonis on 2015/06/04.
 */
@Entity
@Table(name="organisation",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Organisation extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "organisation_seq")
    @SequenceGenerator(name = "organisation_seq", sequenceName = "organisation_seq")
    @Column(name = "organisation_id")
    private Long organisationId;

    @OneToMany(mappedBy="organisation",targetEntity=User.class,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy="organisation",targetEntity=Warehouse.class,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    private List<Warehouse> warehouses = new ArrayList<>();

    @OneToOne(optional=true, cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "contact_details_id")
    private ContactDetails contactDetails;

    @OneToOne(optional=true,cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "name", length = 100, unique = true)
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
    private String registartionType;

    @Column(name = "notes", length = 50)
    private String notes;

    @Column(name = "number_of_members")
    private Long numberOfMembers;

    @Column(name = "years_in_operation")
    private Long yearsInOperation;

    @Column(name = "company_type", length = 100)
    private String companyType;

    @Column(name = "related_org_id")
    private Long relatedOrgId;


    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
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

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public Long getRelatedOrgId() {
        return relatedOrgId;
    }

    public void setRelatedOrgId(Long relatedOrgId) {
        this.relatedOrgId = relatedOrgId;
    }
}
