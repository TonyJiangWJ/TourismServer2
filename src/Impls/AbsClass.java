package Impls;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class AbsClass implements SuperImpl{
	private Configuration conf;
	private SessionFactory sf;
	protected Session session;
	protected Transaction transaction;
	public void Init(){
		conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
		session = utils.HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
	}
	
	@Override
	public boolean Insert() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean Delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List Query(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List Search(String info) {
		// TODO Auto-generated method stub
		return null;
	}

}
