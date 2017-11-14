package test;

import java.sql.SQLException;

import org.junit.Test;

import commen.DAOFactory;
import reg.dao.RegDao;
import reg.pojo.Reg;

//����������

public class TestRegDao {
	private RegDao dao = DAOFactory.instance().getRegDao();
	@Test
	public void testInsert() throws SQLException{
		Reg reg = new Reg("˫������");
		dao.insert(reg);
	}
	@Test
	public void testQueryt() throws SQLException{
		System.out.println(dao.query());
	}
}
