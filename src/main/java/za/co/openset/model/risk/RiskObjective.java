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

    // mapped to riskimpact., Many StrategicObjectives to 1 riskimpact
    @ManyToOne(optional=false,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="risk_impact_id",referencedColumnName="risk_impact_id")
    private RiskImpact riskImpact;



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






}
