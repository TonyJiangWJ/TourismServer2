package utils.statics;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class EncodeUtil {
	//MyEclipse和IE的URL编码转换
	public static String MEtoUTF8(String str){

		try {
//			System.out.println("before iso:"+str);
			str=URLDecoder.decode(str,"ISO-8859-1");
//			System.out.println("after url iso:"+str);
			str=new String(str.getBytes("ISO-8859-1"));
			return str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//包括Chrome Android在内的大多数UTF-8编码的URL
	public static String toUTF8(String str){
		try {
			String value = null;
			value = new String(str.getBytes("ISO-8859-1"),"UTF-8");
			return value;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
