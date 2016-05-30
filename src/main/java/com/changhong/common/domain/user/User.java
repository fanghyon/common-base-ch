package com.changhong.common.domain.user;

import com.changhong.common.domain.EntityBase;
//import com.changhong.system.domain.qiandao.QianDaoPlace;
//import com.changhong.system.domain.qiandao.QianDaoTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 15-8-7
 * Time: 下午1:43
 */
public class User extends EntityBase implements UserDetails {

    public static final String NAME = "u_name";
    public static final String NUMBER = "u_number";
    public static final String MOBILE = "u_mobile";
    public static final String PASSWORD = "u_password";
    public static final String EMAIL = "u_email";
    public static final String ADRESS = "u_address";
    public static final String AVATAR = "u_avatar_filepath";
    public static final String BIRTHDAY = "u_birthday";
    public static final String ENABLED = "enabled";
    public static final String DEPARTMENT_ID = "department_id";

    private String name;
    private String number;
    private String mobile;
    private String password;
    private String email;
    private String address;
    private String birthday;
    private boolean enabled = true;

    //淇敼瀵嗙爜
    private String activeCode;

    //閮ㄩ棬鍜岃亴浣�    private Department department;
    private Position position;

    //棰嗗
    private User leader;
    private List<User> members;

    //绛惧埌鏃堕棿鍜屽湴鐐�    private QianDaoPlace qianDaoPlace;
//    private QianDaoTime qianDaoTime;

    //鏉冮檺
    private List<Role> roles = new ArrayList<Role>();

    public User() {
    }

    public User(String name, String number, String mobile, String email, String address, String birthday) {
        this.name = name;
        this.number = number;
        this.mobile = mobile;
        this.password = "123456";
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.enabled = true;
    }

    public void grantRole(String role) {
        if (roles == null) {
            roles = new ArrayList<Role>();
        }
        Role grantRole = new Role(role);
        roles.add(grantRole);
    }

    /*************************************************GETTER**********************************************************/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

//    public QianDaoPlace getQianDaoPlace() {
//        return qianDaoPlace;
//    }
//
//    public void setQianDaoPlace(QianDaoPlace qianDaoPlace) {
//        this.qianDaoPlace = qianDaoPlace;
//    }
//
//    public QianDaoTime getQianDaoTime() {
//        return qianDaoTime;
//    }
//
//    public void setQianDaoTime(QianDaoTime qianDaoTime) {
//        this.qianDaoTime = qianDaoTime;
//    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /****************************************************SECURITY**********************************************/

    public String getUsername() {
        return mobile;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            grantedAuthorities.add(role);
        }
        return grantedAuthorities;
    }
}
