package za.co.openset.dao.user;

import za.co.openset.dao.user.UserRoleRepo;
import za.co.openset.resources.CdiTestRunner;
import za.co.openset.resources.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.openset.model.user.UserRole;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(CdiTestRunner.class)
public class UserRoleRepoTest {
    @Inject
    private UserRoleRepo userRoleRepo;

    @Inject
    private RiskReviewTestUtils iManagerTestUtils;

    @Test
    @Transactional
    public void testCreateRole() throws Exception {
        UserRole role1 = iManagerTestUtils.createUserRole();
        iManagerTestUtils.setCommonFieldsCreate(role1, 101L);
        UserRole userRole = userRoleRepo.create(role1);
        assertNotNull(userRole);
        assertNotNull(userRole.getRoleId());
    }

    @Test
    @Transactional
    public void testSelectRoles() throws Exception {

    }

    @Test
    @Transactional
    public void testAddUserToRole() throws Exception {

    }

}