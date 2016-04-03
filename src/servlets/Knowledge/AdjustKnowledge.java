package servlets.Knowledge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.HttpResult;
import po.Knowledge;
import utils.statics.DoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class AdjustKnowledge
 */
@WebServlet("/AdjustKnowledge")
public class AdjustKnowledge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdjustKnowledge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpResult hResult = new HttpResult();
		if(request.getParameter("jsonKnowledge")!=null){
			String jsonString = EncodeUtil.toUTF8(request.getParameter("jsonKnowledge"));
			Knowledge nlg = (Knowledge) JsonUtil.jsonString2Object(jsonString, Knowledge.class);
			if(DoFactory.GetDoKnowledge().Update(nlg)){
				hResult.setResult("success");
				hResult.setStatus(200);
			}else{
				hResult.setResult("fail");
				hResult.setStatus(202);
			}
		}else{
			hResult.setResult("fail");
			hResult.setStatus(202);
		}
		out.write(JsonUtil.object2JsonString(hResult));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
