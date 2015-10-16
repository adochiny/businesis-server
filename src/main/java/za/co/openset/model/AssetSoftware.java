package za.co.openset.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by adonis on 2015/06/04.
 */

@Entity
@Table(name="asset_software",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class AssetSoftware extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "asset_software_seq")
    @SequenceGenerator(name = "asset_software_seq", sequenceName = "asset_software_seq")
    @Column(name = "asset_software_id")
    private Long assetSoftwareId;

    // Windows
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    // any value we might want to associate this with.
    @Column(name = "value")
    private Double value;

    //Miscrosoft
    @Column(name = "Manufacturer")
    private String manufacturer;

    // 1-to-many with the products.
    // but will not implement, too many value could be generated.
    /*
    @OneToMany(mappedBy="productSoftware",targetEntity=Asset.class, fetch=FetchType.EAGER)
    private List<Asset> assets;*/

    public Long getAssetSoftwareId() {
        return assetSoftwareId;
    }

    public void setAssetSoftwareId(Long assetSoftwareId) {
        this.assetSoftwareId = assetSoftwareId;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
