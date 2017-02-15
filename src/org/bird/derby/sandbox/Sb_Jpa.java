/**
 * bird-derby-01
 * org.bird.derby.sandbox
 * Sb_Jpa.java
 *
 * Date : 13 Feb 2017 
 * Git : 
 * 
 * Author : a49974
 */
package org.bird.derby.sandbox;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bird.db.entity.Author;
import org.bird.db.entity.System;

/**
 * @author a49974
 *
 */
public class Sb_Jpa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bird");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Author sys = new Author();
		sys.setFirstname("Serge");
		sys.setLastname("Moers");
		sys.setComment("mmmmm");
		em.persist(sys);
		em.flush();
		em.getTransaction().commit();
		em.close();
		
		
	}

}
