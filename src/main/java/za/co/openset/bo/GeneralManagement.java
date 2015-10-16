package za.co.openset.bo;

/**
 * Created by adonis on 2015/06/28.
 */

import za.co.openset.model.AssetWarehouse;
import za.co.openset.model.Organisation;
import za.co.openset.model.user.User;
import za.co.openset.model.Warehouse;
import za.co.openset.service.AssetService;
import za.co.openset.service.GeneralService;
import za.co.openset.utils.AManagerUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/general-management")
public class GeneralManagement {
    protected Logger logger = Logger.getLogger(GeneralManagement.class.getName());

    @Inject
    private GeneralService generalService;

    @Inject
    private AssetService assetService;

    @Inject
    private AManagerUtils aManagerUtils;

    @GET
    @Path("/organisations")
    @Produces("application/json")
    public Response getAllOrganisations() throws Exception {
        //
        List<Organisation> allOrganisations = generalService.getAllOrganisations();
        for (Organisation organisation : allOrganisations) {
            organisation.setWarehouses(null);
            // nullify user dependencies and password.
            if (organisation.getUserList() != null) {
                for (User user : organisation.getUserList()) {
                    user.setOrganisation(null);
                    user.setPassword("");
                }
            }
        }
        return Response.status(Response.Status.OK).entity(allOrganisations).build();
    }

    @GET
    @Path("/warehouses")
    @Produces("application/json")
    public Response getAllWarehouses() throws Exception {
        //
        List<Warehouse> allWarehouses = generalService.getAllWarehouses();
        // nullify warehouse dependencies.
        for (Warehouse warehouse : allWarehouses) {
            warehouse.getOrganisation().setWarehouses(null);
        }
        return Response.status(Response.Status.OK).entity(allWarehouses).build();
    }

    @GET
    @Path("/asset-warehouses/{assetId}")
    @Produces("application/json")
    public Response getAssetWarehouses(@PathParam("assetId") Long assetId) throws Exception {
        List<AssetWarehouse> aws = assetService.getAllAssetWarehouses(assetId);
        Object[] objects = {};
        if (aws != null) {
            for (AssetWarehouse aw : aws) {
                if (aw.getWarehouse().getOrganisation() != null) {
                    aw.getWarehouse().getOrganisation().setUserList(null);
                    aw.getWarehouse().getOrganisation().setWarehouses(null);
                }
                if (aw.getAsset().getWarehouse().getOrganisation() != null) {
                    aw.getAsset().getWarehouse().getOrganisation().setUserList(null);
                    aw.getAsset().getWarehouse().getOrganisation().setWarehouses(null);
                }

            }
            objects = aws.toArray();
        }
        return Response.status(Response.Status.OK).entity(objects).build();
    }

    @POST
    @Path("/create-update-organisation")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAssetType(Organisation type) {
        logger.info("Organisation created or updated : " + type);

        if (type.getOrganisationId() != null) {
            aManagerUtils.setCommonFieldsUpdate(type, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(type, 101L);
        }
        try {
            type = generalService.update(type);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(type).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(type).build();
    }

    @POST
    @Path("/create-update-warehouse")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createAssetType(Warehouse type) {
        logger.info("Warehouse created or updated : " + type);

        if (type.getWarehouseId() != null) {
            aManagerUtils.setCommonFieldsUpdate(type, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(type, 101L);
        }
        try {
            type = generalService.update(type);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(type).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(type).build();
    }

}
