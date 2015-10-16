package za.co.openset.dao;

import za.co.openset.resources.CdiTestRunner;
import za.co.openset.resources.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.openset.model.Warehouse;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(CdiTestRunner.class)
public class WarehouseRepoTest {
    @Inject
    private RiskReviewTestUtils iManagerTestUtils;

    @Inject
    private WarehouseRepo warehouseRepo;

    @Test
    @Transactional
    public void testWarehouse() throws Exception {
        Warehouse warehouse = iManagerTestUtils.createWarehouse();
        Warehouse savedW = warehouseRepo.update(warehouse);
        assertNotNull(savedW);
        assertNotNull(savedW.getWarehouseId());
    }

    @Test
    @Transactional
    public void testAddAssetToWarehouse() throws Exception {

    }

    @Test
    @Transactional
    public void testMoveAssetToAnotherWarehouse() throws Exception {

    }

}