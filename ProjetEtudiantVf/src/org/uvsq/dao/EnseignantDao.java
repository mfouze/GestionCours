package org.uvsq.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.uvsq.daoFactory.DAO;
import org.uvsq.entities.Enseignant;

public class EnseignantDao extends DAO<Enseignant>{

	@Override
	public Enseignant create(Enseignant obj) {
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
	public boolean update(Enseignant obj) {
		session.saveOrUpdate(obj);
		session.flush();
		tx.commit();
		return true;
	}

	@Override
	public boolean delete(Enseignant obj) {
		session.delete(obj);
		session.flush();
		tx.commit();
		return true;
	}

	@Override
	public Enseignant find(Long id) {
		Enseignant ens = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			ens =  (Enseignant) session.load(Enseignant.class, id);
			Hibernate.initialize(ens);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return ens;
	}

	public boolean deleteById(int id)
	{
		Enseignant enseignant = (Enseignant)session.get(Enseignant.class, Integer.valueOf(id));
		if(enseignant != null)
		{
			session.delete(enseignant);
			session.flush();
			tx.commit();
			return true;
		} else
		{
			return false;
		}
	}

	public boolean deleteAll()
	{
		Enseignant enseignant;
		for(Iterator iterator = list().iterator(); iterator.hasNext(); delete(enseignant))
			enseignant = (Enseignant)iterator.next();

		return true;
	}


	public List list()
	{
		List list = session.createCriteria(Enseignant.class).list();
		return list;
	}


}
