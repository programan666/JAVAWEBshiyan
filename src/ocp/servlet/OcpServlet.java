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
import pic.dao.PicDao;


public class OcpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int option = Integer.parseInt(request.getParameter("option"));
		OcpDao ocpdao = DAOFactory.instance().getOcpDao();
		PicDao picdao = DAOFactory.instance().getPicDao();
		
		String mBlock = "style='display:block'";
		String mNone = "style='display:none'";
		
		switch(option){
		
		case 1: 
			try {
				ArrayList<Ocp> allOcp = ocpdao.query();
				request.setAttribute("allOcp", allOcp);
				request.setAttribute("mOcpBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			//根据ID查询职业信息
			try {
				int ocpId = Integer.parseInt(request.getParameter("ocpId"));
				int searchOcpResponse = 1;
				Ocp ocp = ocpdao.queryById(ocpId);
				request.setAttribute("ocpReturn", ocp);
				request.setAttribute("mOcpBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.setAttribute("searchOcpResponse", searchOcpResponse);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3:
			
			try {
				int ocpId = Integer.parseInt(request.getParameter("updateOcpId"));
				String ocpName = request.getParameter("updateOcpName");
				String ocpAttribute = request.getParameter("updateOcpAttribute");
				int ocpPicId = Integer.parseInt(request.getParameter("updateOcpPicId"));
				int ocpReturnMessage = 1;
				Ocp ocp = new Ocp(ocpId,ocpName,picdao.queryById(ocpPicId),ocpAttribute);
				ocpdao.update(ocp);
				request.setAttribute("mOcpBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.setAttribute("ocpReturnMessage", ocpReturnMessage);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 4:
			//删除职业
			try {
				int ocpId = Integer.parseInt(request.getParameter("ocpId"));
				int ocpReturnMessage = 2;
				int picId = ocpdao.queryById(ocpId).getPic().getPicId(); 
				ocpdao.delete(ocpId);
				picdao.delete(picId);
				request.setAttribute("ocpReturnMessage", ocpReturnMessage);
				request.setAttribute("mEqtBlock", mBlock);
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
