package za.co.openset.dao;

import za.co.openset.resources.CdiTestRunner;
import za.co.openset.resources.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.openset.model.Organisation;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(CdiTestRunner.class)
public class OrganisationRepoTest {

    @Inject
    private RiskReviewTestUtils iManagerTestUtils;

    @Inject
    private OrganisationRepo organisationRepo;

    @Test
    @Transactional
    public void testCreateOrg() throws Exception {
        Organisation org = iManagerTestUtils.createOrganisation();
        Organisation savedOrg = organisationRepo.update(org);
        assertNotNull(savedOrg);
        assertNotNull(savedOrg.getOrganisationId());
    }

    @Test
    @Transactional
    public void testAddUserToOrg() throws Exception {

    }

    @Test
    @Transactional
    public void testAddAddressToOrg() throws Exception {

    }

    @Test
    @Transactional
    public void testAddWarehouseOrg() throws Exception {

    }

}