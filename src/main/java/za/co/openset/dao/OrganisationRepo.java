package za.co.openset.dao;

import za.co.openset.model.Organisation;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class OrganisationRepo extends AbstractJPARepository<Organisation> {
    @Inject
    private EntityManager entityManager;

    public OrganisationRepo(){
        super(Organisation.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
