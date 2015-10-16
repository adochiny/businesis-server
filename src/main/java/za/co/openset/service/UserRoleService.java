package za.co.openset.service;

import za.co.openset.dao.user.UserRoleRepo;
import za.co.openset.model.user.UserRole;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by adonis on 2015/06/07.
 */
@Stateless
public class UserRoleService {
    @Inject
    private UserRoleRepo userRoleRepo;

    public UserRole create(UserRole userRole) throws Exception {
        try {
            userRole = userRoleRepo.create(userRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return userRole;
    }

    public UserRole getUserRoleById(Long id) throws Exception {
        return userRoleRepo.findById(id);
    }

    public List<UserRole> getAllUserRoles() throws Exception {
        return userRoleRepo.findAll();
    }

}
