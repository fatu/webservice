package com.olol.spring.web.service;


import com.olol.spring.web.dao.User;
import com.olol.spring.web.dao.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boaztu
 */
@Service("usersService")
public class UsersService {

    private UsersDAO usersDAO;

    @Autowired
    public void setUsersDAO(final UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public void create(User user) {
        usersDAO.create(user);
    }

    public boolean exists(final String username) {
        return usersDAO.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return usersDAO.getAllUsers();
    }
}
