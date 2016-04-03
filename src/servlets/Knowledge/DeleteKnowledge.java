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
 * Servlet implementation class DeleteKnowledge
 */
@WebServlet("/DeleteKnowledge")
public class DeleteKnowledge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteKnowledge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String str = request.getParameter("nlg_id");
		boolean flag = false;
		if(str!=null){
			str = EncodeUtil.toUTF8(str);
			if(DoFactory.GetDoKnowledge().Delete(str)){
				flag=true;
			}else{
				flag=false;
			}
		}
		HttpResult hResult = new HttpResult();
		hResult.setResult(flag?"success":"fail");
		hResult.setStatus(flag?200:202);
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
