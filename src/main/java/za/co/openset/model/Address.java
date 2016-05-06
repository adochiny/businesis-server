package za.co.openset.model;

import za.co.openset.type.AddressType;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/02.
 *
 */

@Entity
@Table(name="address")
public class Address extends BasePo {
    private static final long serialVersionUID = 7156583895159429281L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq")
    @Column(name = "address_id")
    private Long addressId;

    @Column(name="paddress_type")
    @Enumerated(EnumType.STRING)
    private AddressType paddressType;

    @Column(name="pcomplex_name")
    private String pcomplexName;

    @Column(name="ppo_box")
    private String ppoBox;

    @Column(name="punit_number")
    private String punitNumber;

    @Column(name="phouse_number")
    private String phouseNumber;

    @Column(name="pstreet_name")
    private String pstreetName;

    @Column(name="ppostal_code")
    private String ppostalCode;

    @Column(name="pcountry")
    private String pcountry;

    @Column(name="pprovince")
    private String pprovince;

    @Column(name="ptown")
    private String ptownCity;

    @Column(name="psuburb")
    private String psuburb;

    @Column(name="saddress_type")
    @Enumerated(EnumType.STRING)
    private AddressType saddressType;

    @Column(name="scomplex_name")
    private String scomplexName;

    @Column(name="spo_box")
    private String spoBox;

    @Column(name="sunit_number")
    private String sunitNumber;

    @Column(name="shouse_number")
    private String shouseNumber;

    @Column(name="sstreet_name")
    private String sstreetName;

    @Column(name="spostal_code")
    private String spostalCode;

    @Column(name="scountry")
    private String scountry;

    @Column(name="sprovince")
    private String sprovince;

    @Column(name="stown")
    private String stownCity;

    @Column(name="ssuburb")
    private String ssuburb;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public AddressType getPaddressType() {
        return paddressType;
    }

    public void setPaddressType(AddressType paddressType) {
        this.paddressType = paddressType;
    }

    public String getPcomplexName() {
        return pcomplexName;
    }

    public void setPcomplexName(String pcomplexName) {
        this.pcomplexName = pcomplexName;
    }

    public String getPpoBox() {
        return ppoBox;
    }

    public void setPpoBox(String ppoBox) {
        this.ppoBox = ppoBox;
    }

    public String getPunitNumber() {
        return punitNumber;
    }

    public void setPunitNumber(String punitNumber) {
        this.punitNumber = punitNumber;
    }

    public String getPhouseNumber() {
        return phouseNumber;
    }

    public void setPhouseNumber(String phouseNumber) {
        this.phouseNumber = phouseNumber;
    }

    public String getPstreetName() {
        return pstreetName;
    }

    public void setPstreetName(String pstreetName) {
        this.pstreetName = pstreetName;
    }

    public String getPpostalCode() {
        return ppostalCode;
    }

    public void setPpostalCode(String ppostalCode) {
        this.ppostalCode = ppostalCode;
    }

    public String getPcountry() {
        return pcountry;
    }

    public void setPcountry(String pcountry) {
        this.pcountry = pcountry;
    }

    public String getPprovince() {
        return pprovince;
    }

    public void setPprovince(String pprovince) {
        this.pprovince = pprovince;
    }

    public String getPtownCity() {
        return ptownCity;
    }

    public void setPtownCity(String ptownCity) {
        this.ptownCity = ptownCity;
    }

    public String getPsuburb() {
        return psuburb;
    }

    public void setPsuburb(String psuburb) {
        this.psuburb = psuburb;
    }

    public AddressType getSaddressType() {
        return saddressType;
    }

    public void setSaddressType(AddressType saddressType) {
        this.saddressType = saddressType;
    }

    public String getScomplexName() {
        return scomplexName;
    }

    public void setScomplexName(String scomplexName) {
        this.scomplexName = scomplexName;
    }

    public String getSpoBox() {
        return spoBox;
    }

    public void setSpoBox(String spoBox) {
        this.spoBox = spoBox;
    }

    public String getSunitNumber() {
        return sunitNumber;
    }

    public void setSunitNumber(String sunitNumber) {
        this.sunitNumber = sunitNumber;
    }

    public String getShouseNumber() {
        return shouseNumber;
    }

    public void setShouseNumber(String shouseNumber) {
        this.shouseNumber = shouseNumber;
    }

    public String getSstreetName() {
        return sstreetName;
    }

    public void setSstreetName(String sstreetName) {
        this.sstreetName = sstreetName;
    }

    public String getSpostalCode() {
        return spostalCode;
    }

    public void setSpostalCode(String spostalCode) {
        this.spostalCode = spostalCode;
    }

    public String getScountry() {
        return scountry;
    }

    public void setScountry(String scountry) {
        this.scountry = scountry;
    }

    public String getSprovince() {
        return sprovince;
    }

    public void setSprovince(String sprovince) {
        this.sprovince = sprovince;
    }

    public String getStownCity() {
        return stownCity;
    }

    public void setStownCity(String stownCity) {
        this.stownCity = stownCity;
    }

    public String getSsuburb() {
        return ssuburb;
    }

    public void setSsuburb(String ssuburb) {
        this.ssuburb = ssuburb;
    }
}
