package mng.dao;

import java.sql.SQLException;

import mng.pojo.Mng;

public interface MngDaoInt {
	//����Ŀ¼��
	public void insert(Mng mng) throws SQLException;
	public void update(Mng mng)  throws SQLException;
	public void delete(int mngId)  throws SQLException;
	public int checkLogin(String mngLoginName,String mngPwd)  throws SQLException;
}
