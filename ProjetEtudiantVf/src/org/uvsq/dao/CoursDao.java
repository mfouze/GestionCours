package org.uvsq.dao;

import java.util.Iterator;
import java.util.List;
import org.uvsq.daoFactory.DAO;
import org.uvsq.entities.Cours;
import org.hibernate.Hibernate;

public class CoursDao extends DAO<Cours>{


	public CoursDao() {
		super();

		// TODO Auto-generated constructor stub
	}

	@Override
	public Cours create(Cours obj) {
		// TODO Auto-generated method stub
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
	public boolean update(Cours obj) {
		session.saveOrUpdate(obj);
		session.flush();
		tx.commit();
		return true;
	}

	@Override
	public boolean delete(Cours obj) {
		session.delete(obj);
		session.flush();
		tx.commit();
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		Cours cours = (Cours) session.get(Cours.class,Integer.valueOf(id));
		if (cours != null) {
			session.delete(cours);
			session.flush();
			tx.commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteAll() {
		Cours c;
		for (Iterator iterator = list().iterator(); iterator.hasNext(); delete(c))
			c = (Cours) iterator.next();

		return true;
	}

	@Override
	public Cours find(Long id) {
		Cours cours = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			cours =  (Cours) session.load(Cours.class, id);
			Hibernate.initialize(cours);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return cours;
	}

	@Override
	public List list() {
		List list = session.createCriteria(Cours.class).list();
		return list;
	}


}
