package commen;


import eqt.dao.EqtDao;
import eqt.dao.EqtDaoImp;
import mng.dao.MngDao;
import mng.dao.MngDaoImp;
import ocp.dao.OcpDao;
import ocp.dao.OcpDaoImp;
import pic.dao.PicDao;
import pic.dao.PicDaoImp;
import reg.dao.RegDao;
import reg.dao.RegDaoImp;
import rol.dao.RolDao;
import rol.dao.RolDaoImp;


public class JdbcDAOFactory extends DAOFactory{
	public MngDao getMngDao(){
		return new MngDaoImp();
	}
	public OcpDao getOcpDao(){
		return new OcpDaoImp();
	}
	public RegDao getRegDao(){
		return new RegDaoImp();
	}
	public PicDao getPicDao(){
		return new PicDaoImp();
	}
	public EqtDao getEqtDao(){
		return new EqtDaoImp();
	}
	public RolDao getRolDao(){
		return new RolDaoImp();
	}
}
