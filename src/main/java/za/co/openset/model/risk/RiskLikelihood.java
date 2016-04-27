package za.co.openset.model.risk;

import za.co.openset.model.BasePo;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/06.
 */
@Entity
@Table(name="risk_likelihood",
        uniqueConstraints = @UniqueConstraint(columnNames = "scale"))
public class RiskLikelihood extends BasePo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "risk_likelihood_seq")
    @SequenceGenerator(name = "risk_likelihood_seq", sequenceName = "risk_likelihood_seq")
    @Column(name = "risk_likelihood_id")
    private Long riskLikelihoodId;

    @Column(name = "scale", unique = true)
    private String scale;

    @Column(name = "description")
    private String description;

    public Long getRiskLikelihoodId() {
        return riskLikelihoodId;
    }

    public void setRiskLikelihoodId(Long riskLikelihoodId) {
        this.riskLikelihoodId = riskLikelihoodId;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
