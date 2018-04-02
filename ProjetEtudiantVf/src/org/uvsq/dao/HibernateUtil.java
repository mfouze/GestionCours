package org.uvsq.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	public HibernateUtil(){
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	private static final SessionFactory sessionFactory;
	static {
		try
		{
			AnnotationConfiguration confg = new AnnotationConfiguration();
			confg.configure("hibernate.cfg.xml");
			sessionFactory = confg.buildSessionFactory();
		}
		catch(Throwable ex)
		{
			System.err.println((new StringBuilder("Initial SessionFactory creation failed.")).append(ex).toString());
			throw new ExceptionInInitializerError(ex);
		}
	}
}

