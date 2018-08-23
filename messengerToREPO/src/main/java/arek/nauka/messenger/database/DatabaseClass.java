package arek.nauka.messenger.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import arek.nauka.messenger.model.Message;

public class DatabaseClass
{
	SessionFactory sessionFactory = null;
	Session session = null;
	
	public DatabaseClass()
	{
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public List<Message> getAllMessages()
	{
		List<Message> messages = new ArrayList<Message>();

		try
		{
			session.beginTransaction();
			Query<Message> query = session.createQuery("From Message");

			messages = query.getResultList();
			session.getTransaction().commit();
			session.close();

		}
		catch (Throwable th)
		{
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}

		return messages;
	}
	
	
}
