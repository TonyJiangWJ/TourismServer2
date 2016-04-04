package Impls.Do;

import java.util.List;

import po.Activities;
import po.Knowledge;
import Impls.AbsClass;

public class IKnowledge extends AbsClass{
	public boolean Insert(Knowledge nlg){
		super.Init();
		try{
			super.session.save(nlg);
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
			Knowledge nlg = (Knowledge) super.session.get(Knowledge.class, id);
			if(nlg!=null){
				super.session.delete(nlg);
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
	
	public Knowledge Query(String id){
		super.Init();
		try {
			Knowledge nlg = (Knowledge) super.session.get(Knowledge.class, id);
			if(nlg!=null){
				super.Close();
				return nlg;
			}
		} catch (Exception e) {
			super.Close();
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Knowledge> Search(String name){
		super.Init();
		List<Knowledge> nlg_list = null;
		try{
			String hql = "from Knowledge as nlg where nlg.nlg_name like '%"+name+"%' or nlg.content like '%"+name+"%'";
			nlg_list = super.session.createQuery(hql).list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return nlg_list.size()==0?null:nlg_list;
	}
	public boolean Update(Knowledge nlg){
		super.Init();
		try{
			super.session.update(nlg);
			super.Commit();
		}catch(Exception e){
			e.printStackTrace();
			super.Close();
			return false;
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Knowledge> ShowAll(){
		super.Init();
		List nlg_list = null;
		try {
			nlg_list = super.session.createQuery("from Knowledge").list();
			super.Close();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return nlg_list.size()==0?null:nlg_list;
	}
}
