package Impls.Do;

import java.util.List;

import po.Activities;

import Impls.AbsClass;

public class IActivity extends AbsClass{
	public boolean Insert(Activities act){
		super.Init();
		try{
			super.session.save(act);
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
		try {
			Activities act = (Activities) super.session.get(Activities.class, id);
			if(act!=null){
				super.session.delete(act);
				super.Commit();
			}
		} catch (Exception e) {
			super.Rollback();
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
		return true;
	}
	
	public Activities Query(String id){
		super.Init();
		try {
			Activities act = (Activities) super.session.get(Activities.class, id);
			if(act!=null){
				super.Close();
				return act;
			}
		} catch (Exception e) {
			super.Close();
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public List<Activities> Search(String name){
		super.Init();
		List<Activities> act_list = null;
		try{
			String hql = "from Activities as act where act.activity_name like '%"+name+"%'";
			act_list = super.session.createQuery(hql).list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return act_list;
	}
	
	public boolean Update(Activities act){
		super.Init();
		try{
			super.session.update(act);
			super.Commit();
		}catch(Exception e){
			e.printStackTrace();
			super.Close();
			return false;
		}
		return true;
	}
	public List<Activities> ShowAll(){
		super.Init();
		List act_list = null;
		try {
			act_list = super.session.createQuery("from Activities").list();
			if(act_list.size()==0)
				return null;
			super.Close();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return act_list;
	}

}
