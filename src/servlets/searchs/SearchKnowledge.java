package servlets.searchs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Knowledge;
import utils.HttpResult;
import utils.statics.DoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class SearchKnowledge
 */
@WebServlet("/SearchKnowledge")
public class SearchKnowledge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKnowledge() {
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
		String contain = request.getParameter("contain");
		if(contain!=null){
//			System.out.println("before encode contain is: "+contain);
//			String contain2 = EncodeUtil.ChromeToUTF8(contain);
//			System.out.println("contain2 is: "+contain2);
			
			String value = EncodeUtil.toUTF8(contain);
			contain = EncodeUtil.toUTF8(contain);
			System.out.println("contain is: "+contain);
//			
			
			System.out.println("values is:"+value);
			ArrayList<Knowledge> nlg_list = new ArrayList<Knowledge>();
			nlg_list = (ArrayList<Knowledge>) DoFactory.GetDoKnowledge().Search(value);
			if(nlg_list!=null)
				out.write(JsonUtil.javaList2JsonList(nlg_list));
			else {
				flag = false;
			}
		}else{
			flag = false;
		}
		if(flag==false){
			HttpResult hResult = new HttpResult(false);
			out.write(JsonUtil.object2JsonString(hResult));
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
