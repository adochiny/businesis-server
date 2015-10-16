package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 */
@Entity
@Table(name="contact_details")
public class ContactDetails extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "contact_details_seq")
    @SequenceGenerator(name = "contact_details_seq", sequenceName = "contact_details_seq")
    @Column(name = "contact_details_id")
    private Long contactDetailsId;

    @Column(name = "contact_person", length = 100)
    private String contactPerson;

    @Column(name = "work_number", length = 50)
    private String workNumber;

    @Column(name = "home_number", length = 50)
    private String homeNumber;

    @Column(name = "cell_number", length = 50)
    private String cellNumber;

    @Column(name = "other_number", length = 50)
    private String otherNumber;

    @Column(name = "fax_number", length = 50)
    private String faxNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "website", length = 100)
    private String website;

    @Column(name = "twitter", length = 100)
    private String twitter;

    @Column(name = "facebook", length = 100)
    private String facebook;

    @Column(name = "linkedin", length = 100)
    private String linkedin;

    public Long getContactDetailsId() {
        return contactDetailsId;
    }

    public void setContactDetailsId(Long contactDetailsId) {
        this.contactDetailsId = contactDetailsId;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getOtherNumber() {
        return otherNumber;
    }

    public void setOtherNumber(String otherNumber) {
        this.otherNumber = otherNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
