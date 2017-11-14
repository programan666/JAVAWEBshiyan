package eqt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commen.DAOFactory;

import eqt.dao.EqtDao;
import eqt.pojo.Eqt;
import pic.dao.PicDao;



public class EqtServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		EqtDao eqtdao = DAOFactory.instance().getEqtDao();
		PicDao picdao = DAOFactory.instance().getPicDao();
		
		int option = Integer.parseInt(request.getParameter("option"));
		
		String mBlock = "style='display:block'";
		String mNone = "style='display:none'";
		
		switch(option){
		case 1:
			//查找出所有装备的所有信息
			try {
				ArrayList<Eqt> list = eqtdao.query();
				request.setAttribute("eqtList", list);
				request.setAttribute("mEqtBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				System.out.println(list);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 2:
			//根据单个Id查询此装备所有信息
			try {
				int eqtId = Integer.parseInt(request.getParameter("eqtId"));
				int searchEqtResponse = 1;
				Eqt eqt = eqtdao.queryById(eqtId);
				request.setAttribute("eqtReturn", eqt);
				request.setAttribute("mEqtBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.setAttribute("searchEqtResponse", searchEqtResponse);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3:
			//修改装备信息
			try {
				int regId = Integer.parseInt(request.getParameter("addEqtId"));
				String regName = request.getParameter("addEqtName");
				int regLevel = Integer.parseInt(request.getParameter("addEqtLevel"));
				String regAttribute = request.getParameter("addEqtAttribute");
				int regPower = Integer.parseInt(request.getParameter("addEqtPower"));
				String regType = request.getParameter("addEqtType");
				String regQuality = request.getParameter("addEqtQuality");
				int regPicId = Integer.parseInt(request.getParameter("addEqtPicId"));
				int eqtReturnMessage = 1;
				Eqt eqt = new Eqt(regId,regName,regLevel,regAttribute,picdao.queryById(regPicId),regPower,regType,regQuality);
				eqtdao.eqtUpdate(eqt);
				request.setAttribute("eqtReturnMessage", eqtReturnMessage);
				request.setAttribute("mEqtBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 4:
			//删除装备
			try {
				int eqtId = Integer.parseInt(request.getParameter("eqtId"));
				int eqtReturnMessage = 2;
				int picId = eqtdao.queryById(eqtId).getPic().getPicId();
				eqtdao.deleteById(eqtId);
				picdao.delete(picId);
				request.setAttribute("eqtReturnMessage", eqtReturnMessage);
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
