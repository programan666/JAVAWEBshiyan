package mng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import commen.DAOFactory;
import commen.DbUtil;
import mng.pojo.Mng;

public interface MngDao {
	
	//Éú³ÉÄ¿Â¼Ê÷
	public void insert(Mng mng) throws SQLException;
	public Mng queryByLoginName(String loginName) throws SQLException;
	public void update(Mng mng)  throws SQLException;
	public void delete(int mngId)  throws SQLException;
	public int checkLogin(String mngLoginName,String mngPwd)  throws SQLException;
	
	
}
