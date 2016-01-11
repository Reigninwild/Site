package com.redrisegames.reigninwildWeb.services;


import java.util.List;

import com.redrisegames.reigninwildWeb.orm.Users;


public interface IUsersService {
    /**
     * saves user in DB
     * @param users
     */
    public void saveUser(Users users);
    /**
     * deletes user from DB
     * @param users
     */
    public void deleteUser(Users users);
    /**
     * updates user in DB
     * @param users
     */
    public void updateUser(Users users);
    /**
     * @return all users in db
     */
    public List<Users> getAllUsers();
    /**
     * @param name
     * @return user by name
     */
    public Users getUserbyName(String name);
}
