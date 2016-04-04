package Impls.Do;

import java.util.List;

import po.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Impls.AbsClass;

public class IUser extends AbsClass{

	public User login(String username,String password){
		super.Init();
		try{
			String hql = "from User as usr where usr.user_name=:username and usr.password = :pwd";
			org.hibernate.Query query = super.session.createQuery(hql);
			query.setString("username", username);
			query.setString("pwd", password);
			List<User> result = query.list();
			super.Close();
			if(result.size()!=0){
				return result.get(0);
			}else {
				return null;
			}
		}catch(Exception e){
			super.Close();
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean Insert(User usr) {
		super.Init();
		try{
			super.session.save(usr);
			super.Commit();
		}catch(Exception e){
			e.printStackTrace();
			super.Rollback();
			return false;
		}
		return true;
	}
	
	public boolean Delete(String id){
		super.Init();
		try{
			User usr = (User)super.session.get(User.class, id);
			if(usr!=null){
				session.delete(usr);
				super.Commit();
			}
		}catch(Exception e){
			e.printStackTrace();
			super.Rollback();
			return false;
		}
		return true;
	}
	
	public User Query(String id){
		super.Init();
		User usr = null;
		try{
			usr = (User)super.session.get(User.class, id);
			super.Close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return usr;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> Search(String name){
		List usr_list = null;
		super.Init();
		try{
			String hql = "from User as usr where usr.name like '%"+name+"%' or usr.nick_name like '%"+name+"%'";
			org.hibernate.Query query = super.session.createQuery(hql);
			usr_list = query.list();
			super.Close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

		return usr_list.size()==0?null:usr_list;
	}
}
