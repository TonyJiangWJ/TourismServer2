package servlets.Package;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.HttpResult;
import po.Packages;
import utils.statics.DoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class ListPackages
 */
@WebServlet("/ListPackages")
public class ListPackages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPackages() {
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
		String activity_id = request.getParameter("activity_id");
		if(activity_id!=null){
			activity_id = EncodeUtil.toUTF8(activity_id);
			ArrayList<Packages> pkg_list = (ArrayList<Packages>) DoFactory.GetDoPackage().ShowAll(activity_id);
			if(pkg_list==null)
				flag=false;
			else {
				out.write(JsonUtil.javaList2JsonList(pkg_list));
			}
		}else{
			flag=false;
		}
		if(flag==false)
		{
			HttpResult httpResult = new HttpResult(false);
			out.write(JsonUtil.object2JsonString(httpResult));
		}
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
