package servlets.zan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Zan;
import utils.HttpResult;
import utils.statics.DoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;

/**
 * Servlet implementation class GetCount
 */
@WebServlet("/GetCount")
public class GetCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCount() {
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
		String obj_id = request.getParameter("obj_id");
		if(obj_id!=null){
			obj_id = EncodeUtil.toUTF8(obj_id);
			ArrayList<Zan> zan_list = new ArrayList<Zan>();
			zan_list = (ArrayList<Zan>) DoFactory.GetDoZan().ShowAll(obj_id);
			if(zan_list!=null){
				HttpResult hResult = new HttpResult();
				hResult.setResult("success");
				hResult.setStatus(zan_list.size());
				out.write(JsonUtil.object2JsonString(hResult));
			}else{
				flag = false;
			}
		}else{
			flag = false;
		}
		if(flag == false){
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
