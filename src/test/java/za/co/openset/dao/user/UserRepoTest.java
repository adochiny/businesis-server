package za.co.openset.dao.user;

import za.co.openset.dao.user.UserRepo;
import za.co.openset.dao.user.UserRoleRepo;
import za.co.openset.resources.CdiTestRunner;
import za.co.openset.resources.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.openset.model.Address;
import za.co.openset.model.ContactDetails;
import za.co.openset.model.user.User;
import za.co.openset.model.user.UserRole;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(CdiTestRunner.class)
public class UserRepoTest {

    @Inject
    private UserRepo userRepo;

    @Inject
    private UserRoleRepo userRoleRepo;

    @Inject
    private RiskReviewTestUtils iManagerTestUtils;

    @Test
    @Transactional
    public void testAddRoleToUser() throws Exception {
        User user = iManagerTestUtils.createUser();
        UserRole role1 = iManagerTestUtils.createUserRole();
        // role1 = userRoleRepo.create(role1);
        // role2 = userRoleRepo.create(role2);

        user = userRepo.addRoleToUser(user, role1);
        assertNotNull(user);
        UserRole userRole = user.getUserRole();
        assertNotNull(userRole);
        // assertTrue(userRoleList.size() == 2);
        // UserRole userRole = userRoleList.get(0);
        assertNotNull(userRole.getRoleId());

    }
    @Test
    @Transactional
    public void testAddAddressToUser() throws Exception {
        User user = iManagerTestUtils.createUser();
        Address address = iManagerTestUtils.createAddress();
        user.setAddress(address);

        User user1 = userRepo.create(user);
        assertNotNull(user1);
        Address address1 = user1.getAddress();
        assertNotNull(address1);
        assertEquals(address1.getAddressType(), address.getAddressType());
        assertEquals(address1.getComplexName(), address.getComplexName());
        assertEquals(address1.getStreetName(), address.getStreetName());
        assertEquals(address1.getTownCity(), address.getTownCity());
        assertEquals(address1.getProvince(), address.getProvince());
        assertEquals(address1.getCountry(), address.getCountry());

    }

    @Test
    @Transactional
    public void testAddContactsToUser() throws Exception {
        User user = iManagerTestUtils.createUser();
        ContactDetails cd = iManagerTestUtils.createContactDetails();
        user.setContactDetails(cd);

        User user1 = userRepo.create(user);
        assertNotNull(user1);
        ContactDetails cdetails = user1.getContactDetails();
        assertNotNull(cdetails);
        assertEquals(cdetails.getCellNumber(), cd.getCellNumber());
        assertEquals(cdetails.getEmail(), cd.getEmail());
        assertEquals(cdetails.getHomeNumber(), cd.getHomeNumber());
    }



}