package com.olol.spring.web.service;


import com.olol.spring.web.dao.Message;
import com.olol.spring.web.dao.MessagesDao;
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

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private MessagesDao messagesDao;

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

    public void sendMessage(Message message) {
        messagesDao.saveOrUpdate(message);
    }

    public User getUser(String username) {
        return usersDao.getUser(username);
    }
}
