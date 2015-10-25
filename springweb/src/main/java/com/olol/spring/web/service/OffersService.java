package com.olol.spring.web.service;


import com.olol.spring.web.dao.Offer;
import com.olol.spring.web.dao.OffersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boaztu
 */
@Service("offersService")
public class OffersService {

    private OffersDAO offersDAO;

    @Autowired
    public void setOffersDAO(final OffersDAO offersDAO) {
        this.offersDAO = offersDAO;
    }

    public List<Offer> getCurrent() {
        return offersDAO.getOffers();
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    public void create(Offer offer) {
        offersDAO.create(offer);
    }

}
