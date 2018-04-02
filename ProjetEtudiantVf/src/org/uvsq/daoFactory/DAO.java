package org.uvsq.daoFactory;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.uvsq.dao.*;

public abstract class DAO<T> {	

	public DAO()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		tx.begin();
	}
	
	  	public abstract T create(T obj);

	    public abstract boolean update(T obj);

	    public abstract boolean delete(T obj);

	    public abstract boolean deleteById(int id);

	    public abstract boolean deleteAll();

	    public abstract T find(Long id);

	    public abstract List list();
	
	public void deconnecter()
	{
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
	}

	protected Session session;
	protected Transaction tx;
}

