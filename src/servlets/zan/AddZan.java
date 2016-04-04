package servlets.zan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Zan;
import utils.HttpResult;
import utils.statics.DateUtil;
import utils.statics.DoFactory;
import utils.statics.EncodeUtil;
import utils.statics.JsonUtil;
import utils.statics.UTools;

/**
 * Servlet implementation class AddZan
 */
@WebServlet("/AddZan")
public class AddZan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddZan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String jsonZan = request.getParameter("jsonZan");
		boolean flag = true; 
		if(jsonZan!=null){
			jsonZan = EncodeUtil.toUTF8(jsonZan);
			Zan zan = (Zan) JsonUtil.jsonString2Object(jsonZan, Zan.class);
			zan.setPub_time(DateUtil.GetDateString());
			zan.setZan_id(UTools.getUniqueId(zan.getOwner_id(), zan.getPub_time()));
			flag = DoFactory.GetDoZan().Insert(zan);
		}else{
			flag = false;
		}
		HttpResult h = new HttpResult(flag);
		out.write(JsonUtil.object2JsonString(h));
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
