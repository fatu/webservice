package com.cave.prog.spring.test;

import com.cave.prog.spring.test.autowiring.Logger;
import com.cave.prog.spring.test.autowiring.Offer;
import com.cave.prog.spring.test.autowiring.OffersDAO;
import com.cave.prog.spring.test.autowiring.Robot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        OffersDAO offersDAO = (OffersDAO) context.getBean("offersDao");

        Offer updateOffer = new Offer(7, "Claire", "claire@test.com", "Web design to fit any project.");
        if (offersDAO.update(updateOffer)) {
            System.out.println("Object update.");
        } else {
            System.out.println("Cannot update Object.");
        }

        try {

//            Offer offer1 = new Offer("Dave", "dave@test.com", "Coding Java");
//            Offer offer2 = new Offer("Karen", "karen@catest.com", "Software testing");
//
//            if (offersDAO.create(offer1)) System.out.println("Created offer object.");
//            if (offersDAO.create(offer2)) System.out.println("Created offer object.");

            List<Offer> offers = new ArrayList<Offer>();

            offers.add(new Offer(4, "Dave", "dave@caveof", "Cash for software."));
            offers.add(new Offer(2, "Karen", "karen@caveof", "Elegant web design."));

            int[] rvals = offersDAO.create(offers);

            for (int value : rvals) {
                System.out.println("Updated " + value + " rows.");
            }


            offersDAO.delete(88);

            List<Offer> allOffers = offersDAO.getOffers();

            for (Offer offer : allOffers) {
                System.out.println(offer);
            }

            Offer offer = offersDAO.getOffers(2);

            System.out.println("Should be Mike: " + offer);
        } catch (CannotGetJdbcConnectionException ex) {
            System.out.println("Can not get database connection.");
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        ((ClassPathXmlApplicationContext) context).close();
    }

}
