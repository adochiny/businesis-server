package za.co.openset.bo;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Ignore;
import org.junit.Test;
import za.co.openset.dto.UserDto;
import za.co.openset.model.user.User;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
public class UserManagementTest {
    RiskReviewTestUtils iManagerTestUtils = new RiskReviewTestUtils();

    @Test
    @Ignore
    public void testCreateUser() throws Exception {

        User user = iManagerTestUtils.createUser();
        user.setFirstName("AdonisTest123");
        user.setSurname("MhlangaTest123");
        user.setUsername("adonisTest123");
        user.setPassword("P@ssw0rd");
        user.setDateOfBirth(new Date());

        // update this val
        user.setUserReference("jegeptjvlgakvcajamwujrbcphdyq");

        // UserRole role = iManagerTestUtils.createUserRole();
        // user.setUserRole(role);
        assertNotNull(user);

        // UserRole userRole = user.getUserRole();
        // assertNotNull(userRole);


		/*
         *  Alternatively you can use this simple String to send
		 *  instead of using a Student instance
		 *
		 *  String jsonString = "{\"id\":12,\"firstName\":\"Catain\",\"lastName\":\"Hook\",\"age\":10}";
		 */

        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client
                    .target("http://localhost:8080/iManager/user-management/create-update-user");
            Response response = target.request().post(Entity.entity(user, "application/json"));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            System.out.println("Server response : \n");
            System.out.println(response.readEntity(String.class));
            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    @Ignore
    public void testAuthUser() throws Exception {

        UserDto userDto = new UserDto();

        userDto.setUsername("adonis@fnb.co.za");
        userDto.setPassword("123");

        assertNotNull(userDto);

        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client
                    .target("http://localhost:8080/iManager/user-management/authenticate-username");
            Response response = target.request().post(Entity.entity(userDto, "application/json"));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            System.out.println("Server response : \n");
            System.out.println(response.readEntity(String.class));
            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

  /*  @Test
    public void testAllConsultants() throws Exception {

        ConsultantInfoRequest request = new ConsultantInfoRequest("Group1");
        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client
                    .target("http://localhost:8080/sale-source-service/services/salesourceapi/allconsultants");
            Response response = target.request().post(Entity.entity(request, "application/json"));
            if (response.getStatus() != 200) {
                System.out.println("Server response : \n" + response.toString());
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            System.out.println("Server response : \n");
            System.out.println(response.readEntity(String.class));
            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
*/


 /*   @Test
    public void getInformationPropertyDetail () {

        ResteasyClient client = new ResteasyClientBuilder().build();

        // String url = SaleSourceURLBuilder.getURL();
        ResteasyWebTarget target = client.target("http://localhost:8080/sale-source-service/services/salesourceapi/allconsultants");
        Response response = target.request(MediaType.APPLICATION_XML).get();
        List<ConsultantInfo> result = null;
        if (response.getStatus() == 200) {
            result = response.readEntity(new GenericType<List<ConsultantInfo>>(){});
        }
        response.close();
        System.out.println(result);
    }*/

    @Test
    @Ignore
    public void testLogoutUser() throws Exception {

        User user = iManagerTestUtils.createUser();

        user.setUsername("adonis@fnb.co.za");
        user.setPassword("123");

        user.setUserReference("jegeptjvlgakvcajamwujrbcphdyq");

        assertNotNull(user);

        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client
                    .target("http://localhost:8080/iManager/user-management/logout-user");
            Response response = target.request().post(Entity.entity(user, "application/json"));
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            System.out.println("Server response : \n");
            System.out.println(response.readEntity(String.class));
            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Ignore
    public void testGetUserRoles() throws Exception {

        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client
                    .target("http://localhost:8080/iManager/user-management/user-roles");
            Response response = target.request().get();
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
            }
            System.out.println("Server response : \n");
            System.out.println(response.readEntity(String.class));
            response.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}