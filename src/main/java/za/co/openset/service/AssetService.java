package za.co.openset.service;

import za.co.openset.dao.*;
import za.co.openset.dto.AssetSearchDto;
import za.co.openset.model.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by adonis on 2015/06/28.
 */

@Stateless
public class AssetService {

    @Inject
    private AssetTypeRepo assetTypeRepo;

    @Inject
    private AssetBrandRepo assetBrandRepo;

    @Inject
    private AssetModelRepo assetModelRepo;

    @Inject
    private AssetCodeRepo assetCodeRepo;

    @Inject
    private AssetSoftwareRepo assetSoftwareRepo;

    @Inject
    private AssetRepo assetRepo;

    @Inject
    private AssetWarehouseRepo assetWarehouseRepo;

    // AssetType functions
    public AssetType update(AssetType po) throws Exception {
        return assetTypeRepo.update(po);
    }
    public AssetType getAssetTypeById(Long id) throws Exception {
        return assetTypeRepo.findById(id);
    }
    public List<AssetType> getAllAssetTypes() throws Exception {
        return assetTypeRepo.findAll();
    }

    // AssetBrand functions
    public AssetBrand update(AssetBrand po) throws Exception {
        return assetBrandRepo.update(po);
    }
    public List<AssetBrand> getAllAssetBrands() throws Exception {
        return assetBrandRepo.findAll();
    }

    // AssetModel functions
    public AssetModel update(AssetModel po) throws Exception {
        return assetModelRepo.update(po);
    }
    public List<AssetModel> getAllAssetModels() throws Exception {
        return assetModelRepo.findAll();
    }

    // AssetCode functions
    public AssetCode update(AssetCode po) throws Exception {
        return assetCodeRepo.update(po);
    }
    public List<AssetCode> getAllAssetCodes() throws Exception {
        return assetCodeRepo.findAll();
    }

    // AssetSoftware functions
    public AssetSoftware update(AssetSoftware po) throws Exception {
        return assetSoftwareRepo.update(po);
    }
    public List<AssetSoftware> getAllAssetSoftwares() throws Exception {
        return assetSoftwareRepo.findAll();
    }

    // Asset functions
    public Asset update(Asset po) throws Exception {
        return assetRepo.update(po);
    }

    public List<Asset> getAllAssets(AssetSearchDto assetSearchDto) throws Exception {
        // Todo: write a QL select.
        // any of the values in the searchDto must be set.
        //
        return assetRepo.findAssets(assetSearchDto);
    }

    public List<AssetWarehouse> getAllAssetWarehouses(Long assetId) throws Exception {
        return assetWarehouseRepo.getAssetWarehouses(assetId);
    }

    public AssetWarehouse update(AssetWarehouse po) throws Exception {
        return assetWarehouseRepo.update(po);
    }

}
