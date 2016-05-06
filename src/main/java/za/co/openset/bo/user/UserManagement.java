package za.co.openset.bo.user;

import za.co.openset.bo.OptionsHandler;
import za.co.openset.dto.UserDto;
import za.co.openset.model.Address;
import za.co.openset.model.ContactDetails;
import za.co.openset.model.user.User;
import za.co.openset.model.user.UserRole;
import za.co.openset.service.AddressService;
import za.co.openset.service.UserRoleService;
import za.co.openset.service.UserService;
import za.co.openset.utils.AManagerUtils;
import za.co.openset.utils.CacheService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.logging.Logger;

@Path("/user-management")
public class UserManagement {
    protected Logger logger = Logger.getLogger(UserManagement.class.getName());

    @Inject
    private CacheService cacheService;

    @Inject
    private AddressService addressService;

    @Inject
    private UserService userService;

    @Inject
    private UserRoleService userRoleService;

    @Inject
    private AManagerUtils aManagerUtils;

    @Inject
    private OptionsHandler optionsHandler;

    @POST
    @Path("/create-update-user")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createUser(User user) {
        logger.info("User created or updated : " + user);

        /*if (!cacheService.isItemInCache(user.getUserReference())) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(user).build();
        }*/
        // User loggedUser = (User) cacheService.getItem(user.getUserReference());
        if (user.getUserId() != null) {
            aManagerUtils.setCommonFieldsUpdate(user, 100L);
        } else {
            aManagerUtils.setCommonFieldsCreate(user, 100L);
        }
        // update role details
        if (user.getUserRole() != null) {
            if (user.getUserRole().getRoleId() != null) {
                aManagerUtils.setCommonFieldsUpdate(user.getUserRole(), 100L);
            } else {
                aManagerUtils.setCommonFieldsCreate(user.getUserRole(), 100L);
            }
        }
        // update contact details
        if (user.getContactDetails() != null) {
            if (user.getContactDetails().getContactDetailsId() != null) {
                aManagerUtils.setCommonFieldsUpdate(user.getContactDetails(), 100L);
            } else {
                aManagerUtils.setCommonFieldsCreate(user.getContactDetails(), 100L);
            }
        }

        // update contact details
        if (user.getAddress() != null) {
            if (user.getAddress().getAddressId() != null) {
                aManagerUtils.setCommonFieldsUpdate(user.getAddress(), 100L);
            } else {
                aManagerUtils.setCommonFieldsCreate(user.getAddress(), 100L);
            }
        }

        try {
            user = userService.update(user);
            user.setPassword(null);
        } catch (Exception e) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity(user).build();
             user.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
             return Response.status(Response.Status.NOT_ACCEPTABLE).entity(user).build();
        }
        // create response.
        return Response.status(Response.Status.OK).entity(user).build();
    }

    @GET
    @Path("/users")
    @Produces("application/json")
    public Response getAllUsers() throws Exception {
        //
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            // nullify reverse values.
            nullifyUserObject(user);
        }
        return Response.status(Response.Status.OK).entity(users).build();
    }

    @GET
	@Path("/users/{id}")
	@Produces("application/json")
	public Response getUserById(@PathParam("id") Long id) throws Exception {
        logger.info("User by userId : " + id);
        //
        User user = userService.getUserById(id);
        if (user.getUserRole() != null) {
            user.getUserRole().setUserList(new ArrayList<User>());
        }
        return Response.status(Response.Status.OK).entity(user).build();
	}

    @GET
	@Path("/company-user/{companyId}")
	@Produces("application/json")
	public Response getCompanyUserById(@PathParam("companyId") Long companyId) throws Exception {
        logger.info("User by companyId : " + companyId);
        //
        User user = new User();
        try {
            user = userService.getCompanyUserById(companyId);
        } catch (Exception e){
            e.printStackTrace();
            user.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
            return Response.status(Response.Status.OK).entity(user).build();
        }
        if (user.getUserRole() != null) {
            user.getUserRole().setUserList(new ArrayList<User>());
        }
        return Response.status(Response.Status.OK).entity(user).build();
	}

    @POST
    @Path("/authenticate-user")
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticateUsername(UserDto userdto) throws Exception {
        logger.info("User auth : " + userdto.getUsername());

        Response res = optionsHandler.toResponse(null);
        //
        Map<String, Object> map = new HashMap<>();
        map.put("username",userdto.getUsername());
        map.put("password",userdto.getPassword());
        User user = new User();
        try {
            user = userService.getUserByField(map);
            // nullify reverse values.
            nullifyUserObject(user);

            String userRef = aManagerUtils.generateRandomString();
            cacheService.addItem(userRef, user);
            user.setUserReference(userRef);
            user.setPassword(null);
            return res.status(Response.Status.OK).entity(user).build();
        } catch (Exception e){
            e.printStackTrace();
            user.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
            return res.status(Response.Status.EXPECTATION_FAILED).entity(user).build();
            // return Response.status(Response.Status.EXPECTATION_FAILED).build();
        }
    }

    @POST
    @Path("/logout-user")
    @Consumes("application/json")
    @Produces("application/json")
    public Response logoutUser(User user) {
        logger.info("User created or updated : " + user);

        if (cacheService.isItemInCache(user.getUserReference())) {
            cacheService.removeItem(user.getUserReference());
        }
        nullifyUserObject(user);

        user.setPassword(null);
        // create response.
        return Response.status(Response.Status.OK).entity(user).build();
    }

    private void nullifyUserObject(User user) {
        // nullify reverse values.
        if (user.getUserRole() != null) {
            user.getUserRole().setUserList(null);
        }
        if (user.getOrganisation() != null) {
            user.getOrganisation().setUserList(null);
            user.getOrganisation().setWarehouses(null);
        }
    }


    @GET
    @Path("/users/username/{username}")
    @Produces("application/json")
    public Response getUserByUserName(@PathParam("username") String username) throws Exception {
        //
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        User user = userService.getUserByField(map);
        user.setUserRole(null);
        user.setContactDetails(null);
        return Response.status(Response.Status.OK).entity(user).build();
    }

    @GET
    @Path("/login/{username}/{password}")
    @Produces("application/json")
    public Response getUserByUserName(@PathParam("username") String username, @PathParam("password") String password) throws Exception {
        //
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        User user = new User();
        try {
            user = userService.login(map, password);
            // nullify secret information.
            user.setPassword(null);
            return Response.status(Response.Status.OK).entity(user).build();
        } catch (Exception e) {
            user.setException(org.apache.commons.lang.exception.ExceptionUtils.getStackTrace(e));
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(null).build();
        }

    }

    @GET
    @Path("/user-roles")
    @Produces("application/json")
    public Response getAllUserRoles() throws Exception {
        //
        List<UserRole> userRoles = userService.getAllUserRoles();
        for (UserRole userRole : userRoles) {
            userRole.setUserList(null);
        }
        return Response.status(Response.Status.OK).entity(userRoles).build();
    }

    @GET
    @Path("/createNewUser")
    @Produces("application/json")
    public Response createNewUser() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("username","ado@fnb.co.za");
        User user = null; // userService.getUserByField(map);
        if (user == null) {
            user = createFullUser();
        }
        user = userService.update(user);
        // create response.
        return Response.status(Response.Status.OK).entity(user).build();
    }


    @GET
    @Path("/address/{id}")
    @Produces("application/json")
    public Response getAddressById(@PathParam("id") Long id) throws Exception {
        Address address = new Address();
        address.setPcomplexName(id + "");
        address.setPstreetName("Lokesh");
        address.setPsuburb("Gupta");
        aManagerUtils.setCommonFieldsCreate(address, 101L);
        addressService.create(address);
        return Response.status(Response.Status.OK).entity(address).build();
    }

    private User createFullUser() throws Exception {
        User user = new User();
        aManagerUtils.setCommonFieldsCreate(user, 100L);
        user.setFirstName("Adonis");
        user.setSurname("Mhlanga");
        user.setUsername("ado@fnb.co.za");
        user.setPassword("P@ssw0rd");
        user.setDateOfBirth(new Date());

        UserRole role1 = new UserRole();
        aManagerUtils.setCommonFieldsCreate(role1, 100L);
        role1.setName("Admin");
        role1 = userRoleService.create(role1);
        user.setUserRole(role1);

        /*UserRole role2 = new UserRole();
        aManagerUtils.setCommonFieldsCreate(role2, 100L);
        role2.setName("User");
        role2 = userRoleService.create(role2);
        user.getUserRoleList().add(role2);

        UserRole role3 = new UserRole();
        aManagerUtils.setCommonFieldsCreate(role3, 100L);
        role3.setName("System");
        role3 = userRoleService.create(role3);
        user.getUserRoleList().add(role3);*/

        ContactDetails contactDetails = new ContactDetails();
        aManagerUtils.setCommonFieldsCreate(contactDetails, 100L);
        contactDetails.setCellNumber("0728030942");
        contactDetails.setEmail("adochiny@gmail.com");
        contactDetails.setTwitter("@adochiny");
        user.setContactDetails(contactDetails);
        return user;
    }
}
