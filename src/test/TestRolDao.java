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
		Rol rol = new Rol("染红岁月","firstrole","666666","849740574@qq.com","感觉自己萌萌哒",picdao.queryById(41),regdao.queryById(142),ocpdao.queryById(21));
		roldao.insert(rol);
	}
	
	@Test
	public void getCount() throws SQLException{
		String sql="select count(*) from rol where rol_name='染红岁月'";
		int i = roldao.getcount(sql);
		System.out.println(i);
	}
	
	@Test
	public void rolNameIsExit() throws SQLException{
		boolean i = roldao.rolNameIsExit("染红岁月");
		System.out.println(i);
	}
}
