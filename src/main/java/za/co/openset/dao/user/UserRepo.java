package za.co.openset.dao.user;

import za.co.openset.dao.AbstractJPARepository;
import za.co.openset.model.user.User;
import za.co.openset.model.user.UserRole;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by adonis on 2015/06/02.
 */
public class UserRepo extends AbstractJPARepository<User> {
    @Inject
    private EntityManager entityManager;

    public UserRepo(){
        super(User.class);
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public User addRoleToUser(User user, UserRole userRole) throws Exception {
       user.setUserRole(userRole);
       return update(user);
    }

    public Long createUserToRole(UserRole userRole, User user) throws Exception {
        entityManager.persist(userRole);
        entityManager.persist(user);
        // UserRoleAssociation association = new UserRoleAssociation();
        // association.setRoleId(userRole.getRoleId());
        // association.setUserRole(userRole);
        // association.setUserId(user.getUserId());
        // association.setUser(user);

        // List<UserRole> list = new ArrayList<UserRole>();
        // list.add(userRole);
        user.setUserRole(userRole);
        // Also add the association object to the employee.

        update(user);

        return user.getUserId();
    }

}
