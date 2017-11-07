package reg.service;

import java.sql.SQLException;
import java.util.ArrayList;

import commen.DAOFactory;
import reg.dao.RegDao;
import reg.pojo.Reg;

public class RegService {
	RegDao dao = DAOFactory.instance().getRegDao();
	
	public ArrayList<Reg> query() throws SQLException{
		return dao.query();
	}
	
	public void insert(Reg reg) throws SQLException{
		dao.insert(reg);
	}
	
	public void update(Reg reg) throws SQLException{
		dao.update(reg);
	}
	
	public void delete(int regId) throws SQLException{
		dao.delete(regId);
	}
	
	public void queryById(int regId) throws SQLException{
		dao.queryById(regId);
	}
	
	public void queryByName(String regName) throws SQLException{
		dao.queryByName(regName);
	}
	
}
