package com.redrisegames.reigninwildWeb.services;

import java.util.ArrayList;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.redrisegames.reigninwildWeb.dao.IUsersDao;
import com.redrisegames.reigninwildWeb.orm.Users;


@Service("UsersService")
@Transactional(readOnly = false)
public class UsersService implements IUsersService,UserDetailsService  {

    @Autowired
    private IUsersDao usersDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveUser(Users user) {
        
        usersDao.save(user);
       
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteUser(Users user) {
        usersDao.delete(user);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateUser(Users user) {
        usersDao.update(user);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }


    public UserDetails loadUserByUsername(final String username) 
            throws UsernameNotFoundException {
     Users user = usersDao.getUserbyName(username);
     
     GrantedAuthority authorities = buildUserAuthority(user.getUserGroup());

     return buildUserForAuthentication(user, authorities);


 }
 
    // Converts Users user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(Users user, 
       GrantedAuthority authority) {
        
        List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
        authorities.add(authority);
        
        User newuser = new User(user.getUsername(),user.getPassword(),true,true,true,true,authorities);
        
        
        return newuser;
    }
 
    @SuppressWarnings("deprecation")
    private GrantedAuthority buildUserAuthority(String userRole) {
 
        SimpleGrantedAuthority  setAuths = new SimpleGrantedAuthority (userRole);
 
        return setAuths;
    }



    public Users getUserbyName(String name) {
        // TODO Auto-generated method stub
        return usersDao.getUserbyName(name);
    }

}
