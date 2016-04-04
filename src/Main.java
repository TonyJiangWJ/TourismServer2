import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import Impls.Do.IUser;
import po.User;
import utils.statics.DateUtil;
import utils.statics.DoFactory;
import utils.statics.EncodeUtil;
import utils.statics.ParseMD5;
import utils.statics.UTools;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Impls.Do.IUser iUser = new IUser();
		
//		User usr = new User();
//		usr.setCreated_time(DateUtil.GetDateString());
//		usr.setImage("default");
//		usr.setName("ha巴阿");
//		usr.setNick_name("即把");
//		usr.setPassword(ParseMD5.parseStrToMd5U32("123456"));
//		usr.setPhone("18957612454");
//		usr.setSex("男");
//		usr.setUser_name(usr.getPhone()+"@tourism");
//		usr.setUser_id(UTools.getUniqueId(usr.getUser_name(), usr.getCreated_time()));
//		
//		if(iUser.Insert(usr))
//		{
//			System.out.println("插入成功");
//		}else{
//			System.out.println("插入失败");
//		}
		
//		if(iUser.Delete("8FE3372BA2D693E78DD1C348285674E9"))
//			System.out.println("删除成功");
//		else {
//			System.out.println("删除失败");
//		}

		
//		String id = "8A122D100B4A293E9533F47F1A969701";
//		User usr3 = iUser.Query(id);
//		if(usr3!=null)
//			System.out.println("名字:"+usr3.getName());
//		else {
//			System.out.println("没有找到");
//		}
		
//		String name = "把";
//		List<User> list = iUser.Search(name);
//		if(list!=null){
//			for(int i=0;i<list.size();i++){
//				User usr2 = list.get(i);
//				System.out.println("id:"+usr2.getUser_id()+"姓名："+usr2.getName()+"账号："+usr2.getUser_name());
//			}
//		}else {
//			System.out.println("没有找到和 '"+name+"' 相关的用户");
//		}
		
//		User usr4 = DoFactory.GetDoUser().login("18957612454@tourism","E10ADC3949BA59ABBE56E057F20F883E");
//		if(usr4!=null){
//			System.out.println("用户名："+usr4.getUser_name()+"创建时间："+usr4.getCreated_time()+"手机号："+usr4.getPhone());
//		}else{
//			System.out.println("用户名或者密码错误");
//		}
		
		String utf8String = "%E5%85%94%E5%AD%90";

		System.out.println(utf8String);
		
		String tuziString = "兔子";
		System.out.println("兔子："+tuziString);
		tuziString = EncodeUtil.toUTF8(tuziString);
		System.out.println("兔子："+tuziString);
		
		String isoString = EncodeUtil.toUTF8(utf8String);
		System.out.println("iso:"+isoString);
		String misString = EncodeUtil.MEtoUTF8(utf8String);
		System.out.println("chrome:"+misString);
		ChangeAndShow(utf8String);
	}
	public static void ChangeAndShow(String str){
		try {
			str=URLDecoder.decode(str,"utf-8");
			str=new String(str.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
