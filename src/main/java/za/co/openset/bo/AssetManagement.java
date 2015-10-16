package za.co.openset.bo;

/**
 * Created by adonis on 2015/06/28.
 */

import za.co.openset.dto.AssetSearchDto;
import za.co.openset.model.*;
import za.co.openset.service.AssetService;
import za.co.openset.service.GeneralService;
import za.co.openset.type.AssetStatus;
import za.co.openset.utils.AManagerUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Path("/asset-management")
public class AssetManagement {
    protected Logger logger = Logger.getLogger(AssetManagement.class.getName());

    @Inject
    private AssetService assetService;

    @Inject
    private AManagerUtils aManagerUtils;

    @GET
    @Path("/asset-types")
    @Produces("application/json")
    public Response getAssetTypes() throws Exception {
        // no reverse link involved
        List<AssetType> allAssetTypes = assetService.getAllAssetTypes();
        return Response.status(Response.Status.OK).entity(allAssetTypes).build();
    }

    @GET
    @Path("/asset-brands")
    @Produces("application/json")
    public Response getAssetBrands() throws Exception {
        // no reverse link involved
        List<AssetBrand> allAssetBrands = assetService.getAllAssetBrands();
        return Response.status(Response.Status.OK).entity(allAssetBrands).build();
    }

    @GET
    @Path("/asset-models")
    @Produces("application/json")
    public Response getAssetModels() throws Exception {
        // no reverse link involved
        List<AssetModel> allAssetModels = assetService.getAllAssetModels();
        return Response.status(Response.Status.OK).entity(allAssetModels).build();
    }

    @GET
    @Path("/asset-codes")
    @Produces("application/json")
    public Response getAssetCodes() throws Exception {
        // no reverse link involved
        List<AssetCode> allAssetCodes = assetService.getAllAssetCodes();
        return Response.status(Response.Status.OK).entity(allAssetCodes).build();
    }

    @GET
    @Path("/asset-softwares")
    @Produces("application/json")
    public Response getAssetSoftwares() throws Exception {
        // no reverse link involved
        List<AssetSoftware> allAssetSoftwares = assetService.getAllAssetSoftwares();
        return Response.status(Response.Status.OK).entity(allAssetSoftwares).build();
    }

    @POST
    @Path("/assets")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getAssets(AssetSearchDto assetSearchDto) throws Exception {
        //
        List<Asset> allAssets = assetService.getAllAssets(assetSearchDto);
        // kill asset warehouse.orgs. warehouse
        for (Asset asset : allAssets) {

            // kill current warehouse
            if (asset.getWarehouse().getOrganisation() != null) {
                asset.getWarehouse().getOrganisation().setUserList(null);
                asset.getWarehouse().getOrganisation().setWarehouses(null);
            }

            /*if (asset.getAssetWarehouses() != null) {
                for (AssetWarehouse warehouse : asset.getAssetWarehouses()) {
                    if (warehouse.getWarehouse().getOrganisation() != null) {
                        warehouse.getWarehouse().getOrganisation().setUserList(null);
                        warehouse.getWarehouse().getOrganisation().setWarehouses(null);
                    }
                }
            }*/
        }
        return Response.status(Response.Status.OK).entity(allAssets).build();
    }


    @POST
    @Path("/assetWarehouses")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getAssetWarehouses(AssetSearchDto assetSearchDto) throws Exception {
        //
        List<Asset> allAssets = assetService.getAllAssets(assetSearchDto);
        // kill asset warehouse.orgs. warehouse
        for (Asset asset : allAssets) {

            // kill current warehouse
            if (asset.getWarehouse().getOrganisation() != null) {
                asset.getWarehouse().getOrganisation().setUserList(null);
                asset.getWarehouse().getOrganisation().setWarehouses(null);
            }

            /*if (asset.getAssetWarehouses() != null) {
                for (AssetWarehouse warehouse : asset.getAssetWarehouses()) {
                    if (warehouse.getWarehouse().getOrganisation() != null) {
                        warehouse.getWarehouse().getOrganisation().setUserList(null);
                        warehouse.getWarehouse().getOrganisation().setWarehouses(null);
                    }
                }
            }*/
        }
        return Response.status(Response.Status.OK).entity(allAssets).build();
    }

