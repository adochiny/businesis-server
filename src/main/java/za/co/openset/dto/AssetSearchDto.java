package za.co.openset.dto;

import java.io.Serializable;

/**
 * Created by adonis on 2015/07/01.
 */
public class AssetSearchDto extends BaseDto {
    private Long assetTypeId;
    private Long assetBrandId;
    private Long assetModelId;
    private Long assetCodeId;
    private String serialNumber;

    public Long getAssetTypeId() {
        return assetTypeId;
    }

    public void setAssetTypeId(Long assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    public Long getAssetBrandId() {
        return assetBrandId;
    }

    public void setAssetBrandId(Long assetBrandId) {
        this.assetBrandId = assetBrandId;
    }

    public Long getAssetModelId() {
        return assetModelId;
    }

    public void setAssetModelId(Long assetModelId) {
        this.assetModelId = assetModelId;
    }

    public Long getAssetCodeId() {
        return assetCodeId;
    }

    public void setAssetCodeId(Long assetCodeId) {
        this.assetCodeId = assetCodeId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
