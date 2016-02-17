package za.co.openset.dao.risk;

import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.openset.model.risk.RiskImpact;
import za.co.openset.resources.CdiTestRunner;
import za.co.openset.resources.Transactional;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(CdiTestRunner.class)
public class RiskImpactRepoTest {

    @Inject
    private RiskImpactRepo riskImpactRepo;

    @Inject
    private RiskReviewTestUtils iManagerTestUtils;

    @Test
    @Transactional
    public void testAddNewRiskImpact() throws Exception {
        RiskImpact ri = iManagerTestUtils.createRiskImpact();

        ri = riskImpactRepo.create(ri);
        assertNotNull(ri);
        assertNotNull(ri.getRiskImpactId());
    }

    @Test
    @Transactional
    public void testDeleteNewRiskImpact() throws Exception {
        RiskImpact ri = iManagerTestUtils.createRiskImpact();

        ri = riskImpactRepo.create(ri);
        assertNotNull(ri);
        assertNotNull(ri.getRiskImpactId());
        String desc = ri.getDescription();
        // Get saved impact
        ri = riskImpactRepo.findById(ri.getRiskImpactId());
        assertNotNull(ri);
        assertNotNull(ri.getRiskImpactId());
        assertEquals(ri.getDescription(), desc);
    }

}