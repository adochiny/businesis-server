package za.co.openset.model.risk;

import za.co.openset.model.*;
import za.co.openset.type.AddressType;
import za.co.openset.type.risk.FrequencyOfControls;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adonis on 2015/06/04.
 *
 */
@Entity
@Table(name="risk_objective")
public class RiskObjective extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "risk_objective_seq")
    @SequenceGenerator(name = "risk_objective_seq", sequenceName = "risk_objective_seq")
    @Column(name = "risk_objective_id")
    private Long riskObjectiveId;

    // mapped to riskimpact., Many Objectives to 1 riskimpact
    @ManyToOne(optional=false,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="risk_impact_id",referencedColumnName="risk_impact_id")
    private RiskImpact riskImpact;

    // mapped to risk_likelihood., Many Objectives to 1 risk_likelihood
    @ManyToOne(optional=false,
        cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="risk_likelihood_id",referencedColumnName="risk_likelihood_id")
    private RiskLikelihood riskLikelihood;

    // mapped to riskControlEffectiveness., Many Objectives to 1 riskControlEffectiveness
    @ManyToOne(optional=false,
        cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="risk_control_effectiveness_Id",referencedColumnName="risk_control_effectiveness_Id")
    private RiskControlEffectiveness riskControlEffectiveness;


    @Column(name = "management_mitigation")
    private String managementMitigation;

    @Column(name="frequency_of_controls")
    @Enumerated(EnumType.STRING)
    private FrequencyOfControls frequencyOfControls;

    @Column(name = "control_effectiveness")
    private String controlEffectiveness;

    @Column(name = "dashboards_monitoring_reporting")
    private String dashboardsMonitoringReporting;

    @Column(name = "accountable_person_department")
    private String accountablePersonDepartment;


    public Long getRiskObjectiveId() {
        return riskObjectiveId;
    }

    public void setRiskObjectiveId(Long riskObjectiveId) {
        this.riskObjectiveId = riskObjectiveId;
    }

    public RiskImpact getRiskImpact() {
        return riskImpact;
    }

    public void setRiskImpact(RiskImpact riskImpact) {
        this.riskImpact = riskImpact;
    }

    public RiskLikelihood getRiskLikelihood() {
        return riskLikelihood;
    }

    public void setRiskLikelihood(RiskLikelihood riskLikelihood) {
        this.riskLikelihood = riskLikelihood;
    }

    public RiskControlEffectiveness getRiskControlEffectiveness() {
        return riskControlEffectiveness;
    }

    public void setRiskControlEffectiveness(RiskControlEffectiveness riskControlEffectiveness) {
        this.riskControlEffectiveness = riskControlEffectiveness;
    }

    public String getManagementMitigation() {
        return managementMitigation;
    }

    public void setManagementMitigation(String managementMitigation) {
        this.managementMitigation = managementMitigation;
    }

    public FrequencyOfControls getFrequencyOfControls() {
        return frequencyOfControls;
    }

    public void setFrequencyOfControls(FrequencyOfControls frequencyOfControls) {
        this.frequencyOfControls = frequencyOfControls;
    }

    public String getControlEffectiveness() {
        return controlEffectiveness;
    }

    public void setControlEffectiveness(String controlEffectiveness) {
        this.controlEffectiveness = controlEffectiveness;
    }

    public String getDashboardsMonitoringReporting() {
        return dashboardsMonitoringReporting;
    }

    public void setDashboardsMonitoringReporting(String dashboardsMonitoringReporting) {
        this.dashboardsMonitoringReporting = dashboardsMonitoringReporting;
    }

    public String getAccountablePersonDepartment() {
        return accountablePersonDepartment;
    }

    public void setAccountablePersonDepartment(String accountablePersonDepartment) {
        this.accountablePersonDepartment = accountablePersonDepartment;
    }
}
