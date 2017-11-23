package rol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commen.DAOFactory;
import commen.DbUtil;
import rol.pojo.Rol;

public interface RolDao {	
	
	public void insert(Rol rol) throws SQLException;
	public int getcount(String sql) throws SQLException;
	public boolean rolNameIsExit(String rolName) throws SQLException;
	public boolean rolLoginNameIsExit(String rolLoginName) throws SQLException;
	public boolean rolEmailIsExit(String rolEmail) throws SQLException;
	public ArrayList<Rol> getByCondition(String sql) throws SQLException;
	public ArrayList<Rol> getByCondition(String sql,int start,int over) throws SQLException;
	public ArrayList<Rol> getByCondition(Rol rol, int start,int over) throws SQLException;
	public int getcount(Rol rol) throws SQLException;
	
}
