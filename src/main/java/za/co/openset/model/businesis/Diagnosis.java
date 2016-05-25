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
@Table(name="diagnosis",
        uniqueConstraints = @UniqueConstraint(columnNames = "company_section_id"))
public class Diagnosis extends BasePo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "diagnosis_seq")
    @SequenceGenerator(name = "diagnosis_seq", sequenceName = "diagnosis_seq")
    @Column(name = "diagnosis_id")
    private Long diagnosisId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_section", length = 250)
    private String companySection;

    @Column(name = "company_section_id", length = 250)
    private String companySectionId;

    // new, inprogress and completed
    @Column(name = "status", length = 25)
    private String status;

    @Column(name = "q0")
    private Long q0;

    @Column(name = "q1")
    private Long q1;

    @Column(name = "q2")
    private Long q2;

    @Column(name = "q3")
    private Long q3;

    @Column(name = "q4")
    private Long q4;

    @Column(name = "q5")
    private Long q5;

    @Column(name = "q6")
    private Long q6;

    @Column(name = "q7")
    private Long q7;

    @Column(name = "q8")
    private Long q8;

    @Column(name = "q9")
    private Long q9;

    @Column(name = "q10")
    private Long q10;

    @Column(name = "q11")
    private Long q11;

    @Column(name = "q12")
    private Long q12;

    @Column(name = "q13")
    private Long q13;

    @Column(name = "ass_q1")
    private Long assq1;

    @Column(name = "ass_q2")
    private Long assq2;

    @Column(name = "ass_q3")
    private Long assq3;

    @Column(name = "ass_q4")
    private Long assq4;

    @Column(name = "ass_q5")
    private Long assq5;

    @Column(name = "ass_q6")
    private Long assq6;

    @Column(name = "ass_q7")
    private Long assq7;

    @Column(name = "ass_q8")
    private Long assq8;

    @Column(name = "ass_q9")
    private Long assq9;

    @Column(name = "ass_q10")
    private Long assq10;

    @Column(name = "ass_q11")
    private Long assq11;

    @Column(name = "ass_q12")
    private Long assq12;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public String getCompanySectionId() {
        return companySectionId;
    }

    public void setCompanySectionId(String companySectionId) {
        this.companySectionId = companySectionId;
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

    public Long getQ0() {
        return q0;
    }

    public void setQ0(Long q0) {
        this.q0 = q0;
    }

    public Long getQ1() {
        return q1;
    }

    public void setQ1(Long q1) {
        this.q1 = q1;
    }

    public Long getQ2() {
        return q2;
    }

    public void setQ2(Long q2) {
        this.q2 = q2;
    }

    public Long getQ3() {
        return q3;
    }

    public void setQ3(Long q3) {
        this.q3 = q3;
    }

    public Long getQ4() {
        return q4;
    }

    public void setQ4(Long q4) {
        this.q4 = q4;
    }

    public Long getQ5() {
        return q5;
    }

    public void setQ5(Long q5) {
        this.q5 = q5;
    }

    public Long getQ6() {
        return q6;
    }

    public void setQ6(Long q6) {
        this.q6 = q6;
    }

    public Long getQ7() {
        return q7;
    }

    public void setQ7(Long q7) {
        this.q7 = q7;
    }

    public Long getQ8() {
        return q8;
    }

    public void setQ8(Long q8) {
        this.q8 = q8;
    }

    public Long getQ9() {
        return q9;
    }

    public void setQ9(Long q9) {
        this.q9 = q9;
    }

    public Long getQ10() {
        return q10;
    }

    public void setQ10(Long q10) {
        this.q10 = q10;
    }

    public Long getQ11() {
        return q11;
    }

    public void setQ11(Long q11) {
        this.q11 = q11;
    }

    public Long getQ12() {
        return q12;
    }

    public void setQ12(Long q12) {
        this.q12 = q12;
    }

    public Long getQ13() {
        return q13;
    }

    public void setQ13(Long q13) {
        this.q13 = q13;
    }

    public Long getAssq1() {
        return assq1;
    }

    public void setAssq1(Long assq1) {
        this.assq1 = assq1;
    }

    public Long getAssq2() {
        return assq2;
    }

    public void setAssq2(Long assq2) {
        this.assq2 = assq2;
    }

    public Long getAssq3() {
        return assq3;
    }

    public void setAssq3(Long assq3) {
        this.assq3 = assq3;
    }

    public Long getAssq4() {
        return assq4;
    }

    public void setAssq4(Long assq4) {
        this.assq4 = assq4;
    }

    public Long getAssq5() {
        return assq5;
    }

    public void setAssq5(Long assq5) {
        this.assq5 = assq5;
    }

    public Long getAssq6() {
        return assq6;
    }

    public void setAssq6(Long assq6) {
        this.assq6 = assq6;
    }

    public Long getAssq7() {
        return assq7;
    }

    public void setAssq7(Long assq7) {
        this.assq7 = assq7;
    }

    public Long getAssq8() {
        return assq8;
    }

    public void setAssq8(Long assq8) {
        this.assq8 = assq8;
    }

    public Long getAssq9() {
        return assq9;
    }

    public void setAssq9(Long assq9) {
        this.assq9 = assq9;
    }

    public Long getAssq10() {
        return assq10;
    }

    public void setAssq10(Long assq10) {
        this.assq10 = assq10;
    }

    public Long getAssq11() {
        return assq11;
    }

    public void setAssq11(Long assq11) {
        this.assq11 = assq11;
    }

    public Long getAssq12() {
        return assq12;
    }

    public void setAssq12(Long assq12) {
        this.assq12 = assq12;
    }
}
