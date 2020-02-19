package eu.ensup.demojpaweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eu.ensup.demojpaweb.domaine.Formation;

public class FormationDao implements IFormationDao {
	EntityManagerFactory emf;
	EntityManager em;

	@Override
	public boolean createFormation(Formation formation) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpaweb-pu");
		EntityManager em = emf.createEntityManager();

		// 2 : Ouverture transaction
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(formation);
			tx.commit();
			em.close();
			emf.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
			return false;
		}
	}

}
