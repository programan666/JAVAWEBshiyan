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
		Rol rol = new Rol("Ⱦ������","firstrole","666666","849740574@qq.com","�о��Լ�������",picdao.queryById(41),regdao.queryById(142),ocpdao.queryById(21),100);
		roldao.insert(rol);
	}
	
	@Test
	public void getCount1() throws SQLException{
		String sql="select count(*) from rol where rol_name='Ⱦ������'";
		int i = roldao.getcount(sql);
		System.out.println(i);
	}
	
	@Test
	public void rolNameIsExit() throws SQLException{
		boolean i = roldao.rolNameIsExit("Ⱦ������");
		System.out.println(i);
	}
	
	@Test
	public void getCount2() throws SQLException{
		Rol rol = new Rol(0,"Ⱦ������","","","","", null, null, null,0);
		int i = roldao.getcount(rol);
		System.out.println(i);
	}
	
	@Test
	public void getByCondition() throws SQLException{
		Rol rol = new Rol(0,"Ĩ���ഺ","","","","", null, regdao.queryById(147), ocpdao.queryById(22),0);
		System.out.println("haha: "+roldao.getByCondition(rol, 1, 3));
	}
}
