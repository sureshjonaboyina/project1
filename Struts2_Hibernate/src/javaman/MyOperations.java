package javaman;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MyOperations {
	SessionFactory factory=HibernatePlug.getFactory();
	Session session=factory.openSession();
	
	Mybean p;
	List recList=null;
	
	public List retriveRecords()
	{
		recList=(List<Mybean>)session.createQuery("from MyBean b").list();
		System.out.println("got size"+recList.size());
		return recList;
	}
	
	public List retriveRecords(String val)
	{
		recList=(List<Mybean>)session.createQuery("from MyBean b where b.num="+val).list();
		System.out.println("got size"+recList.size());
		return recList;
	}
	public void insertRecord(Mybean p)
	{
		Transaction tx=session.beginTransaction();
		session.save(p);
		System.out.println("object saved successfully");
		tx.commit();
		}
	public void updateRecord(Mybean p)
	{
		Transaction tx=session.beginTransaction();
		Query query= session.createQuery("update Mybean b set b.name=?,b.ct=? where b.num="+p.getNum());
		
		query.setParameter(0,p.getName());
		query.setParameter(1,p.getCt());
		query.executeUpdate();
		System.out.println("object update successfully");
		tx.commit();
	}
	
	public void deleteRecord(String cv[])
	{
		Transaction tx=session.beginTransaction();
		for(int i=0;i<cv.length;i++)
		{
			Query query=session.createQuery("delete from Mybean b where b.num="+cv[i]);
			query.executeUpdate();
		}
		System.out.println("object deleted successfully");
		tx.commit();
	}
	
}
