package za.co.openset.model.user;

import za.co.openset.model.BasePo;
import za.co.openset.model.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adonis on 2015/06/03.
 */
@Entity
@Table(name="user_role",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class UserRole extends BasePo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_role_seq")
    @SequenceGenerator(name = "user_role_seq", sequenceName = "user_role_seq")
    @Column(name = "user_role_id")
    private Long roleId;

    @Column(name = "name", length = 100, nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 115)
    private String description;

    /*@ManyToMany(mappedBy="userRoleList", cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<User> userList = new ArrayList<>();*/

    @OneToMany(mappedBy="userRole",targetEntity=User.class,
            cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
    private List<User> userList = new ArrayList<>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
