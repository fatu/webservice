package com.library.app.commontests.utils;

import javax.persistence.EntityManager;

/**
 * @author boaztu
 */
public class DBCommandTransactionalExecutor {
    private EntityManager em;

    public DBCommandTransactionalExecutor(EntityManager em) {
        this.em = em;
    }

    public <T> T executeCommand(DBCommand<T> dbCommand) {
        try {
            em.getTransaction().begin();
            T toReturn = dbCommand.execute();
            em.getTransaction().commit();
            em.clear();
            return toReturn;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new IllegalStateException(e);
        }
    }
}
