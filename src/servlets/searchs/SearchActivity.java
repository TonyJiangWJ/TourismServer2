package servlets.searchs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Activities;
import utils.HttpResult;
import utils.statics.DoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class SearchActivity
 */
@WebServlet("/SearchActivity")
public class SearchActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchActivity() {
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
			contain = EncodeUtil.toUTF8(contain);
			ArrayList<Activities> act_list = new ArrayList<Activities>();
			act_list = (ArrayList<Activities>) DoFactory.GetDoActivity().Search(contain);
			if(act_list!=null)
				out.write(JsonUtil.javaList2JsonList(act_list));
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
