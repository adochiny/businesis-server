package za.co.openset.service.businesis;

import za.co.openset.dao.AddressRepo;
import za.co.openset.dao.businesis.CompanyBusinessRepo;
import za.co.openset.model.Address;
import za.co.openset.model.businesis.CompanyBusiness;
import za.co.openset.utils.AManagerUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by adonis on 2015/06/28.
 *
 */

@Stateless
public class BusinesisService {

    @Inject
    private CompanyBusinessRepo companyBusinessRepo;

    @Inject
    private AddressRepo addressRepo;

    @Inject
    private AManagerUtils aManagerUtils;

    // CompanyBusiness functions
    public CompanyBusiness update(CompanyBusiness companyBusiness) throws Exception {

        if (companyBusiness.getCompanyBusinessId() != null) {
            aManagerUtils.setCommonFieldsUpdate(companyBusiness, AManagerUtils.CREATED_BY);
        } else {
            aManagerUtils.setCommonFieldsCreate(companyBusiness, AManagerUtils.CREATED_BY);
        }

        if (companyBusiness.getContactDetails() != null) {
            if (companyBusiness.getContactDetails().getContactDetailsId() != null) {
                aManagerUtils.setCommonFieldsUpdate(companyBusiness.getContactDetails(), AManagerUtils.CREATED_BY);
            } else {
                aManagerUtils.setCommonFieldsCreate(companyBusiness.getContactDetails(), AManagerUtils.CREATED_BY);
            }
        }

        if (companyBusiness.getAddresses() != null) {
            for (Address address : companyBusiness.getAddresses()) {
                if (address.getAddressId() != null) {
                    aManagerUtils.setCommonFieldsUpdate(address, AManagerUtils.CREATED_BY);
                } else {
                    aManagerUtils.setCommonFieldsCreate(address, AManagerUtils.CREATED_BY);
                }
            }

        }

        CompanyBusiness updated = companyBusinessRepo.update(companyBusiness);

        if (companyBusiness.getAddresses() != null && companyBusiness.getAddresses().size() > 0) {
            // save all the addresses.
            for (Address address : companyBusiness.getAddresses()) {
                address.setParentId(updated.getCompanyBusinessId());
                updated.getAddresses().add(addressRepo.update(address));
            }
        }

        return updated;
    }

    public CompanyBusiness getCompanyBusinessById(Long id) throws Exception {
        CompanyBusiness byId = companyBusinessRepo.findById(id);
        byId.setAddresses(addressRepo.findByParent(byId.getCompanyBusinessId()));
        return byId;
    }

    public List<CompanyBusiness> getAllCompanyBusiness() throws Exception {
        List<CompanyBusiness> all = companyBusinessRepo.findAll();
        for (CompanyBusiness companyBusiness : all) {
            // add addresses for each.
            companyBusiness.setAddresses(addressRepo.findByParent(companyBusiness.getCompanyBusinessId()));
        }
        return all;
    }



}
