package za.co.openset.dao;

import za.co.openset.resources.CdiTestRunner;
import za.co.openset.resources.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import za.co.openset.model.Asset;
import za.co.openset.model.AssetWarehouse;
import za.co.openset.utils.RiskReviewTestUtils;

import javax.inject.Inject;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(CdiTestRunner.class)
public class AssetWarehouseRepoTest {

    @Inject
    private RiskReviewTestUtils iManagerTestUtils;

    @Inject
    private AssetRepo assetRepo;

    @Inject
    private AssetWarehouseRepo assetWarehouseRepo;

    @Test
    @Transactional
    public void testGetAssetWarehouses() throws Exception {

        Asset asset = iManagerTestUtils.createAsset();
        Asset savedAsset = assetRepo.create(asset);
        assertNotNull(savedAsset);
        assertNotNull(savedAsset.getAssetId());

        savedAsset.setWarehouse(iManagerTestUtils.createWarehouse());
        savedAsset = assetRepo.update(asset);
        AssetWarehouse assetWarehouse1 = iManagerTestUtils.createAssetWarehouse(savedAsset);
        assetWarehouse1.setWarehouse(savedAsset.getWarehouse());
        assetWarehouseRepo.update(assetWarehouse1);

        // second one
        savedAsset.setWarehouse(iManagerTestUtils.createWarehouse());
        savedAsset = assetRepo.update(asset);
        AssetWarehouse assetWarehouse2 = iManagerTestUtils.createAssetWarehouse(savedAsset);
        assetWarehouse2.setWarehouse(savedAsset.getWarehouse());
        assetWarehouseRepo.update(assetWarehouse2);

        // third one.
        savedAsset.setWarehouse(iManagerTestUtils.createWarehouse());
        savedAsset = assetRepo.update(asset);
        AssetWarehouse assetWarehouse3 = iManagerTestUtils.createAssetWarehouse(savedAsset);
        assetWarehouse3.setWarehouse(savedAsset.getWarehouse());
        assetWarehouseRepo.update(assetWarehouse3);

        // check if the warehouses were set.
        List<AssetWarehouse> assetWarehouses = assetWarehouseRepo.getAssetWarehouses(savedAsset.getAssetId());
        assertNotNull(assetWarehouses);
        assertTrue(assetWarehouses.size() == 3);

        for (AssetWarehouse assetWarehouse : assetWarehouses) {
            assertNotNull(assetWarehouse);
            assertNotNull(assetWarehouse.getAssetWarehouseId());
            assertNotNull(assetWarehouse.getWarehouse());
            assertNotNull(assetWarehouse.getWarehouse().getWarehouseId());
            System.out.println(assetWarehouse);
        }

    }
}