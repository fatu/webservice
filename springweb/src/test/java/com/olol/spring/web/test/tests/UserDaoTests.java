package com.olol.spring.web.test.tests;

import static org.junit.Assert.*;

import com.olol.spring.web.dao.User;
import com.olol.spring.web.dao.UsersDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author boaztu
 */
@ActiveProfiles("dev")
@ContextConfiguration(locations = {
        "classpath:config/dao-context.xml",
        "classpath:config/security-context.xml",
        "classpath:config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private DataSource dataSource;

    private User user1 = new User("johnwpurcell", "John Purcell", "hellothere",
            "john@caveofprogramming.com", true, "ROLE_USER");
    private User user2 = new User("richardhannay", "Richard Hannay", "the39steps",
            "richard@caveofprogramming.com", true, "ROLE_ADMIN");
    private User user3 = new User("suetheviolinist", "Sue Black", "iloveviolins",
            "sue@caveofprogramming.com", true, "ROLE_USER");
    private User user4 = new User("rogerblake", "Rog Blake", "liberator",
            "rog@caveofprogramming.com", false, "user");

    @Before
    public void init() {
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        jdbc.execute("delete from offers");

        jdbc.execute("delete from users");
    }

    @Test
    public void testCreateRetrieve() {
        usersDao.create(user1);

        List<User> users1 = usersDao.getAllUsers();

        assertEquals("One user should have been created and retrieved", 1, users1.size());

        assertEquals("Inserted user should match retrieved", user1, users1.get(0));

        usersDao.create(user2);
        usersDao.create(user3);
        usersDao.create(user4);

        List<User> users2 = usersDao.getAllUsers();
        assertEquals("Should be four retrieved users.", 4, users2.size());
    }

    @Test
    public void testExists() {
        usersDao.create(user2);
        usersDao.create(user3);
        usersDao.create(user4);
        assertTrue("User should exist,", usersDao.exists(user2.getUsername()));
        assertFalse("User should not exist.", usersDao.exists("xkjhsfjsdl"));

    }

    //TODO - Reimplement this
    @Test
    public void testUsers() {
        User user = new User("johnwpurcell", "John Purcell", "hellothere", "john@cave.com", true, "user");

        usersDao.create(user);

        List<User> users = usersDao.getAllUsers();

        assertEquals("Number of users should be 1.", 1, users.size());

        assertTrue("User should exist,", usersDao.exists(user.getUsername()));
        assertFalse("User should not exist.", usersDao.exists("xkjhsfjsdl"));

        assertEquals("Created user should be identical to retrieved user", user, users.get(0));
    }
}