    @POST
    @Path("/create-update-asset-type")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAssetType(AssetType aType) {
        logger.info("aType created or updated : " + aType);

        if (aType.getAssetTypeId() != null) {
            aManagerUtils.setCommonFieldsUpdate(aType, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(aType, 101L);
        }
        try {
            aType = assetService.update(aType);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(aType).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(aType).build();
    }

    @POST
    @Path("/create-update-asset-brand")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAssetBrand(AssetBrand assetBrand) {
        logger.info("aBrand created or updated : " + assetBrand);

        if (assetBrand.getAssetBrandId() != null) {
            aManagerUtils.setCommonFieldsUpdate(assetBrand, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(assetBrand, 101L);
        }
        try {
            assetBrand = assetService.update(assetBrand);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(assetBrand).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(assetBrand).build();
    }

    @POST
    @Path("/create-update-asset-model")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAssetModel(AssetModel assetModel) {
        logger.info("aModel created or updated : " + assetModel);

        if (assetModel.getAssetModelId() != null) {
            aManagerUtils.setCommonFieldsUpdate(assetModel, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(assetModel, 101L);
        }
        try {
            assetModel = assetService.update(assetModel);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(assetModel).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(assetModel).build();
    }

    @POST
    @Path("/create-update-asset-software")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAssetSoftware(AssetSoftware assetSoftware) {
        logger.info("aSoftware created or updated : " + assetSoftware);

        if (assetSoftware.getAssetSoftwareId() != null) {
            aManagerUtils.setCommonFieldsUpdate(assetSoftware, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(assetSoftware, 101L);
        }
        try {
            assetSoftware = assetService.update(assetSoftware);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(assetSoftware).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(assetSoftware).build();
    }

    @POST
    @Path("/create-update-asset-code")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAssetCode(AssetCode assetCode) {
        logger.info("aCode created or updated : " + assetCode);

        if (assetCode.getAssetCodeId() != null) {
            aManagerUtils.setCommonFieldsUpdate(assetCode, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(assetCode, 101L);
        }
        try {
            assetCode = assetService.update(assetCode);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(assetCode).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(assetCode).build();
    }

    @POST
    @Path("/create-update-asset")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAsset(Asset asset) {
        logger.info("Asset created or updated : " + asset);

        if (asset.getAssetId() != null) {
            aManagerUtils.setCommonFieldsUpdate(asset, 101L);

            /*if (asset.getAssetWarehouses() != null && asset.getAssetWarehouses().size() > 0) {
                assetWarehouses = asset.getAssetWarehouses();
                // set all of the to inactive.
                for (AssetWarehouse assetWarehouse : assetWarehouses) {
                    assetWarehouse.setAssetStatus(AssetStatus.InActive);
                }
            }*/
        } else {
            aManagerUtils.setCommonFieldsCreate(asset, 101L);
        }
        try {

            /*// set current warehouse to the list.
            AssetWarehouse aw = new AssetWarehouse();

            // if warehouse already exist replace that one,
            // otherwise add a new one
            Boolean warehouseSet = false;
            for (AssetWarehouse assetWarehouse : assetWarehouses) {
                if (assetWarehouse.getWarehouse().getWarehouseId().equals(asset.getWarehouse().getWarehouseId())) {
                    aw = assetWarehouse;
                    warehouseSet = true;
                }
            }
            if (!warehouseSet) {
                assetWarehouses.add(aw);
            }

            // set asset warehouse vals
            aw.setAssetStatus(AssetStatus.Active);
            aw.setAsset(asset);
            aw.setWarehouse(asset.getWarehouse());
            assetWarehouses.add(aw);

            // link to asset.
            asset.setAssetWarehouses(assetWarehouses);*/

            asset = assetService.update(asset);
            // we not saving warehouse for this assets.
            // saveWarehouse(asset);

        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(asset).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(asset).build();
    }

    @POST
    @Path("/create-update-asset-wh-hist")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAssetWhouseHistory(Asset asset) {
        logger.info("Asset created or updated : " + asset);

        try {
            saveWarehouse(asset);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(asset).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(asset).build();
    }

    private void saveWarehouse(Asset savedAsset) throws Exception {
        List<AssetWarehouse> assetWarehouses = assetService.getAllAssetWarehouses(savedAsset.getAssetId());
        for (AssetWarehouse assetWarehouse : assetWarehouses) {
            assetWarehouse.setAssetStatus(AssetStatus.InActive);
            assetService.update(assetWarehouse);
        }

        AssetWarehouse assetWarehouse = new AssetWarehouse();
        aManagerUtils.setCommonFieldsCreate(assetWarehouse, 101L);
        assetWarehouse.setAsset(savedAsset);
        assetWarehouse.setWarehouse(savedAsset.getWarehouse());
        assetWarehouse.setAssetStatus(AssetStatus.Active);
        assetService.update(assetWarehouse);
    }


}
