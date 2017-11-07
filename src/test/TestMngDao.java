package test;

import java.sql.SQLException;

import org.junit.Test;

import mng.dao.MngDao;
import mng.pojo.Mng;

public class TestMngDao {
	private MngDao dao = new MngDao();
	@Test
	public void testInsert() throws SQLException{
		Mng mng = new Mng("second","666666");
		dao.insert(mng);
	}
	
	@Test
	public void testUpdate() throws SQLException{
		Mng mng = new Mng(1,"firstmanager","666666");
		dao.update(mng);
	}
	
	@Test
	public void delete() throws SQLException{
		dao.delete(2);
	}
	
	@Test
	public void checkLogin() throws SQLException{
		dao.checkLogin("firstmanager","666666");
	}
}
