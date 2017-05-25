package javaman;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class JavamanController extends ActionSupport implements ServletRequestAware,ApplicationAware{
	private static final long serialVersionUID=1L;

	private static final String SUCCESS = null;
	
	MyOperations myOperations=new MyOperations();
	private List<Mybean> recordsFromDB;
	
	Mybean b;

	public Mybean getB() {
		return b;
	}

	public void setB(Mybean b) {
		this.b = b;
	}
	
	//For RequestAware Interface
	
	HttpServletRequest request;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	//For Bean, while selecting..
	
	public List<Mybean> getRecordsFromDB()
	{
		return this.recordsFromDB;
	}
	
    // for ApplicationAware Interface
	
	Map m;
	public void setApplication(Map m)
	{
		this.m=m;
	}
	
    // *******     For select query  ********
	
	public String getRecords()
	{
		recordsFromDB=myOperations.retriveRecords(request.getParameter("fid"));
		Iterator<Mybean> it=recordsFromDB.iterator();
		
		while(it.hasNext())
		{
			Object o=it.next();
			b=(Mybean) o;
		}
		m.put("x",b.getNum());
		m.put("y", b.getName());
		m.put("z", b.getCt());
		return SUCCESS;
	}
	
	// ********     Insert method      *********
	
	public String insertRecord()
	{
		myOperations.insertRecord(b);
		return SUCCESS;
	}
	
    //**********    update in database  **********
	
	public String Update()
	{
		myOperations.updateRecord(b);
		return SUCCESS;
	}
	
	public String deleteRecord()
	{
		String cv[]=null;
		cv=request.getParameterValues("rdel");
		myOperations.deleteRecord(cv);
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

}
