package mng.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
import rol.dao.RolDao;
import rol.pojo.Rol;


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
		RolDao roldao = DAOFactory.instance().getRolDao();

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
						Mng mng = mngdao.queryByLoginName(loginName);
						session.setAttribute("loginMng", mng);
						File fi = new File("D:\\Eclipse\\eclipse\\JAVAWEB\\WebContent\\日志\\日志.txt");
						FileOutputStream output = new FileOutputStream(fi,true);
						Date date = new Date();
						String str = date.toString()+":\n"+mng.getMngId()+" 管理员登录\n\n";
						output.write(str.getBytes());
						output.close();
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
			else if(loginType.equals("player")){
				try {
					int loginResult = roldao.checkLogin(loginName, pwd);
					if(loginResult==3){		
						Rol rol = roldao.queryByLoginName(loginName);
						session.setAttribute("rolInfo", rol);
						File fi = new File("D:\\Eclipse\\eclipse\\JAVAWEB\\WebContent\\日志\\日志.txt");
						FileOutputStream output = new FileOutputStream(fi,true);
						Date date = new Date();
						String str = date.toString()+":\n"+rol.getRolId()+" 玩家登录\n\n";
						output.write(str.getBytes());
						output.close();
						response.sendRedirect("role.jsp");
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
			//修改密码
			Mng loginMng = (Mng)session.getAttribute("loginMng");
			String lpassWord = request.getParameter("lpassWord");
			String xpassWord = request.getParameter("xpassWord");
			String xpassWord2 = request.getParameter("xpassWord2");
			try {
				String linshiPassWord = loginMng.getMngPwd();
				if(linshiPassWord.equals(lpassWord)){
					loginMng.setMngPwd(xpassWord);
					mngdao.update(loginMng);
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
			//查询所有大区
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
			//添加大区
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
			//得到所选大区
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
			//删除大区
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
			//修改大区信息
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
			
		case 8:
			//注销登录
			request.getSession().removeAttribute("loginMng");
			response.sendRedirect("login.jsp");
			break;
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
