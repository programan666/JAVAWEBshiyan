package reg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import commen.DAOFactory;
import reg.dao.RegDao;
import reg.pojo.Reg;

/**
 * Servlet implementation class RegQueryServlet
 */
@WebServlet("/RegQueryServlet")
public class RegQueryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 响应输出流
		PrintWriter out = response.getWriter();
		
		RegDao regdao = DAOFactory.instance().getRegDao();
		
		try {
			ArrayList<Reg> list = regdao.query();
			Gson gson = new Gson();
			out.print(gson.toJson(list));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
