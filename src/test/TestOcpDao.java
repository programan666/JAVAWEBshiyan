package test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import commen.DAOFactory;
import ocp.dao.OcpDao;
import ocp.pojo.Ocp;
import pic.dao.PicDao;
import pic.pojo.Pic;

public class TestOcpDao {
	OcpDao ocpdao = DAOFactory.instance().getOcpDao();
	PicDao picdao = DAOFactory.instance().getPicDao();
	@Test
	public void testinsert() throws SQLException{
		Pic pic = picdao.queryById(82);
		Ocp ocp = new Ocp("ÁúÅ®",pic,"ºÜÀ÷º¦");
		ocpdao.insert(ocp);
	}
	
	@Test
	public void testQuery() throws SQLException{
		ArrayList<Ocp> list = ocpdao.query();
		for(Ocp ocp:list){
			System.out.println(ocp);
		}
	}
	
}
