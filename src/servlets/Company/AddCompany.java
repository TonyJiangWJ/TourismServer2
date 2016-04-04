package servlets.Company;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Company;
import utils.HttpResult;
import utils.statics.DateUtil;
import utils.statics.DoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import utils.statics.UTools;
@WebServlet("/AddCompany")
public class AddCompany extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCompany() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String jsonCompany = request.getParameter("jsonCom");
		boolean flag = true;
		if(jsonCompany!=null){
			jsonCompany=EncodeUtil.toUTF8(jsonCompany);
			Company company = (Company) JsonUtil.jsonString2Object(jsonCompany, Company.class);
			company.setJoin_time(DateUtil.GetDateString());
			company.setCompany_id(UTools.getUniqueId(company.getCompany_name(), company.getJoin_time()));
			flag=DoFactory.GetDoCompany().Insert(company);
		}else{
			flag=false;
		}
		HttpResult httpResult = new HttpResult(flag);
		out.write(JsonUtil.object2JsonString(httpResult));
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
