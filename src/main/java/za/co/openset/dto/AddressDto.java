package za.co.openset.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by adonis on 2015/06/02.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AddressDto extends BaseDto {

    private Long addressId;
    private String addressType;
    private String complexName;
    private String poBox;
    private String unitNumber;
    private String houseNumber;
    private String streetName;
    private String postalCode;
    private String erfNumber;
    private String portionNumber;
    private String country;
    private String province;
    private String townCity;
    private String suburb;
    private Long anotherNumber;

    public Long getAnotherNumber() {
        return anotherNumber;
    }

    public void setAnotherNumber(Long anotherNumber) {
        this.anotherNumber = anotherNumber;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public String toString() {

        return super.toString() + "\n" + "AddressDto{" +
                "addressId=" + addressId +
                ", addressType='" + addressType + '\'' +
                ", complexName='" + complexName + '\'' +
                ", poBox='" + poBox + '\'' +
                ", unitNumber='" + unitNumber + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", erfNumber='" + erfNumber + '\'' +
                ", portionNumber='" + portionNumber + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", townCity='" + townCity + '\'' +
                ", suburb='" + suburb + '\'' +
                ", anotherNumber='" + anotherNumber + '\'' +
                '}';
    }
}
