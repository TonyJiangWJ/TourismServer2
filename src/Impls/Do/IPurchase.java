package Impls.Do;

import java.util.List;

import po.Purchase;
import Impls.AbsClass;

public class IPurchase extends AbsClass{
	public boolean Insert(Purchase purchase){
		super.Init();
		try{
			super.session.save(purchase);
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
			Purchase purchase = (Purchase) super.session.get(Purchase.class, id);
			if(purchase!=null){
				super.session.delete(purchase);
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
	
	public Purchase Query(String id){
		super.Init();
		try {
			Purchase purchase = (Purchase) super.session.get(Purchase.class, id);
			if(purchase!=null){
				super.Close();
				return purchase;
			}
		} catch (Exception e) {
			super.Close();
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public List<Purchase> ShowAll(String owner_id){
		super.Init();
		List<Purchase> purchase_list = null;
		try{
			String hql = "from Purchase as purchase where purchase.to_id = '"+owner_id+"'";
			purchase_list = super.session.createQuery(hql).list();
			super.Close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return purchase_list.size()==0?null:purchase_list;
	}
	public boolean Update(Purchase purchase){
		super.Init();
		try{
			super.session.update(purchase);
			super.Commit();
		}catch(Exception e){
			e.printStackTrace();
			super.Close();
			return false;
		}
		return true;
	}

}
