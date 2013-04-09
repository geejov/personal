package com.personal.policy.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAO {
	
	public static void saveObject ( Object o ) {
		EntityManager em = EMF.get().createEntityManager();
		EntityTransaction txn = em.getTransaction();
		
		try {
			txn.begin();
			em.persist(o);
			em.flush();
			txn.commit();
		}
		catch(Exception e) {
			txn.rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}

}
