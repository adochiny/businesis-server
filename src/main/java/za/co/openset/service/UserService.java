package za.co.openset.service;

import za.co.openset.dao.user.UserRepo;
import za.co.openset.dao.user.UserRoleRepo;
import za.co.openset.model.user.User;
import za.co.openset.model.user.UserRole;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by adonis on 2015/06/07.
 *
 */
@Stateless
public class UserService {
    @Inject
    private UserRepo userRepo;

    @Inject
    private UserRoleRepo userRoleRepo;

    public User create(User user) throws Exception {
       return userRepo.create(user);
    }

    public User update(User user) throws Exception {
        return userRepo.update(user);
    }

    public User getUserById(Long id) throws Exception {
        return userRepo.findById(id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public User getCompanyUserById(Long companyId) throws Exception {
        List<User> parentById = userRepo.findByFieldName("parentId", companyId);
        // take the first one
        if (parentById != null && parentById.size() > 0) {
          return (User)parentById.toArray()[0];
        }
        throw new Exception("User not found");
    }

    public User getUserByField(Map map) throws Exception {
        return userRepo.findEntityByFieldName(map);
    }

    public User login(Map map, String password) throws Exception {
        User user = userRepo.findEntityByFieldName(map);
        if (user == null || !password.equals(user.getPassword())) {
            throw new Exception("Could not login user, password is wrong.");
        }
        return user;
    }

    public List<User> getAllUsers() throws Exception {
        return userRepo.findAll();
    }

    public List<UserRole> getAllUserRoles() throws Exception {
        return userRoleRepo.findAll();
    }

}
