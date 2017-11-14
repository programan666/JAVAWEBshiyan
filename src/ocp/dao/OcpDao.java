package ocp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commen.DAOFactory;
import commen.DbUtil;
import ocp.pojo.Ocp;
import pic.dao.PicDao;

public interface OcpDao{
	
	public void insert(Ocp ocp) throws SQLException;
	public Ocp queryByName(String ocpName) throws SQLException;
	public Ocp queryById(int ocpId) throws SQLException;
	public void delete(int ocpId) throws SQLException;
	public void update(Ocp ocp) throws SQLException;
	public ArrayList<Ocp> query() throws SQLException;
	
}
