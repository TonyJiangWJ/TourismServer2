package Impls.Do;

import java.util.ArrayList;
import java.util.List;

import po.Packages;
import po.Purchase;
import Impls.AbsClass;

public class IPackage extends AbsClass{
	public boolean Insert(Packages pkg){
		super.Init();
		try{
			super.session.save(pkg);
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
			Packages pkg = (Packages) super.session.get(Packages.class, id);
			if(pkg!=null){
				super.session.delete(pkg);
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
	
	public Packages Query(String id){
		super.Init();
		try {
			Packages pkg = (Packages) super.session.get(Packages.class, id);
			if(pkg!=null){
				super.Close();
				return pkg;
			}
		} catch (Exception e) {
			super.Close();
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Packages> Search(String name){
		super.Init();
		List<Packages> pkg_list = null;
		try{
			String hql = "from Packages as pkg where pkg.pkg_name like '%"+name+"%' or pkg.content like '%"+name+"%'";
			pkg_list = super.session.createQuery(hql).list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return pkg_list.size()==0?null:pkg_list;
	}
	public boolean Update(Packages pkg){
		super.Init();
		try{
			super.session.update(pkg);
			super.Commit();
		}catch(Exception e){
			e.printStackTrace();
			super.Close();
			return false;
		}
		return true;
	}

	public List<Packages> ShowAll(String activity_id){
		super.Init();
		List<Packages> pkg_list = null;
		try{
			String hql = "from Package as pkg where pkg.activity_id = '"+activity_id+"'";
			pkg_list = super.session.createQuery(hql).list();
			super.Close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return pkg_list.size()==0?null:pkg_list;
	}
}
