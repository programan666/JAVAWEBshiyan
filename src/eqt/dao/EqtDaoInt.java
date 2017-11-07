package eqt.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import eqt.pojo.Eqt;

public interface EqtDaoInt {
	public void insert(Eqt eqt) throws SQLException;
	public Eqt queryById(int eqtId) throws SQLException;
	public ArrayList<Eqt> query() throws SQLException;
}
