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
//		usr.setName("ha�Ͱ�");
//		usr.setNick_name("����");
//		usr.setPassword(ParseMD5.parseStrToMd5U32("123456"));
//		usr.setPhone("18957612454");
//		usr.setSex("��");
//		usr.setUser_name(usr.getPhone()+"@tourism");
//		usr.setUser_id(UTools.getUniqueId(usr.getUser_name(), usr.getCreated_time()));
//		
//		if(iUser.Insert(usr))
//		{
//			System.out.println("����ɹ�");
//		}else{
//			System.out.println("����ʧ��");
//		}
		
//		if(iUser.Delete("8FE3372BA2D693E78DD1C348285674E9"))
//			System.out.println("ɾ���ɹ�");
//		else {
//			System.out.println("ɾ��ʧ��");
//		}

		
//		String id = "8A122D100B4A293E9533F47F1A969701";
//		User usr3 = iUser.Query(id);
//		if(usr3!=null)
//			System.out.println("����:"+usr3.getName());
//		else {
//			System.out.println("û���ҵ�");
//		}
		
//		String name = "��";
//		List<User> list = iUser.Search(name);
//		if(list!=null){
//			for(int i=0;i<list.size();i++){
//				User usr2 = list.get(i);
//				System.out.println("id:"+usr2.getUser_id()+"������"+usr2.getName()+"�˺ţ�"+usr2.getUser_name());
//			}
//		}else {
//			System.out.println("û���ҵ��� '"+name+"' ��ص��û�");
//		}
		
//		User usr4 = DoFactory.GetDoUser().login("18957612454@tourism","E10ADC3949BA59ABBE56E057F20F883E");
//		if(usr4!=null){
//			System.out.println("�û�����"+usr4.getUser_name()+"����ʱ�䣺"+usr4.getCreated_time()+"�ֻ��ţ�"+usr4.getPhone());
//		}else{
//			System.out.println("�û��������������");
//		}
		
		String utf8String = "%E5%85%94%E5%AD%90";

		System.out.println(utf8String);
		
		String tuziString = "����";
		System.out.println("���ӣ�"+tuziString);
		tuziString = EncodeUtil.toUTF8(tuziString);
		System.out.println("���ӣ�"+tuziString);
		
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
