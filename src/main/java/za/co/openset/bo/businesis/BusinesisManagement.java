package za.co.openset.bo.businesis;

/**
 * Created by adonis on 2015/06/28.
 *
 */

import za.co.openset.bo.OptionsHandler;
import za.co.openset.model.businesis.Certificate;
import za.co.openset.model.businesis.CompanyBusiness;
import za.co.openset.model.businesis.Diagnosis;
import za.co.openset.service.businesis.BusinesisService;
import za.co.openset.service.businesis.DiagnosisService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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

    @Inject
    private OptionsHandler optionsHandler;

    @GET
    @Path("/get-all-company-bp/{bpctype}")
    @Produces("application/json")
    public Response getAllCompanyBusiness(@PathParam("bpctype")String type) throws Exception {

        List<CompanyBusiness> all = businesisService.getAllCompanyBusiness(type);
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

    @GET
    @Path("/get-all-company-for-bp/{bpId}")
    @Produces("application/json")
    public Response getAllCompanyForBp(@PathParam("bpId")String bpId) throws Exception {
        //
        List<CompanyBusiness> all = businesisService.getAllCompaniesForBp(bpId);
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/get-company-bp-id/{bpId}")
    @Produces("application/json")
    public Response getAllCompanyBpById(@PathParam("bpId")Long bpId) throws Exception {
        //
        CompanyBusiness biz = new CompanyBusiness();
        try {
            biz = businesisService.getCompanyBpById(bpId);
        } catch (Exception e) {
            biz.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(biz).build();
        }
        return Response.status(Response.Status.OK).entity(biz).build();
    }

    @GET
    @Path("/get-all-diagnosis-for-company/{companyId}")
    @Produces("application/json")
    public Response getAllDiagnosisForCompany(@PathParam("companyId")Long companyId) throws Exception {
        //
        List<Diagnosis> all = new ArrayList<>();
        try {
            all = businesisService.getAllDiagnosisForCompany(companyId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE,e.getMessage());
            // companyBusiness.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
            // return Response.status(Response.Status.NOT_ACCEPTABLE).entity(companyBusiness).build();
        }
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/get-diagnosis-section-for-company/{companyId}/{companySection}")
    @Produces("application/json")
    public Response getAllDiagnosisForCompany(@PathParam("companyId")Long companyId,
                                              @PathParam("companySection")String companySection) throws Exception {
        //
        Diagnosis diagnosis = new Diagnosis();
        try {
            diagnosis = businesisService.getDiagnosisForCompany(companyId, companySection);
        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE,e.getMessage());
            diagnosis.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
             return Response.status(Response.Status.OK).entity(diagnosis).build();
        }
        return Response.status(Response.Status.OK).entity(diagnosis).build();
    }


    @POST
    @Path("/create-update-company-bp")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createCompanyBusiness(CompanyBusiness companyBusiness) {
        logger.info("companyBusiness created or updated : " + companyBusiness);
        Response res = optionsHandler.toResponse(null);
        try {
            companyBusiness = businesisService.update(companyBusiness);
        } catch (Exception e) {
            companyBusiness.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
            return res.status(Response.Status.NOT_ACCEPTABLE).entity(companyBusiness).build();
        }
        // create response.
        return res.status(Response.Status.OK).entity(companyBusiness).build();
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

    @GET
    @Path("/get-all-bps-for-company/{companyStatus}")
    @Produces("application/json")
    public Response getBPCompletedOrIncompleted(@PathParam("companyStatus")String companyStatus) throws Exception {
        //
        List<CompanyBusiness> all = new ArrayList<>();

        if (companyStatus.equalsIgnoreCase("COMPLETED")) {
            all = businesisService.getBPCompleted();
        } else {
            all = businesisService.getBPInCompleted();
        }
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/get-all-companies-for-bp/{bpId}/{companyStatus}")
    @Produces("application/json")
    public Response getAllCompaniesForBp(@PathParam("bpId")Long bpId, @PathParam("companyStatus")String companyStatus) throws Exception {
        //
        List<CompanyBusiness> all = businesisService.getAllCompaniesForBp(bpId, companyStatus);
        return Response.status(Response.Status.OK).entity(all).build();
    }

    @GET
    @Path("/get-all-companies-certs/{companyId}")
    @Produces("application/json")
    public Response getAllCompaniesCerts(@PathParam("companyId")Long companyId) throws Exception {
        //
        List<Certificate> all = businesisService.generateCertificates(companyId);
        return Response.status(Response.Status.OK).entity(all).build();
    }

}
