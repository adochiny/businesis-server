package za.co.openset.model.risk;

import za.co.openset.model.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adonis on 2015/06/04.
 */
@Entity
@Table(name="strategic_objective")
public class StrategicObjective extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "strategic_objective_seq")
    @SequenceGenerator(name = "strategic_objective_seq", sequenceName = "strategic_objective_seq")
    @Column(name = "strategic_objective_id")
    private Long strategicObjectiveId;

    // mapped to riskimpact., Many StrategicObjectives to 1 riskimpact
    @ManyToOne(optional=false,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="risk_impact_id",referencedColumnName="risk_impact_id")
    private RiskImpact riskImpact;



    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    // Intel Core 2 Duo E4300 / 1.86 GHz
    @Column(name = "processor")
    private String processor;

    // Number of Cores Dual-Core
    @Column(name = "Number_of_Cores")
    private String numberOfCores;

    /*
    extra info on processor.
        64-bit Computing    Yes
        Data Bus Speed      800 MHz
        Chipset Type        Intel 945G Express

        Cache Memory
        Installed Size L2 cache - 2 MB
        Cache Per Processor 2 MB

        */

    // 512 MB / 8 GB (max)
    @Column(name = "ram_installed_size")
    private String ramInstalledSize;
    //DDR2 SDRAM
    @Column(name = "ram_installed_Technology")
    private String ramInstalledTechnology;

    /* extra ram properties.
    Memory Speed  533 MHz
            Features
    dual channel memory architecture
    */

    @Column(name = "hard_drive_type")
    private String hardDriveType;

    @Column(name = "hard_drive_size")
    private String hardDriveSize;

    @Column(name = "has_wifi")
    private Boolean wifi;


    /*Other hd specs
        Spindle Speed
        7200 rpm
        */

   /* Other networking specs
   Networking

    Data Link Protocol Ethernet, Fast Ethernet, Gigabit Ethernet
    Remote Management Protocol DMI 2.3.1
    Compliant Standards   WfM 2.0
    Form Factor  integrated

    Dimensions & Weight

    Width    4 in
    Depth    16.3 in
    Height   13.6 in

    Graphics Controller

    Form Factor   integrated
    Graphics Processor  Intel GMA 950 Dynamic Video Memory Technology 3.0
    Video Interfaces   VGA

    Audio Output

    Form Factor integrated
    Compliant Standards  High Definition Audio
   */

    // 3 years warranty
   @Column(name = "manufacturer_warranty")
   private String manufacturerWarranty;

    /* Keyboard yes
        Printer yes
    */

    // Link product to attributes.

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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

    public AssetCode getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(AssetCode assetCode) {
        this.assetCode = assetCode;
    }

    public AssetSoftware getAssetSoftware() {
        return assetSoftware;
    }

    public void setAssetSoftware(AssetSoftware assetSoftware) {
        this.assetSoftware = assetSoftware;
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
}
