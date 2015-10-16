package za.co.openset.dao;

import za.co.openset.model.ContactDetails;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class ContactDetailsRepo extends AbstractJPARepository<ContactDetails> {
    @Inject
    private EntityManager entityManager;

    public ContactDetailsRepo(){
        super(ContactDetails.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
