package za.co.openset.model.businesis;

import za.co.openset.model.BasePo;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/03.
 *
 */

@Entity
@Table(name="certificate",
        uniqueConstraints = @UniqueConstraint(columnNames = "company_section_id"))
public class Certificate extends BasePo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "certificate_seq")
    @SequenceGenerator(name = "certificate_seq", sequenceName = "certificate_seq")
    @Column(name = "certificate_id")
    private Long certificateId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_section", length = 250)
    private String companySection;

    @Column(name = "company_section_id", length = 250)
    private String companySectionId;

    // new, inprogress and completed
    @Column(name = "status", length = 25)
    private String status;

    @Column(name = "value", length = 25)
    private String value;

    @Column(name = "description", length = 100)
    private String description;

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanySection() {
        return companySection;
    }

    public void setCompanySection(String companySection) {
        this.companySection = companySection;
    }

    public String getCompanySectionId() {
        return companySectionId;
    }

    public void setCompanySectionId(String companySectionId) {
        this.companySectionId = companySectionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
