package test;

import java.sql.SQLException;

import org.junit.Test;

import commen.DAOFactory;
import ocp.dao.OcpDao;
import pic.dao.PicDao;
import reg.dao.RegDao;
import rol.dao.RolDao;
import rol.pojo.Rol;

public class TestRolDao {
	RolDao roldao = DAOFactory.instance().getRolDao();
	PicDao picdao = DAOFactory.instance().getPicDao();
	RegDao regdao = DAOFactory.instance().getRegDao();
	OcpDao ocpdao = DAOFactory.instance().getOcpDao();
	@Test
	public void insert() throws SQLException{
		Rol rol = new Rol("È¾ºìËêÔÂ","firstrole","666666","849740574@qq.com","¸Ð¾õ×Ô¼ºÃÈÃÈßÕ",picdao.queryById(41),regdao.queryById(142),ocpdao.queryById(21),100);
		roldao.insert(rol);
	}
	
	@Test
	public void getCount1() throws SQLException{
		String sql="select count(*) from rol where rol_name='È¾ºìËêÔÂ'";
		int i = roldao.getcount(sql);
		System.out.println(i);
	}
	
	@Test
	public void rolNameIsExit() throws SQLException{
		boolean i = roldao.rolNameIsExit("È¾ºìËêÔÂ");
		System.out.println(i);
	}
	
	@Test
	public void getCount2() throws SQLException{
		Rol rol = new Rol(0,"È¾ºìËêÔÂ","","","","", null, null, null,0);
		int i = roldao.getcount(rol);
		System.out.println(i);
	}
	
	@Test
	public void getByCondition() throws SQLException{
		Rol rol = new Rol(0,"Ä¨ºÚÇà´º","","","","", null, regdao.queryById(147), ocpdao.queryById(22),0);
		System.out.println("haha: "+roldao.getByCondition(rol, 1, 3));
	}
}
