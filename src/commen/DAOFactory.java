package commen;

import eqt.dao.EqtDao;
import mng.dao.MngDao;
import ocp.dao.OcpDao;
import pic.dao.PicDao;
import reg.dao.RegDao;
import rol.dao.RolDao;

public abstract class DAOFactory {
	private static DAOFactory factory = new JdbcDAOFactory();
	public static DAOFactory instance(){
		return factory;
	}
	public static DAOFactory instance(String factoryName){
		try{
			Class c = Class.forName(factoryName);
			if(factory.getClass() != c){
				factory = (DAOFactory) c.newInstance();
			}
			return factory;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	public abstract MngDao getMngDao();
	public abstract OcpDao getOcpDao();
	public abstract RegDao getRegDao();
	public abstract PicDao getPicDao();
	public abstract EqtDao getEqtDao();
	public abstract RolDao getRolDao();
}
