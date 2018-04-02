package org.uvsq.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.uvsq.daoFactory.DAO;
import org.uvsq.entities.Cours;
import org.uvsq.entities.Filiere;
import org.uvsq.entities.Filiere;

public class FiliereDao extends DAO<Filiere>  {

	@Override
	public Filiere create(Filiere obj) {
		try {
			session.saveOrUpdate(obj);
			session.flush();
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Error----------->"+e.getMessage());
		}
		return obj;
	}

	@Override
	public boolean update(Filiere obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Filiere obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Filiere find(Long id) {
		Filiere filiere = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			filiere =  (Filiere) session.load(Filiere.class, id);
			Hibernate.initialize(filiere);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return filiere;
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Cours> getListCoursParFiliere(){
		try {
			session.getSessionFactory().openSession();
			tx.begin();
			List<Cours> results;
			System.out.println("ligne 1");
			Query query = (Query) session.createQuery("FROM Cours as cours, Filiere as filiere INNER JOIN filiere.filiere INNER JOIN cours.filiere_id");
			System.out.println("ligne 2");
			results =  query.list();
			System.out.println("ligne 4");
			return  results;
			} catch (Exception e) {
			if (!(tx == null)) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return null;

	}
}
