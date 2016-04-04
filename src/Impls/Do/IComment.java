package Impls.Do;

import java.util.List;

import Impls.AbsClass;
import po.Comment;

public class IComment extends AbsClass{
	public boolean Insert(Comment comt){
		super.Init();
		try{
			super.session.save(comt);
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
			Comment comt = (Comment) super.session.get(Comment.class, id);
			if(comt!=null){
				super.session.delete(comt);
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
	
	public Comment Query(String id){
		super.Init();
		try {
			Comment comt = (Comment) super.session.get(Comment.class, id);
			if(comt!=null){
				super.Close();
				return comt;
			}
		} catch (Exception e) {
			super.Close();
			e.printStackTrace();
			return null;
		}
		return null;
	}
	public List<Comment> ShowAll(String to_id){
		super.Init();
		List<Comment> comt_list = null;
		try{
			String hql = "from Comment as comt where comt.to_id = '"+to_id+"'";
			comt_list = super.session.createQuery(hql).list();
			super.Close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return comt_list.size()==0?null:comt_list;
	}
	public List<Comment> Search(String name){
		super.Init();
		List<Comment> comt_list = null;
		try{
			String hql = "from Comment as comt where comt.content like '%"+name+"%'";
			comt_list = super.session.createQuery(hql).list();
			super.Close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return comt_list.size()==0?null:comt_list;
	}
}
