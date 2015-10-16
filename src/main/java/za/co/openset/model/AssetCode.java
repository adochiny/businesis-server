package za.co.openset.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by adonis on 2015/06/04.
 */

@Entity
@Table(name="asset_code")
public class AssetCode extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "asset_code_seq")
    @SequenceGenerator(name = "asset_code_seq", sequenceName = "asset_code_seq")
    @Column(name = "asset_code_id")
    private Long assetCodeId;

    // 1-to-many with the products.

    // Many asset code to 1 assetType
    @ManyToOne(optional=false,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="asset_type_id",referencedColumnName="asset_type_id")
    private AssetType assetType;

    // Many asset code to 1 brand
    @ManyToOne(optional=false,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="asset_brand_id",referencedColumnName="asset_brand_id")
    private AssetBrand assetBrand;

    // Many asset code to 1 model
    @ManyToOne(optional=false,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="asset_model_id",referencedColumnName="asset_model_id")
    private AssetModel assetModel;

    //1
    @Column(name = "packaged_quantity")
    private Long packagedQuantity;

    // Intel vPro Technology
    @Column(name = "platform_technology")
    private String platformTechnology;

    // Small form factor
    @Column(name = "asset_form_factor")
    private String assetFormFactor;

    // silver black
    @Column(name = "Colour")
    private String colour;

    // Todo: these are debatable
    @Column(name = "system_quantity")
    private Double systemQuantity;

    // SATA 1.5Gb/s
    @Column(name = "actual_quantity")
    private Double actualQuantity;

    @Column(name = "variance")
    private Double variance;

    // too many assets linked to one code.
    /*@OneToMany(mappedBy="assetCode",targetEntity=Asset.class, fetch=FetchType.EAGER)
    private List<Asset> assets;*/

    public Long getAssetCodeId() {
        return assetCodeId;
    }

    public void setAssetCodeId(Long assetCodeId) {
        this.assetCodeId = assetCodeId;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public AssetBrand getAssetBrand() {
        return assetBrand;
    }

    public void setAssetBrand(AssetBrand assetBrand) {
        this.assetBrand = assetBrand;
    }

    public AssetModel getAssetModel() {
        return assetModel;
    }

    public void setAssetModel(AssetModel assetModel) {
        this.assetModel = assetModel;
    }

    public Long getPackagedQuantity() {
        return packagedQuantity;
    }

    public void setPackagedQuantity(Long packagedQuantity) {
        this.packagedQuantity = packagedQuantity;
    }

    public String getPlatformTechnology() {
        return platformTechnology;
    }

    public void setPlatformTechnology(String platformTechnology) {
        this.platformTechnology = platformTechnology;
    }

    public String getAssetFormFactor() {
        return assetFormFactor;
    }

    public void setAssetFormFactor(String assetFormFactor) {
        this.assetFormFactor = assetFormFactor;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getSystemQuantity() {
        return systemQuantity;
    }

    public void setSystemQuantity(Double systemQuantity) {
        this.systemQuantity = systemQuantity;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }
}
