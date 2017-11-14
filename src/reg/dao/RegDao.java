package reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commen.DbUtil;
import reg.pojo.Reg;

//´óÇødao
public interface RegDao {
	
	public void insert(Reg reg) throws SQLException;
	public void update(Reg reg) throws SQLException;
	public void delete(int regId) throws SQLException;
	public Reg queryById(int regId) throws SQLException;
	public Reg queryByName(String regName) throws SQLException;
	public ArrayList<Reg> query() throws SQLException;
	
	
}
