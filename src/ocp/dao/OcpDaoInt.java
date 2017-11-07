package ocp.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import ocp.pojo.Ocp;

public interface OcpDaoInt {
	public void insert(Ocp ocp) throws SQLException;
	public void delete(int ocpId) throws SQLException;
	public void update(Ocp ocp) throws SQLException;
	public ArrayList<Ocp> query() throws SQLException;
}
