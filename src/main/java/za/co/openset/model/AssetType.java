package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/06.
 *
 * Desktop/ laptop/ etc
 */
@Entity
@Table(name="asset_type",
        uniqueConstraints = @UniqueConstraint(columnNames = "asset_type_number"))
public class AssetType extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "asset_type_seq")
    @SequenceGenerator(name = "asset_type_seq", sequenceName = "asset_type_seq")
    @Column(name = "asset_type_id")
    private Long assetTypeId;

    @Column(name = "asset_type_number", unique = true, nullable = false)
    private String assetTypeNumber;

    // Dell/Acer/hp/
    @Column(name = "asset_type_name", unique = true)
    private String assetTypeName;

    @Column(name = "description")
    private String description;

    // desktop
    @Column(name = "form_factor")
    private String formFactor;


    public Long getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(Long assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public String getAssetTypeNumber() {
        return assetTypeNumber;
    }

    public void setAssetTypeNumber(String assetTypeNumber) {
        this.assetTypeNumber = assetTypeNumber;
    }

    public String getAssetTypeName() {
        return assetTypeName;
    }

    public void setAssetTypeName(String assetTypeName) {
        this.assetTypeName = assetTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
