package utils.statics;

import Impls.Do.IActivity;
import Impls.Do.IComment;
import Impls.Do.ICompany;
import Impls.Do.IKnowledge;
import Impls.Do.IPackage;
import Impls.Do.IPurchase;
import Impls.Do.ITopic;
import Impls.Do.IUser;
import Impls.Do.IZan;

public class DoFactory {
	public static IActivity GetDoActivity(){
		return new IActivity();
	}
	public static IComment GetDoComment(){
		return new IComment();
	}
	public static ICompany GetDoCompany(){
		return new ICompany();
	}
	public static IKnowledge GetDoKnowledge(){
		return new IKnowledge();
	}
	public static IPackage GetDoPackage(){
		return new IPackage();
	}
	public static IPurchase GetDoPurchase(){
		return new IPurchase();
	}
	public static ITopic GetDoTopic(){
		return new ITopic();
	}
	public static IUser GetDoUser(){
		return new IUser();
	}
	public static IZan GetDoZan(){
		return new IZan();
	}
	
}
