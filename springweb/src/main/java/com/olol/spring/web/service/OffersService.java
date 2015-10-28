package com.olol.spring.web.service;


import com.olol.spring.web.dao.Offer;
import com.olol.spring.web.dao.OffersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author boaztu
 */
@Service("offersService")
public class OffersService {

    private OffersDao offersDao;

    @Autowired
    public void setOffersDao(final OffersDao offersDao) {
        this.offersDao = offersDao;
    }

    public List<Offer> getCurrent() {
        return offersDao.getOffers();
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    public void create(Offer offer) {
        offersDao.create(offer);
    }

}
