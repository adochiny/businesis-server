package za.co.openset.bo.businesis;

/**
 * Created by adonis on 2015/06/28.
 *
 */

import za.co.openset.model.businesis.CompanyBusiness;
import za.co.openset.model.businesis.Diagnosis;
import za.co.openset.service.businesis.BusinesisService;
import za.co.openset.service.businesis.DiagnosisService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/company-bp")
public class BusinesisManagement {

    //http://localhost:8081/businesis/company-bp/create-update-company-bp
    //http://localhost:8081/businesis/company-bp/get-all-company-bp
    protected Logger logger = Logger.getLogger(BusinesisManagement.class.getName());

    @Inject
    private BusinesisService businesisService;

    @Inject
    private DiagnosisService diagnosisService;

    @GET
    @Path("/get-all-company-bp")
    @Produces("application/json")
    public Response getAllCompanyBusiness() throws Exception {

        List<CompanyBusiness> all = businesisService.getAllCompanyBusiness();
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/get-all-company-diagnosis/{companySectionId}")
    @Produces("application/json")
    public Response getAllCompanyDiagnosis(@PathParam("companySectionId")String companySectionId) throws Exception {
        //
        List<Diagnosis> all = diagnosisService.getAllCompanyDiagnosis(companySectionId);
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @POST
    @Path("/create-update-company-bp")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createCompanyBusiness(CompanyBusiness companyBusiness) {
        logger.info("companyBusiness created or updated : " + companyBusiness);

        try {
            companyBusiness = businesisService.update(companyBusiness);
        } catch (Exception e) {
            companyBusiness.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(companyBusiness).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(companyBusiness).build();
    }

    @POST
    @Path("/create-update-company-diagnosis")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createCompanyDiagnosis(Diagnosis diagnosis) {
        logger.info("companyBusiness created or updated : " + diagnosis);

        try {
            diagnosis = diagnosisService.update(diagnosis);
        } catch (Exception e) {
            diagnosis.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(diagnosis).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(diagnosis).build();
    }


}
