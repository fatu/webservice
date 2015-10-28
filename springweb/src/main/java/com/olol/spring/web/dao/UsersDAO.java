package com.olol.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author fatu
 */
@Component("usersDao")
public class UsersDao {

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsersDao() {
        System.out.println("Successfully loaded offers DAO");
    }

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    @Transactional
    public boolean create(User user) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("username", user.getUsername());
        params.addValue("password", passwordEncoder.encode(user.getPassword()));
        params.addValue("email", user.getEmail());
        params.addValue("enabled", user.isEnabled());
        params.addValue("authority", user.getAuthority());

        jdbc.update("insert into users (username, password, email, enabled) values (:username, :password, :email, " +
                ":enabled)", params);

        return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
    }

    public boolean exists(final String username) {
        return jdbc.queryForObject("select count(*) from users where username=:username", new MapSqlParameterSource
                ("username", username), Integer.class) > 0;
    }

//    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return jdbc.query("select * from users, authorities where users.username = authorities.username",
                BeanPropertyRowMapper.newInstance(User.class));
    }
}
