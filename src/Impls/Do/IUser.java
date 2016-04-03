package Impls.Do;

import po.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Impls.AbsClass;

public class IUser extends AbsClass{


	public boolean Insert(User usr) {
		super.Init();
		try{
			super.session.save(usr);
			super.transaction.commit();
			super.session.close();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
