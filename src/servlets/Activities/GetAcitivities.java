package servlets.Activities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import utils.statics.DoFactory;
import utils.statics.JsonUtil;
import po.Activities;
import utils.HttpResult;

/**
 * Servlet implementation class GetAcitivities
 */
@WebServlet("/GetAcitivities")
public class GetAcitivities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAcitivities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ArrayList<Activities> act_list  = (ArrayList<Activities>) DoFactory.GetDoActivity().ShowAll();
		if(act_list!=null){
			out.write(JsonUtil.javaList2JsonList(act_list));
		}else{
			HttpResult hResult = new HttpResult();
			hResult.setResult("fail");
			hResult.setStatus(202);
			out.write(JsonUtil.object2JsonString(hResult));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
