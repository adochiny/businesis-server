package za.co.openset.bo.risk;

/**
 * Created by adonis on 2015/06/28.
 *
 */

import za.co.openset.model.risk.*;
import za.co.openset.service.GeneralService;
import za.co.openset.service.risk.RiskService;
import za.co.openset.utils.AManagerUtils;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/risk-management")
public class RiskManagement {
    protected Logger logger = Logger.getLogger(RiskManagement.class.getName());

    @Inject
    private GeneralService generalService;

    @Inject
    private RiskService riskService;

    @Inject
    private AManagerUtils aManagerUtils;

    @GET
    @Path("/risk-categories")
    @Produces("application/json")
    public Response getRiskCategories() throws Exception {
        // no reverse link involved
        List<RiskCategory> all = riskService.getAllRiskCategories();
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/risk-sub-categories")
    @Produces("application/json")
    public Response getRiskSubCategories() throws Exception {
        // no reverse link involved
        List<RiskSubCategory> all = riskService.getAllRiskSubCategories();
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/risk-objectives")
    @Produces("application/json")
    public Response getRiskObjectives() throws Exception {
        // no reverse link involved
        List<RiskObjective> all = riskService.getAllRiskObjectives();
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/risk-likelihoods")
    @Produces("application/json")
    public Response getRiskLikelihoods() throws Exception {
        // no reverse link involved
        List<RiskLikelihood> all = riskService.getAllRiskLikelihoods();
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/risk-control_effectiveness")
    @Produces("application/json")
    public Response getRiskControlEffectiveness() throws Exception {
        // no reverse link involved
        List<RiskControlEffectiveness> all = riskService.getAllRiskControlEffectiveness();
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/risk-impact")
    @Produces("application/json")
    public Response getRiskImpacts() throws Exception {
        // no reverse link involved
        List<RiskImpact> all = riskService.getAllRiskImpacts();
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @POST
    @Path("/create-update-risk-category")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createRiskCategory(RiskCategory category) {
        logger.info("category created or updated : " + category);

        if (category.getRiskCategoryId() != null) {
            aManagerUtils.setCommonFieldsUpdate(category, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(category, 101L);
        }
        try {
            category = riskService.update(category);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(category).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(category).build();
    }

    @POST
    @Path("/create-update-risk-sub-category")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createRiskSubCategory(RiskSubCategory object) {
        logger.info("category created or updated : " + object);

        if (object.getRiskSubCategoryId() != null) {
            aManagerUtils.setCommonFieldsUpdate(object, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(object, 101L);
        }
        try {
            object = riskService.update(object);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(object).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(object).build();
    }

    @POST
    @Path("/create-update-risk-control-effectiveness")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createRiskControlEffectiveness(RiskControlEffectiveness object) {
        logger.info("category created or updated : " + object);

        if (object.getRiskControlEffectivenessId() != null) {
            aManagerUtils.setCommonFieldsUpdate(object, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(object, 101L);
        }
        try {
            object = riskService.update(object);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(object).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(object).build();
    }

    @POST
    @Path("/create-update-risk-likelihood")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createRiskLikelihood(RiskLikelihood object) {
        logger.info("category created or updated : " + object);

        if (object.getRiskLikelihoodId() != null) {
            aManagerUtils.setCommonFieldsUpdate(object, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(object, 101L);
        }
        try {
            object = riskService.update(object);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(object).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(object).build();
    }

    @POST
    @Path("/create-update-risk-objective")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createRiskObjective(RiskObjective object) {
        logger.info("category created or updated : " + object);

        if (object.getRiskObjectiveId() != null) {
            aManagerUtils.setCommonFieldsUpdate(object, 101L);
        } else {
            aManagerUtils.setCommonFieldsCreate(object, 101L);
        }
        try {
            object = riskService.update(object);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(object).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(object).build();
    }

    @GET
    @Path("/risk-objectives/{riskObjectivesId}")
    @Produces("application/json")
    public Response getAssetWarehouses(@PathParam("riskObjectivesId") Long riskObjectivesId) throws Exception {
        RiskObjective objective = riskService.getRiskObjectiveById(riskObjectivesId);
        return Response.status(Response.Status.OK).entity(objective).build();
    }

    /*@GET
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
    }*/

   /* @GET
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
    }*/

    /*@GET
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
*/
/*
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
*/

/*
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
*/


}
