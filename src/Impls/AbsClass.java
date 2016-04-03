package Impls;

import java.util.List;

import javax.transaction.RollbackException;

import org.apache.catalina.User;
import org.eclipse.jdt.internal.compiler.parser.CommitRollbackParser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class AbsClass {
	private Configuration conf;
	private SessionFactory sf;
	protected Session session;
	private Transaction transaction;
	
	public void Init(){
		conf = new Configuration().configure();
		sf = conf.buildSessionFactory();
		session = utils.HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
	}
	public void Close(){
		utils.HibernateSessionFactory.closeSession();
	}
	public void Commit(){
		transaction.commit();
		Close();
	}
	public void Rollback(){
		transaction.rollback();
		Close();
	}
	
	
}
