package com.redrisegames.reigninwildWeb.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.redrisegames.reigninwildWeb.orm.Users;

@Transactional
public class UsersDao implements IUsersDao {

    @Autowired
    private HibernateTemplate  hibernateTemplate;
    
    public void save(Users users) {
        hibernateTemplate.save(users);
    }

    /**
     * @see com.exadel.dao.IUsersDao#delete(com.exadel.orm.Users)
     */
    public void delete(Users users) {
        hibernateTemplate.delete(users);
    }

    /**
     * @see com.exadel.dao.IUsersDao#update(com.exadel.orm.Users)
     */
    public void update(Users users) {
        hibernateTemplate.update(users);
    }

    /**
     * @see com.exadel.dao.IUsersDao#getAllUsers()
     */
    @SuppressWarnings("unchecked")
    public List<Users> getAllUsers() {
        List<Users> users = (List<Users>) hibernateTemplate.find("from Users");
        return users;
    }

    /**
     * @see com.exadel.dao.IUsersDao#getUserbyName(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public Users getUserbyName(String name) {
        List<Users> usrlist = (List<Users>) hibernateTemplate.find(
                "from Users u where u.username = '" + name + "'");
        return usrlist.get(0);
    }

    /**
     * @see com.exadel.dao.IUsersDao#changePassword(com.exadel.orm.Users, java.lang.String)
     */
    public void changePassword(Users user, String password) {
        user.setPassword(password);
        hibernateTemplate.update(user);

    }

    /**
     * @see com.exadel.dao.IUsersDao#changeGroup(com.exadel.orm.Users, java.lang.String)
     */
    public void changeGroup(Users user, String group) {
        user.setUserGroup(group);
        hibernateTemplate.update(user);
    }

    /**
     * @see com.exadel.dao.IUsersDao#searchUser(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Users> searchUser(String name) {
        List<Users> usrlist = (List<Users>) hibernateTemplate.find(
                "from Users u where u.username LIKE '%" + name + "%'");
        return usrlist;

    }
}