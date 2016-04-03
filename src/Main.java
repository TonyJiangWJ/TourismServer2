import Impls.Do.IUser;
import po.User;
import utils.statics.DateUtil;
import utils.statics.ParseMD5;
import utils.statics.UTools;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User usr = new User();
		usr.setCreated_time(DateUtil.GetDateString());
		usr.setImage("default");
		usr.setName("王巴阿");
		usr.setNick_name("即把");
		usr.setPassword(ParseMD5.parseStrToMd5U32("123456"));
		usr.setPhone("18957612451");
		usr.setSex("男");
		usr.setUser_name("18957612451@tourism");
		usr.setUser_id(UTools.getUniqueId(usr.getUser_name(), usr.getCreated_time()));
		Impls.Do.IUser iUser = new IUser();
		if(iUser.Insert(usr))
		{
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
		}
		
	}

}
