package test;

import java.sql.SQLException;

import org.junit.Test;

import commen.DAOFactory;
import eqt.dao.EqtDao;
import eqt.pojo.Eqt;
import pic.dao.PicDao;
import pic.pojo.Pic;

public class TestEqtDao {
	private EqtDao eqtdao = DAOFactory.instance().getEqtDao();
	private PicDao picdao = DAOFactory.instance().getPicDao();
	
	@Test
	public void testInsert() throws SQLException{
		Eqt eqt = new Eqt("���ǹ",55,"Զ����������ʹ����˲�����",picdao.queryById(43),9999,"��ǹ","����");
		eqtdao.insert(eqt);
	}
	
	@Test
	public void queryById() throws SQLException{
		Eqt eqt = eqtdao.queryById(1);
		System.out.println(eqt);
	}
}
