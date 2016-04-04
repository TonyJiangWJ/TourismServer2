package Impls.Do;

import java.util.List;

import po.Zan;
import Impls.AbsClass;

public class IZan extends AbsClass{
	public boolean Insert(Zan zan){
		super.Init();
		try{
			super.session.save(zan);
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
			Zan zan = (Zan) super.session.get(Zan.class, id);
			if(zan!=null){
				super.session.delete(zan);
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
	
	public Zan Query(String id){
		super.Init();
		try {
			Zan zan = (Zan) super.session.get(Zan.class, id);
			if(zan!=null){
				super.Close();
				return zan;
			}
		} catch (Exception e) {
			super.Close();
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Zan> ShowAll(String obj_id){
		super.Init();
		List<Zan> zan_list = null;
		try{
			String hql = "from Zan as zan where zan.to_id = '"+obj_id+"'";
			zan_list = super.session.createQuery(hql).list();
			super.Close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return zan_list.size()==0?null:zan_list;
	}
	public boolean Update(Zan zan){
		super.Init();
		try{
			super.session.update(zan);
			super.Commit();
		}catch(Exception e){
			e.printStackTrace();
			super.Close();
			return false;
		}
		return true;
	}

}
