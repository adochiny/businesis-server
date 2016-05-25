package za.co.openset.model.businesis;

import za.co.openset.model.BasePo;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/03.
 *
 */

@Entity
@Table(name="certificate_summary",
    uniqueConstraints = @UniqueConstraint(columnNames = "company_id"))
public class CertificateSummary extends BasePo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "certificate_summary_seq")
    @SequenceGenerator(name = "certificate_summary_seq", sequenceName = "certificate_summary_seq")
    @Column(name = "certificate_summary_id")
    private Long certificateSummaryId;

    @Column(name = "company_id")
    private Long companyId;

    // new, inprogress and completed
    @Column(name = "status", length = 25)
    private String status;

    @Column(name = "value", length = 2500)
    private String value;

    @Column(name = "description", length = 500)
    private String description;

    public Long getCertificateSummaryId() {
        return certificateSummaryId;
    }

    public void setCertificateSummaryId(Long certificateSummaryId) {
        this.certificateSummaryId = certificateSummaryId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
