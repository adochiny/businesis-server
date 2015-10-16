package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 *
 * Current value given to the product.
 */

@Entity
@Table(name="asset_cost")
public class AssetCost extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "asset_cost_seq")
    @SequenceGenerator(name = "asset_cost_seq", sequenceName = "asset_cost_seq")
    @Column(name = "asset_cost_id")
    private Long assetCostId;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "cost1")
    private Double cost1;

    @Column(name = "cost2")
    private Double cost2;

    public Long getAssetCostId() {
        return assetCostId;
    }

    public void setAssetCostId(Long assetCostId) {
        this.assetCostId = assetCostId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getCost1() {
        return cost1;
    }

    public void setCost1(Double cost1) {
        this.cost1 = cost1;
    }

    public Double getCost2() {
        return cost2;
    }

    public void setCost2(Double cost2) {
        this.cost2 = cost2;
    }
}
