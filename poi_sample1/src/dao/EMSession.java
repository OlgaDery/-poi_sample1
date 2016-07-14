package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EMSession {

    private static final ThreadLocal<EntityManager> context = new ThreadLocal<EntityManager>();
    private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("inventory");
	private static final Logger LOG = LoggerFactory.getLogger(EMSession.class);
    
    /**
     * 
     * @return
     */
    public static EntityManager getEntityManager() {
    	if (context.get() == null) {
            context.set(emFactory.createEntityManager());
            context.get().getTransaction().begin();
    	}

        return context.get();
    }

    /**
     * 
     */
    public static void end()
    throws PersistenceException {
    	
    	if (context.get() != null) {
            try {
            	final EntityTransaction transaction = context.get().getTransaction();
            	
                if (transaction.isActive()) {
                    if (transaction.getRollbackOnly()) {
                    	LOG.info("Transaction Rolled Back!");

                        transaction.rollback();
                    } else {
                    	LOG.info("Transaction Committed");
                        transaction.commit();
                    }
                }
            } finally {
            	context.get().close();
                context.remove();
            }
    	}
    	
    }
}
