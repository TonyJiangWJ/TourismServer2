package Impls.Do;

import java.util.List;

import po.Company;
import Impls.AbsClass;

public class ICompany extends AbsClass{
	public boolean Insert(Company comp){
		super.Init();
		try{
			super.session.save(comp);
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
			Company comp = (Company) super.session.get(Company.class, id);
			if(comp!=null){
				super.session.delete(comp);
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
	
	public Company Query(String id){
		super.Init();
		try {
			Company comp = (Company) super.session.get(Company.class, id);
			if(comp!=null){
				super.Close();
				return comp;
			}
		} catch (Exception e) {
			super.Close();
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public List<Company> Search(String name){
		super.Init();
		List<Company> comp_list = null;
		try{
			String hql = "from Company as comp where comp.company_name like '%"+name+"%'";
			comp_list = super.session.createQuery(hql).list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return comp_list.size()==0?null:comp_list;
	}

}
