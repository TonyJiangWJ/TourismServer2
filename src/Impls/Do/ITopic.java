package Impls.Do;

import java.util.List;

import po.Topic;
import po.Topic;
import po.Topic;
import Impls.AbsClass;

public class ITopic extends AbsClass{
	public boolean Insert(Topic tpc){
		super.Init();
		try{
			super.session.save(tpc);
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
			Topic tpc = (Topic) super.session.get(Topic.class, id);
			if(tpc!=null){
				super.session.delete(tpc);
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
	
	public Topic Query(String id){
		super.Init();
		try {
			Topic tpc = (Topic) super.session.get(Topic.class, id);
			if(tpc!=null){
				super.Close();
				return tpc;
			}
		} catch (Exception e) {
			super.Close();
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public List<Topic> Search(String name){
		super.Init();
		List<Topic> tpc_list = null;
		try{
			String hql = "from Topic as tpc where tpc.tpc_name like '%"+name+"%'";
			tpc_list = super.session.createQuery(hql).list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return tpc_list;
	}
	public boolean Update(Topic tpc){
		super.Init();
		try{
			super.session.update(tpc);
			super.Commit();
		}catch(Exception e){
			e.printStackTrace();
			super.Close();
			return false;
		}
		return true;
	}
	public List<Topic> ShowAll(){
		super.Init();
		List tpc_list = null;
		try {
			tpc_list = super.session.createQuery("from Topic").list();
			super.Close();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return tpc_list;
	}
}
