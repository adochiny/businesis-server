package za.co.openset.model.risk;

import za.co.openset.model.BasePo;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/06.
 *
 */
@Entity
@Table(name="risk_impact",
        uniqueConstraints = @UniqueConstraint(columnNames = "scale"))
public class RiskImpact extends BasePo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "risk_impact_seq")
    @SequenceGenerator(name = "risk_impact_seq", sequenceName = "risk_impact_seq")
    @Column(name = "risk_impact_id")
    private Long riskImpactId;

    @Column(name = "scale", unique = true)
    private String scale;

    @Column(name = "description")
    private String description;

    public Long getRiskImpactId() {
        return riskImpactId;
    }

    public void setRiskImpactId(Long riskImpactId) {
        this.riskImpactId = riskImpactId;
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
