package org.uvsq.dao;

import java.util.Iterator;
import java.util.List;


import org.hibernate.*;
import org.uvsq.daoFactory.DAO;
import org.uvsq.entities.Enseignant;
import org.uvsq.entities.Etudiant;

public class EtudiantDao extends DAO<Etudiant> {


	public EtudiantDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Etudiant create(Etudiant obj) {
		session.save(obj);
		session.flush();
		tx.commit();
		return obj;
	}

	@Override
	public boolean update(Etudiant obj) {
		session.saveOrUpdate(obj);
		session.flush();
		tx.commit();
		return true;
	}

	public List<Etudiant> getEtudiants() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = (Query) session.createQuery("FROM Etudiant");
			List<Etudiant> lstEtudiants = query.list();
			transaction.commit();
			return lstEtudiants;
		} catch (Exception e) {
			if (!(transaction == null)) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean delete(Etudiant obj) {
		session.delete(obj);
		session.flush();
		tx.commit();
		return true;
	}

	public boolean deleteById(int id)
	{
		Etudiant etudiant = (Etudiant)session.get(Etudiant.class, Integer.valueOf(id));
		if(etudiant != null)
		{
			session.delete(etudiant);
			session.flush();
			tx.commit();
			return true;
		} else
		{
			return false;
		}
	}

	public boolean deleteAll(){
		Etudiant etudiant;
		for(Iterator iterator = list().iterator(); iterator.hasNext(); delete(etudiant))
			etudiant = (Etudiant)iterator.next();

		return true;
	}

	public List list(){
		List list = session.createCriteria(Etudiant.class).list();
		return list;
	}
		@Override
		public Etudiant find(Long id) {
			// TODO Auto-generated method stub
			Etudiant etudiant = null;

			try {
				session = HibernateUtil.getSessionFactory().openSession();
				etudiant =  (Etudiant) session.load(Etudiant.class, id);
				Hibernate.initialize(etudiant);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			return etudiant;
		}
		
		
		public Etudiant getEtudiantByUsername(String username) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				System.out.println("ligne 1");
				Query query = (Query) session.createQuery("FROM Etudiant a where a.username=:username");
				System.out.println("ligne 2");

				query.setParameter("username", username);
				System.out.println("ligne 3");
				Etudiant results = (Etudiant) query.uniqueResult();
				System.out.println("ligne 4");
				//System.out.println(lstEtudiants);
				transaction.commit();
				return results;
				} catch (Exception e) {
				if (!(transaction == null)) {
					transaction.rollback();
				}
			} finally {
				session.close();
			}
			return null;
		}

}
