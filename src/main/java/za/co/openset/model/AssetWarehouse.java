package za.co.openset.model;

import za.co.openset.type.AssetStatus;
import za.co.openset.type.WarehouseType;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/04.
 *
 * Link between asset and warehouse. An asset can move between warehouses.
 *
 */

@Entity
@Table(name="asset_warehouse")
public class AssetWarehouse extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "asset_warehouse_seq")
    @SequenceGenerator(name = "asset_warehouse_seq", sequenceName = "asset_warehouse_seq")
    @Column(name = "asset_warehouse_id")
    private Long assetWarehouseId;

    @ManyToOne(optional=true, cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="asset_id",referencedColumnName="asset_id")
    private Asset asset;

    // this object has 1-1 mapping with a warehouse.
    @OneToOne(optional=true,cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    // Active / InActive/ Retired
    @Column(name = "asset_status", length = 115)
    @Enumerated(EnumType.STRING)
    private AssetStatus assetStatus;


    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    //
    public Long getAssetWarehouseId() {
        return assetWarehouseId;
    }

    public void setAssetWarehouseId(Long assetWarehouseId) {
        this.assetWarehouseId = assetWarehouseId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public AssetStatus getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(AssetStatus assetStatus) {
        this.assetStatus = assetStatus;
    }
}
