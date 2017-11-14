package ocp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commen.DAOFactory;
import ocp.dao.OcpDao;
import ocp.pojo.Ocp;


public class OcpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int option = Integer.parseInt(request.getParameter("option"));
		OcpDao ocpDao = DAOFactory.instance().getOcpDao();
		
		String mBlock = "style='display:block'";
		String mNone = "style='display:none'";
		
		switch(option){
		
		case 1: 
			try {
				ArrayList<Ocp> allOcp = ocpDao.query();
				request.setAttribute("allOcp", allOcp);
				request.setAttribute("mOcpBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
