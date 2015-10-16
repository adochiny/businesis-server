package za.co.openset.dao.user;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.user.UserRole;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/05.
 */
public class UserRoleRepo extends AbstractJPARepository<UserRole> {
    @Inject
    private EntityManager entityManager;

    public UserRoleRepo(){
        super(UserRole.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
