package za.co.openset.model.risk;

import za.co.openset.model.BasePo;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/06.
 */
@Entity
@Table(name="risk_control_effectiveness",
        uniqueConstraints = @UniqueConstraint(columnNames = "scale"))
public class RiskControlEffectiveness extends BasePo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "risk_control_effectiveness_seq")
    @SequenceGenerator(name = "risk_control_effectiveness_seq", sequenceName = "risk_control_effectiveness_seq")
    @Column(name = "risk_impact_id")
    private Long riskControlEffectivenessId;

    @Column(name = "scale", unique = true)
    private String scale;

    @Column(name = "description")
    private String description;

    public Long getRiskControlEffectivenessId() {
        return riskControlEffectivenessId;
    }

    public void setRiskControlEffectivenessId(Long riskControlEffectivenessId) {
        this.riskControlEffectivenessId = riskControlEffectivenessId;
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
