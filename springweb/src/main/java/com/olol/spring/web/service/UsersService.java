package com.olol.spring.web.service;


import com.olol.spring.web.dao.User;
import com.olol.spring.web.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boaztu
 */
@Service("usersService")
public class UsersService {

    private UsersDao usersDao;

    @Autowired
    public void setUsersDao(final UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void create(User user) {
        usersDao.create(user);
    }

    public boolean exists(final String username) {
        return usersDao.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }
}
