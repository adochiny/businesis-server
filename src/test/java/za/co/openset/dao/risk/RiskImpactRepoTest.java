package za.co.openset.dao.risk;

import za.co.openset.dao.risk.RiskImpactRepo;
import za.co.openset.resources.CdiTestRunner;
import za.co.openset.resources.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.openset.model.risk.RiskImpact;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.inject.Inject;

import static org.junit.Assert.*;

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

}