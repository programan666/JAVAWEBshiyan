package mng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import commen.DAOFactory;
import mng.dao.MngDao;
import mng.pojo.Mng;
import reg.dao.RegDao;
import reg.pojo.Reg;


public class MngServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 响应输出流
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int option = Integer.parseInt(request.getParameter("option"));
		MngDao mngdao = DAOFactory.instance().getMngDao();
		RegDao regdao = DAOFactory.instance().getRegDao();

		//自身操作
		String mBlock = "style='display:block'";
		String mNone = "style='display:none'";
		switch(option){
		
		case 1:
			//获得账号密码
			String loginName = request.getParameter("loginName");
			String pwd = request.getParameter("pwd");
			String loginType = request.getParameter("loginType");
			if(loginType.equals("manager")){
				try {
					int loginResult = mngdao.checkLogin(loginName, pwd);
					if(loginResult==3){		
						session.setAttribute("mngLoginName", loginName);
						session.setAttribute("mngPwd",pwd);
						response.sendRedirect("manager.jsp");
						return;
					}
					else if(loginResult==2){
						String errorMessage = "密码错误";
						request.setAttribute("errorMessage", errorMessage);
						request.setAttribute("LoginName", loginName);
						request.setAttribute("loginType", loginType);
						request.setAttribute("mBlock", mBlock);
						request.setAttribute("loginResult", loginResult);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					else if(loginResult==1){
						String errorMessage = "用户名不存在";
						request.setAttribute("errorMessage", errorMessage);
						request.setAttribute("LoginName", loginName);
						request.setAttribute("loginType", loginType);
						request.setAttribute("mBlock", mBlock);
						request.setAttribute("loginResult", loginResult);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			
		case 2:
			String mngloginName = (String)session.getAttribute("mngLoginName");
			String lpassWord = request.getParameter("lpassWord");
			String xpassWord = request.getParameter("xpassWord");
			String xpassWord2 = request.getParameter("xpassWord2");
			try {
				Mng mng = mngdao.queryByLoginName(mngloginName);
				String linshiPassWord = mng.getMngPwd();
				if(linshiPassWord.equals(lpassWord)){
					mng.setMngPwd(xpassWord);
					mngdao.update(mng);
					int updatePassWordResult = 1;
					request.setAttribute("updatePassWordResult",updatePassWordResult);
					request.setAttribute("mPinfoBlock", mBlock);
					request.setAttribute("mStartNone", mNone);
					request.setAttribute("lpassWord", lpassWord);
					request.setAttribute("xpassWord", xpassWord);
					request.setAttribute("xpassWord2", xpassWord2);
					request.getRequestDispatcher("manager.jsp").forward(request, response);
				}
				else{
					int updatePassWordResult = 0;
					request.setAttribute("updatePassWordResult",updatePassWordResult);
					request.setAttribute("mPinfoBlock", mBlock);
					request.setAttribute("mStartNone", mNone);
					request.setAttribute("lpassWord", lpassWord);
					request.setAttribute("xpassWord", xpassWord);
					request.setAttribute("xpassWord2", xpassWord2);
					request.getRequestDispatcher("manager.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
			
		case 3:
			try {
				ArrayList<Reg> list = regdao.query();
				request.setAttribute("regList", list);
				request.setAttribute("mRegBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 4:
			try {
				String regName = request.getParameter("addRegName");
				Reg reg = new Reg(regName);
				regdao.insert(reg);
				int i = 1;
				request.setAttribute("insertRegResponse", i);
				request.setAttribute("mRegBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
			
		case 5:
			try {
				int regId = Integer.parseInt(request.getParameter("regId"));
				int i = 1;
				Reg reg = regdao.queryById(regId);
				String regName = reg.getRegName();
				request.setAttribute("serchRegResponse", i);
				request.setAttribute("regNameReturn", regName);
				request.setAttribute("regIdReturn", regId);
				request.setAttribute("mRegBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 6:
			try {
				int regId = Integer.parseInt(request.getParameter("regId"));
				int i = 1;
				regdao.delete(regId);
				request.setAttribute("deleteRegResponse", i);
				request.setAttribute("mRegBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 7:
			try {
				int regId = Integer.parseInt(request.getParameter("updateRegId"));
				int i = 1;
				String regName = request.getParameter("updateRegName");
				Reg reg = new Reg(regId,regName);
				regdao.update(reg);
				request.setAttribute("updateRegResponse", i);
				request.setAttribute("mRegBlock", mBlock);
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
