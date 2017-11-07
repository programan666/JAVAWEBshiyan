package reg.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import reg.pojo.Reg;

public interface RegDaoInt {
	public void insert(Reg reg) throws SQLException;
	public void update(Reg reg) throws SQLException;
	public void delete(int regId) throws SQLException;
	public Reg queryById(int regId) throws SQLException;
	public Reg queryByName(String regName) throws SQLException;
	public ArrayList<Reg> query() throws SQLException;
}
