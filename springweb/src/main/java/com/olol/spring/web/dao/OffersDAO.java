package com.olol.spring.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fatu
 */
@Component("offersDao")
public class OffersDao {

    private NamedParameterJdbcTemplate jdbc;

    public OffersDao() {
        System.out.println("Successfully loaded offers DAO");
    }

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    public List<Offer> getOffers() {

        return jdbc
                .query("select * from offers, users where offers.username=users.username and users.enabled=true",
                        new OfferRowMapper());
    }

    public List<Offer> getOffers(String username) {

        return jdbc
                .query("select * from offers, users where offers.username=users.username and users.enabled=true and offers.username=:username",
                        new MapSqlParameterSource("username", username), new OfferRowMapper());
    }

    public boolean update(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

        return jdbc.update("update offers set text=:text where id=:id", params) == 1;
    }

    public boolean delete(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);

        return jdbc.update("delete from offers where id = :id", params) == 1;
    }

    public boolean create(Offer offer) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

        return jdbc.update("insert into offers (username, text) values (:username, :text)", params) == 1;
    }

    @Transactional
    public int[] create(List<Offer> offers) {

        SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());

        return jdbc.batchUpdate("insert into offers (username, text) values (:username, :text)", params);
    }

    public Offer getOffer(int id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return (Offer) jdbc.queryForObject("select * from offers, users where offers.username=users.username and users.enabled=true and id=:id", params,
                new OfferRowMapper());
    }
}
