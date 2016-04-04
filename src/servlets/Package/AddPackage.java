package servlets.Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.HttpResult;
import po.Packages;
import utils.statics.DateUtil;
import utils.statics.DoFactory;
import utils.statics.JsonUtil;
import utils.statics.UTools;

/**
 * Servlet implementation class AddPackage
 */
@WebServlet("/AddPackage")
public class AddPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPackage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		boolean flag = true;
		String jsonPkg = request.getParameter("jsonPkg");
		if(jsonPkg!=null){
			Packages pkg = (Packages) JsonUtil.jsonString2Object(jsonPkg, Package.class);
			pkg.setPub_time(DateUtil.GetDateString());
			pkg.setPackage_id(UTools.getUniqueId(pkg.getPkg_name(), pkg.getPub_time()));
			flag = DoFactory.GetDoPackage().Insert(pkg);
		}else{
			flag = false;
		}
		HttpResult httpResult = new HttpResult(flag);
		out.write(JsonUtil.object2JsonString(httpResult));
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
