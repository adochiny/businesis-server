package za.co.openset.service;

import za.co.openset.dao.*;
import za.co.openset.dto.AssetSearchDto;
import za.co.openset.model.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by adonis on 2015/06/28.
 */

@Stateless
public class GeneralService {

    @Inject
    private OrganisationRepo organisationRepo;

    @Inject
    private WarehouseRepo warehouseRepo;

    @Inject
    private AssetWarehouseRepo assetWarehouseRepo;

    // functions
    public  Organisation update( Organisation po) throws Exception {
        return organisationRepo.update(po);
    }
    public Organisation getOrganisationById(Long id) throws Exception {
        return organisationRepo.findById(id);
    }
    public List< Organisation> getAllOrganisations() throws Exception {
        return organisationRepo.findAll();
    }

    // functions warehouse
    public  Warehouse update(Warehouse po) throws Exception {
        return warehouseRepo.update(po);
    }
    public Warehouse getWarehouseById(Long id) throws Exception {
        return warehouseRepo.findById(id);
    }
    public List<Warehouse> getAllWarehouses() throws Exception {
        return warehouseRepo.findAll();
    }

    public AssetWarehouse update(AssetWarehouse po) throws Exception {
        return assetWarehouseRepo.update(po);
    }
}
