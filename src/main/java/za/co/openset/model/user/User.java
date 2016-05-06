package za.co.openset.model.user;

import za.co.openset.model.*;
import za.co.openset.type.IdType;

import javax.persistence.*;
import java.util.*;

/**
 * Created by adonis on 2015/06/03.
 *
 */

@Entity
@Table(name="User_",
        uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User extends BasePo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    @Column(name = "user_id")
    private Long userId;

    /*
    Many to many with user role is parked till further notice
        as it is not required now
        at the moment, using manyToOne one directional.
    @ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinTable(name="user_role_join",
            joinColumns=
            @JoinColumn(name="user_id", referencedColumnName="user_id"),
            inverseJoinColumns=
            @JoinColumn(name="user_role_id", referencedColumnName="user_role_id")
    )
    private List<UserRole> userRoleList = new ArrayList<>();*/

    @ManyToOne(optional=true, cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="user_role_id",referencedColumnName="user_role_id")
    private UserRole userRole;


    @ManyToOne(optional=true, cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="organisation_id",referencedColumnName="organisation_id")
    private Organisation organisation;

    /*
        Contact details

        if it was bi-directional the below would be put in contactdetails.

       @OneToOne(optional=false,cascade=CascadeType.ALL,
       mappedBy="contactDetails",targetEntity=User.class)
       private User user;
     */

    @OneToOne(optional=true,cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "contact_details_id")
    private ContactDetails contactDetails;

    @OneToOne(optional=true,cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "username", length = 100, unique = true)
    private String username;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "first_name1", length = 100)
    private String firstName1;

    @Column(name = "first_name2", length = 100)
    private String firstName2;

    @Column(name = "first_name3", length = 100)
    private String firstName3;

    @Column(name = "surname", length = 100)
    private String surname;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "id_type", length = 115)
    @Enumerated(EnumType.STRING)
    private IdType idType;

    @Column(name = "id_number", length = 25)
    private String idNumber;

    @Column(name = "race", length = 50)
    private String race;

    @Column(name = "passport", length = 50)
    private String passport;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "gender", length = 6)
    private String gender;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "notes", length = 150)
    private String notes;

    @Column(name = "job_title", length = 100)
    private String jobTitle;

    @Column(name = "description", length = 100)
    private String description;

    // admin_user or company_user
    @Column(name = "user_type", length = 100, nullable = false)
    private String userType;

    @Transient
    private String authdata;

    @Column(name = "parent_id")
    private Long parentId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public void setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
    }

    public String getFirstName3() {
        return firstName3;
    }

    public void setFirstName3(String firstName3) {
        this.firstName3 = firstName3;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAuthdata() {
        return authdata;
    }

    public void setAuthdata(String authdata) {
        this.authdata = authdata;
    }
}
