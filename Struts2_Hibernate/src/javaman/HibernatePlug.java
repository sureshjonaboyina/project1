package javaman;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernatePlug {
	private static SessionFactory factory=getSessionFactory();

	public static synchronized SessionFactory getSessionFactory() 
	{
		try
		{
		Configuration cfg=new Configuration();
		cfg.configure();
		
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		System.out.println(".....factory object is created....");
		
		return sessionFactory;
		
		
	}catch(Throwable ex)
	{
	System.err.println("Intial Session Factory Failed"+ex);
	throw new ExceptionInInitializerError(ex);
	}
	}
	
	public static SessionFactory getFactory()
	{
		return factory;
	}

}
