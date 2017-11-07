package commen;

import eqt.dao.EqtDao;
import mng.dao.MngDao;
import ocp.dao.OcpDao;
import pic.dao.PicDao;
import reg.dao.RegDao;
import rol.dao.RolDao;

public class JdbcDAOFactory extends DAOFactory{
	public MngDao getMngDao(){
		return new MngDao();
	}
	public OcpDao getOcpDao(){
		return new OcpDao();
	}
	public RegDao getRegDao(){
		return new RegDao();
	}
	public PicDao getPicDao(){
		return new PicDao();
	}
	public EqtDao getEqtDao(){
		return new EqtDao();
	}
	public RolDao getRolDao(){
		return new RolDao();
	}
}
