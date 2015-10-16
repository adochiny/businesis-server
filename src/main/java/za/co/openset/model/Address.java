package za.co.openset.model;

import za.co.openset.type.AddressType;

import javax.persistence.*;

/**
 * Created by adonis on 2015/06/02.
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

    @Column(name="address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Column(name="complex_name")
    private String complexName;

    @Column(name="po_box")
    private String poBox;

    @Column(name="unit_number")
    private String unitNumber;

    @Column(name="house_number")
    private String houseNumber;

    @Column(name="street_name")
    private String streetName;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="erf_number")
    private String erfNumber;

    @Column(name="portion_number")
    private String portionNumber;

    @Column(name="country")
    private String country;

    @Column(name="province")
    private String province;

    @Column(name="town")
    private String townCity;

    @Column(name="suburb")
    private String suburb;

    @Column(name="AnotherNumber")
    private Long anotherNumber;

    public Long getAnotherNumber() {
        return anotherNumber;
    }

    public void setAnotherNumber(Long anotherNumber) {
        this.anotherNumber = anotherNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getErfNumber() {
        return erfNumber;
    }

    public void setErfNumber(String erfNumber) {
        this.erfNumber = erfNumber;
    }

    public String getPortionNumber() {
        return portionNumber;
    }

    public void setPortionNumber(String portionNumber) {
        this.portionNumber = portionNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
