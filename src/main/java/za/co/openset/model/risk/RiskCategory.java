package za.co.openset.model.risk;

import za.co.openset.model.BasePo;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/06.
 *
 */
@Entity
@Table(name="risk_category",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class RiskCategory extends BasePo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "risk_category_seq")
    @SequenceGenerator(name = "risk_category_seq", sequenceName = "risk_category_seq")
    @Column(name = "risk_category_id")
    private Long riskCategoryId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    public Long getRiskCategoryId() {
        return riskCategoryId;
    }

    public void setRiskCategoryId(Long riskCategoryId) {
        this.riskCategoryId = riskCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
