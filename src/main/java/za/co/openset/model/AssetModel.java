package za.co.openset.model;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/06.
 */
@Entity
@Table(name="asset_model",
        uniqueConstraints = @UniqueConstraint(columnNames = "model_number"))
public class AssetModel extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "asset_model_seq")
    @SequenceGenerator(name = "asset_model_seq", sequenceName = "asset_model_seq")
    @Column(name = "asset_model_id")
    private Long assetModelId;

    @Column(name = "model_number", unique = true)
    private String modelNumber;

    // Veriton 3900Pro
    @Column(name = "model_name", unique = true)
    private String modelName;

    @Column(name = "description")
    private String description;

    public Long getAssetModelId() {
        return assetModelId;
    }

    public void setAssetModelId(Long assetModelId) {
        this.assetModelId = assetModelId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
