package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/06.
 */
@Entity
@Table(name="asset_brand",
        uniqueConstraints = @UniqueConstraint(columnNames = "brand_number"))
public class AssetBrand extends BasePo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "asset_brand_seq")
    @SequenceGenerator(name = "asset_brand_seq", sequenceName = "asset_brand_seq")
    @Column(name = "asset_brand_id")
    private Long assetBrandId;

    @Column(name = "brand_number", unique = true)
    private String brandNumber;

    // Dell/Acer/hp/
    @Column(name = "brand_name", unique = true)
    private String brandName;

    @Column(name = "description")
    private String description;

    //Acer
    @Column(name = "Manufacturer")
    private String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getAssetBrandId() {
        return assetBrandId;
    }

    public void setAssetBrandId(Long assetBrandId) {
        this.assetBrandId = assetBrandId;
    }

    public String getBrandNumber() {
        return brandNumber;
    }

    public void setBrandNumber(String brandNumber) {
        this.brandNumber = brandNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
