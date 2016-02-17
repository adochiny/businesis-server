package za.co.openset.model.risk;

import za.co.openset.model.AssetType;
import za.co.openset.model.BasePo;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/06.
 *
 */
@Entity
@Table(name="risk_sub_category",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class RiskSubCategory extends BasePo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "risk_sub_category_seq")
    @SequenceGenerator(name = "risk_sub_category_seq", sequenceName = "risk_sub_category_seq")
    @Column(name = "risk_sub_category_id")
    private Long riskSubCategoryId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;


    // Many risk_sub categorys to 1 risk_category
    @ManyToOne(optional=false,
        cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="risk_category_id",referencedColumnName="risk_category_id")
    private RiskCategory riskCategory;

    public Long getRiskSubCategoryId() {
        return riskSubCategoryId;
    }

    public void setRiskSubCategoryId(Long riskSubCategoryId) {
        this.riskSubCategoryId = riskSubCategoryId;
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

    public RiskCategory getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(RiskCategory riskCategory) {
        this.riskCategory = riskCategory;
    }
}
