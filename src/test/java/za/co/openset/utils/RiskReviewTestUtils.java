package za.co.openset.utils;

import za.co.openset.model.*;
import za.co.openset.model.risk.*;
import za.co.openset.model.user.User;
import za.co.openset.model.user.UserRole;
import za.co.openset.type.AddressType;
import za.co.openset.type.AssetStatus;
import za.co.openset.type.risk.FrequencyOfControls;

import java.util.*;

/**
 * Created by adonis on 2015/06/05.
 *
 */
public class RiskReviewTestUtils {
    // create random object
    private Random randomno = new Random();

    public Long generateRandomLong() {
        // get next long value
        return randomno.nextLong();
    }

    public Integer generateRandomInt() {
        // get next int value
        return randomno.nextInt();
    }

    public Double generateRandomDouble() {
        // get next double value
        return randomno.nextDouble();
    }

    public static String generateRandomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 29; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public Organisation createOrganisation() {
        Organisation org = new Organisation();
        setCommonFieldsCreate(org, 1L);
        org.setName(generateRandomString());
        return org;
    }

    public User createUser() {
        User user = new User();
        setCommonFieldsCreate(user, 1L);
        user.setFirstName(generateRandomString());
        user.setSurname(generateRandomString());
        user.setDateOfBirth(new Date());
        return user;
    }

    public UserRole createUserRole() {
        UserRole role = new UserRole();
        setCommonFieldsCreate(role, 1L);
        role.setName("Role1");
        return role;
    }

    public void setCommonFieldsCreate(BasePo po, Long crBy) {
        Calendar created = Calendar.getInstance();
        created.setTime(new Date());
        po.setIsactive(Boolean.TRUE);
        po.setCreated(new Date());
        po.setUpdated(new Date());
        po.setCreatedby(crBy);
        po.setUpdatedby(crBy);
    }

    public Address createAddress() {
        Address add = new Address();
        setCommonFieldsCreate(add, 1L);
        add.setAddressType(AddressType.Physical);
        add.setComplexName(generateRandomString());
        add.setCountry(generateRandomString());
        add.setPostalCode(generateRandomString());
        add.setStreetName(generateRandomString());
        add.setSuburb(generateRandomString());
        add.setTownCity(generateRandomString());
        add.setProvince(generateRandomString());
        return add;
    }

    public ContactDetails createContactDetails() {
        ContactDetails add = new ContactDetails();
        setCommonFieldsCreate(add, 1L);
        add.setCellNumber(generateRandomString());
        add.setEmail("adochiny@gmail.com");
        add.setCellNumber(generateRandomString());
        return add;
    }

    public Warehouse createWarehouse() {
        Warehouse add = new Warehouse();
        setCommonFieldsCreate(add, 1L);
        add.setDescription(generateRandomString());
        add.setName(generateRandomString());
        add.setAddress(createAddress());
        add.setOrganisation(createOrganisation());
        return add;
    }

    public AssetWarehouse createAssetWarehouse(Asset asset) {
        AssetWarehouse add = new AssetWarehouse();
        setCommonFieldsCreate(add, 1L);
        add.setAsset(asset);
        add.setWarehouse(asset.getWarehouse());
        add.setAssetStatus(AssetStatus.Active);
        return add;
    }


    public Asset createAsset() {
        Asset add = new Asset();
        setCommonFieldsCreate(add, 1L);
        add.setAssetCode(createAssetCode());
        add.setSerialNumber(generateRandomString());
        add.setAssetSoftware(createAssetSoftware());
        add.setSerialNumber(generateRandomString());
        return add;
    }

    public Attribute createAssetAttribute() {
        Attribute add = new Attribute();
        setCommonFieldsCreate(add, 1L);
        add.setName(generateRandomString());
        add.setDescription(generateRandomString());
        add.setValue(generateRandomString());
        return add;
    }

    public AssetCode createAssetCode() {
        AssetCode add = new AssetCode();
        setCommonFieldsCreate(add, 1L);
        add.setAssetBrand(createAssetBrand());
        add.setAssetModel(createAssetModel());
        add.setAssetType(createAssetType());
        add.setColour("silver");
        add.setPlatformTechnology("Intel vPro Technology");
        return add;
    }

    public AssetType createAssetType() {
        AssetType add = new AssetType();
        setCommonFieldsCreate(add, 1L);
        // add.setAssetTypeName("Desktop");
        // add.setAssetTypeNumber("0001");
        add.setAssetTypeName(generateRandomString());
        add.setAssetTypeNumber(generateRandomString());
        return add;
    }

    public AssetModel createAssetModel() {
        AssetModel add = new AssetModel();
        setCommonFieldsCreate(add, 1L);
        // add.setModelName("Dell");
        // add.setModelNumber("0005");
        add.setModelName(generateRandomString());
        add.setModelNumber(generateRandomString());
        return add;
    }

    public AssetBrand createAssetBrand() {
        AssetBrand add = new AssetBrand();
        setCommonFieldsCreate(add, 1L);
        //add.setBrandName("Optiplex 960");
        add.setBrandName(generateRandomString());
        // add.setBrandNumber("0048");
        add.setBrandNumber(generateRandomString());
        return add;
    }

    public AssetSoftware createAssetSoftware() {
        AssetSoftware add = new AssetSoftware();
        setCommonFieldsCreate(add, 1L);
        add.setName(generateRandomString());
        add.setDescription(generateRandomString());
        return add;
    }

    public RiskImpact createRiskImpact() {
        RiskImpact ri = new RiskImpact();
        setCommonFieldsCreate(ri, 1L);
        ri.setScale(generateRandomString());
        ri.setDescription(generateRandomString());
        return ri;
    }

    public RiskControlEffectiveness createRiskControlEffectiveness() {
        RiskControlEffectiveness ri = new RiskControlEffectiveness();
        setCommonFieldsCreate(ri, 1L);
        ri.setScale(generateRandomString());
        ri.setDescription(generateRandomString());
        return ri;
    }

    public RiskLikelihood createRiskLikelihood() {
        RiskLikelihood ri = new RiskLikelihood();
        setCommonFieldsCreate(ri, 1L);
        ri.setScale(generateRandomString());
        ri.setDescription(generateRandomString());
        return ri;
    }

    public RiskCategory createRiskCategory() {
        RiskCategory ri = new RiskCategory();
        setCommonFieldsCreate(ri, 1L);
        ri.setName(generateRandomString());
        ri.setDescription(generateRandomString());
        return ri;
    }

    public RiskSubCategory createRiskSubCategory() {
        RiskSubCategory ri = new RiskSubCategory();
        setCommonFieldsCreate(ri, 1L);
        ri.setName(generateRandomString());
        ri.setDescription(generateRandomString());
        return ri;
    }
    public RiskObjective createRiskObjective() {
        RiskObjective ro = new RiskObjective();
        setCommonFieldsCreate(ro, 1L);
        ro.setAccountablePersonDepartment(generateRandomString());
        ro.setDashboardsMonitoringReporting(generateRandomString());
        ro.setManagementMitigation(generateRandomString());
        ro.setFrequencyOfControls(FrequencyOfControls.Daily);
        ro.setControlEffectiveness(generateRandomString());
        return ro;
    }


}
