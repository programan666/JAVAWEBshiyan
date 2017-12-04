package rol.servlet;

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
import eqt.dao.EqtDao;
import eqt.pojo.Eqt;
import ocp.dao.OcpDao;
import ocp.pojo.Ocp;
import pic.dao.PicDao;
import pic.pojo.Pic;
import reg.dao.RegDao;
import reg.pojo.Reg;
import rol.dao.RolDao;
import rol.pojo.Rol;

public class RolServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		RegDao regdao = DAOFactory.instance().getRegDao();
		OcpDao ocpdao = DAOFactory.instance().getOcpDao();
		RolDao roldao = DAOFactory.instance().getRolDao();
		EqtDao eqtdao = DAOFactory.instance().getEqtDao();
		PicDao picdao = DAOFactory.instance().getPicDao();
		int option = Integer.parseInt(request.getParameter("option"));
		String mBlock = "style='display:block'";
		String mNone = "style='display:none'";
		switch(option){
		
		case 1:
			//返回大区职业信息到注册页面
			try {
				ArrayList<Reg> regList = regdao.query();
				ArrayList<Ocp> ocpList = ocpdao.query();
				int ocpNum = ocpList.size();
				request.setAttribute("regList", regList);
				request.setAttribute("ocpList", ocpList);
				request.setAttribute("ocpNum", ocpNum);
				request.getRequestDispatcher("regist.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			//角色注册
			try {
				String rolName = request.getParameter("rolName");
				String rolLoginName = request.getParameter("rolLoginName");
				String rolPwd = request.getParameter("rolPwd");
				String rolEmail = request.getParameter("rolEmail");
				String rolMood = request.getParameter("rolMood");
				int rolRegSelected = Integer.parseInt(request.getParameter("rolRegSelected"));
				String rolOcpName = request.getParameter("rolOcpName");
				boolean nameExit = roldao.rolNameIsExit(rolName);
				boolean loginNameExit = roldao.rolLoginNameIsExit(rolLoginName);
				boolean emailExit = roldao.rolEmailIsExit(rolEmail);
				int exitFlag = 0;
				String errorMessage = null;
				if(!emailExit){
					if(!loginNameExit){
						if(!nameExit){
							Pic modelPic = picdao.queryById(86);
							Pic userPicmodel = new Pic(rolLoginName,modelPic.getInfo(),modelPic.getPicSize(),modelPic.getPicData(),new Date());
							picdao.insert(userPicmodel);
							Pic userPic = picdao.queryById(picdao.queryByName(rolLoginName));
							Rol rol = new Rol(rolName,rolLoginName,rolPwd,rolEmail,rolMood,userPic,regdao.queryById(rolRegSelected),ocpdao.queryByName(rolOcpName),100,eqtdao.queryById(1));
							roldao.insert(rol);
							session.setAttribute("rolInfo", rol);
							response.sendRedirect("role.jsp");
							break;
						}
						else{
							errorMessage = "角色名已存在";
							exitFlag = 1;
						}
					}
					else{
						errorMessage = "账号已存在";
						exitFlag = 2;
					}
				}
				else{
					errorMessage = "邮箱已存在";
					exitFlag = 3;
				}
				ArrayList<Reg> regList = regdao.query();
				ArrayList<Ocp> ocpList = ocpdao.query();
				int ocpNum = ocpList.size();
				request.setAttribute("regList", regList);
				request.setAttribute("ocpList", ocpList);
				request.setAttribute("ocpNum", ocpNum);
				request.setAttribute("rolName", rolName);
				request.setAttribute("rolLoginName", rolLoginName);
				request.setAttribute("rolPwd", rolPwd);
				request.setAttribute("rolEmail", rolEmail);
				request.setAttribute("rolMood", rolMood);
				request.setAttribute("rolRegSelected", rolRegSelected);
				request.setAttribute("errorMessage", errorMessage);
				request.setAttribute("rolOcpName", rolOcpName);
				request.getRequestDispatcher("regist.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3:
			//获得大区，职业列表
			try {
				ArrayList<Ocp> ocpList = ocpdao.query();
				ArrayList<Reg> regList = regdao.query();
				request.setAttribute("ocpList", ocpList);
				request.setAttribute("regList", regList);
				request.setAttribute("mRolBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 4:
			//根据条件查找rol
			try {
				String rolName = request.getParameter("rolNameForSearch");
				int rolOcpId = Integer.parseInt(request.getParameter("rolOcpForSearch"));
				int rolRegId = Integer.parseInt(request.getParameter("rolRegForSearch"));
				int searchfrom = Integer.parseInt(request.getParameter("searchfrom"));
				int searchto = Integer.parseInt(request.getParameter("searchto"));
				int searchReturnmessage = 6;
				System.out.println(rolName+"  "+rolOcpId+"  "+rolRegId);
				Rol rol = new Rol(0,rolName,"","","","",null,regdao.queryById(rolRegId),ocpdao.queryById(rolOcpId),0);
				int rolCount = roldao.getcount(rol);//查找到的角色个数
				int nowPage = searchto/6;
				System.out.println("符合条件的角色有 "+rolCount+" 个");
				ArrayList<Rol> rolList = roldao.getByCondition(rol, searchfrom, searchto);
				ArrayList<Ocp> ocpList = ocpdao.query();
				ArrayList<Reg> regList = regdao.query();
				request.setAttribute("ocpList", ocpList);
				request.setAttribute("regList", regList);
				request.setAttribute("rolList", rolList);
				request.setAttribute("rolName", rolName);
				request.setAttribute("rolOcpId", rolOcpId);
				request.setAttribute("rolRegId", rolRegId);
				request.setAttribute("rolCount", rolCount);
				request.setAttribute("nowPage", nowPage);
				request.setAttribute("searchReturnmessage", searchReturnmessage);
				request.setAttribute("mRolBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 5:
			//修改角色密码
			try {
				int rolId = Integer.parseInt(request.getParameter("rolId"));
				String oldPwd = request.getParameter("rolOldPwd");
				String newPwd = request.getParameter("rolNewPwd");
				int updateRolPwdReturn;
				Rol rol = roldao.queryById(rolId);
				if(oldPwd.equals(rol.getRolPwd())){
					rol.setRolPwd(newPwd);
					roldao.update(rol);
					updateRolPwdReturn = 1;
				}
				else{
					updateRolPwdReturn = 2;
				}
				request.setAttribute("updateRolPwdReturn", updateRolPwdReturn);
				request.setAttribute("oldPwd", oldPwd);
				request.setAttribute("newPwd", newPwd);
				request.getRequestDispatcher("RolPwdInfo.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 6:
			//删除角色
			try {
				int rolId = Integer.parseInt(request.getParameter("rolId"));
				int deleteRolReturn;
				roldao.delete(rolId);
				deleteRolReturn = 1;
				request.getSession().removeAttribute("rolInfo");
				response.sendRedirect("login.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 7:
			//注销登录
			request.getSession().removeAttribute("rolInfo");
			response.sendRedirect("login.jsp");
			break;
			
		case 8:
			//异步修改昵称
			try {
				String newRolName = request.getParameter("newRolName");
				int rolId = Integer.parseInt(request.getParameter("rolId"));
				System.out.println("newRolName is: "+newRolName+"  "+rolId);
				Rol rol = roldao.queryById(rolId);
				rol.setRolName(newRolName);
				roldao.update(rol);
				request.getSession().removeAttribute("rolInfo");
				Rol newrol = roldao.queryById(rolId);
				session.setAttribute("rolInfo", newrol);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 9:
			//异步修改心情
			try {
				String newRolMood = request.getParameter("newRolMood");
				int rolId = Integer.parseInt(request.getParameter("rolId"));
				System.out.println("newRolName is: "+newRolMood+"  "+rolId);
				Rol rol = roldao.queryById(rolId);
				rol.setRolMood(newRolMood);
				roldao.update(rol);
				request.getSession().removeAttribute("rolInfo");
				Rol newrol = roldao.queryById(rolId);
				session.setAttribute("rolInfo", newrol);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case 10:
			//返回所有装备信息到管理装备界面
			try {
				ArrayList<Eqt> list = eqtdao.query();
				request.setAttribute("eqtList", list);
				request.setAttribute("mEqtBlock", mBlock);
				request.setAttribute("mStartNone", mNone);
				System.out.println(list);
				request.getRequestDispatcher("rolEqt.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 11:
			//匹配rolid和eqtid
			try {
				int selectedEqtId = Integer.parseInt(request.getParameter("selectedEqtId"));
				int rolId = Integer.parseInt(request.getParameter("rolId"));
				Rol rol = roldao.queryById(rolId);
				Eqt eqt = eqtdao.queryById(selectedEqtId);
				int powerIncrease = eqt.getEqtPower();
				int powerNew = 100+powerIncrease;
				rol.setRolPower(powerNew);
				rol.setEqt(eqt);
				roldao.update(rol);
				request.getSession().removeAttribute("rolInfo");
				Rol newrol = roldao.queryById(rolId);
				session.setAttribute("rolInfo", newrol);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
