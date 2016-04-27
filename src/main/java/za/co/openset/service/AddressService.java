package za.co.openset.service;

import za.co.openset.dao.AddressRepo;
import za.co.openset.model.Address;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by adonis on 2015/06/07.
 */
@Stateless
public class AddressService {
    @Inject
    private AddressRepo addressRepo;

    public Address create(Address address) throws Exception {
       return addressRepo.create(address);
    }

}
