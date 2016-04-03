package Impls;

import java.util.List;



public interface SuperImpl {
	public boolean Insert();
	public boolean Delete(String id);
	public List Query(String id);
	public List Search(String info);
}
