package mng.service;

import java.sql.SQLException;

import commen.DAOFactory;
import mng.dao.MngDao;

public class MngService {
	MngDao dao = DAOFactory.instance().getMngDao();
	
	public int checkLogin(String mngLoginName,String mngPwd) throws SQLException{
		return dao.checkLogin(mngLoginName, mngPwd);
	}
}
