package test;

import java.sql.SQLException;

import org.junit.Test;

import commen.DAOFactory;
import reg.dao.RegDao;
import reg.pojo.Reg;

//大区测试类

public class TestRegDao {
	private RegDao dao = DAOFactory.instance().getRegDao();
	@Test
	public void testInsert() throws SQLException{
		Reg reg = new Reg("双线七区");
		dao.insert(reg);
	}
	@Test
	public void testQueryt() throws SQLException{
		System.out.println(dao.query());
	}
}
