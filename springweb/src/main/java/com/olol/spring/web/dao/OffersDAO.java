package com.olol.spring.web.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author fatu
 */
@Repository
@Component("offersDao")
@Transactional
public class OffersDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session session() {
        return sessionFactory.getCurrentSession();
    }

    public OffersDao() {
        System.out.println("Successfully loaded offers DAO");
    }

    @SuppressWarnings("unchecked")
    public List<Offer> getOffers() {
        Criteria crit = session().createCriteria(Offer.class);
        crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
        return crit.list();
    }

    @SuppressWarnings("unchecked")
    public List<Offer> getOffers(String username) {

        Criteria crit = session().createCriteria(Offer.class);

        crit.createAlias("user", "u");

        crit.add(Restrictions.eq("u.enabled", true));
        crit.add(Restrictions.eq("u.username", username));

        return crit.list();
    }

    public boolean delete(int id) {
        Query query = session().createQuery("delete from Offer where id=:id");
        query.setLong("id", id);
        return query.executeUpdate() == 1;
    }

    public void saveOrUpdate(Offer offer) {
        session().saveOrUpdate(offer);
    }

    public Offer getOffer(int id) {

        Criteria crit = session().createCriteria(Offer.class);

        crit.createAlias("user", "u");

        crit.add(Restrictions.eq("u.enabled", true));
        crit.add(Restrictions.idEq(id));

        return (Offer) crit.uniqueResult();
    }
}
