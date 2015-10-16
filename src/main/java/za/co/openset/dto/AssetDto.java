package za.co.openset.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import za.co.openset.model.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adonis on 2015/06/04.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AssetDto extends BasePo {

    private Long assetId;

    private Long warehouseId;
    private Long assetCodeId;
    private Long assetSoftwareId;
    private List<Long> attributeIds = new ArrayList<>();

    private String serialNumber;
    private String processor;
    private String numberOfCores;
    private String ramInstalledSize;
    private String ramInstalledTechnology;
    private String hardDriveType;
    private String hardDriveSize;
    private Boolean wifi;
    private String manufacturerWarranty;
    private Double systemQuantity;
    private Double actualQuantity;
    private Double variance;

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getAssetCodeId() {
        return assetCodeId;
    }

    public void setAssetCodeId(Long assetCodeId) {
        this.assetCodeId = assetCodeId;
    }

    public Long getAssetSoftwareId() {
        return assetSoftwareId;
    }

    public void setAssetSoftwareId(Long assetSoftwareId) {
        this.assetSoftwareId = assetSoftwareId;
    }

    public List<Long> getAttributeIds() {
        return attributeIds;
    }

    public void setAttributeIds(List<Long> attributeIds) {
        this.attributeIds = attributeIds;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(String numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public String getRamInstalledSize() {
        return ramInstalledSize;
    }

    public void setRamInstalledSize(String ramInstalledSize) {
        this.ramInstalledSize = ramInstalledSize;
    }

    public String getRamInstalledTechnology() {
        return ramInstalledTechnology;
    }

    public void setRamInstalledTechnology(String ramInstalledTechnology) {
        this.ramInstalledTechnology = ramInstalledTechnology;
    }

    public String getHardDriveType() {
        return hardDriveType;
    }

    public void setHardDriveType(String hardDriveType) {
        this.hardDriveType = hardDriveType;
    }

    public String getHardDriveSize() {
        return hardDriveSize;
    }

    public void setHardDriveSize(String hardDriveSize) {
        this.hardDriveSize = hardDriveSize;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public String getManufacturerWarranty() {
        return manufacturerWarranty;
    }

    public void setManufacturerWarranty(String manufacturerWarranty) {
        this.manufacturerWarranty = manufacturerWarranty;
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
