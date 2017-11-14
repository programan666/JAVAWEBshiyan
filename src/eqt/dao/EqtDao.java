package eqt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commen.DAOFactory;
import commen.DbUtil;
import eqt.pojo.Eqt;
import pic.dao.PicDao;

public interface EqtDao{
	public void insert(Eqt eqt) throws SQLException;
	public Eqt queryById(int eqtId) throws SQLException;
	public ArrayList<Eqt> query() throws SQLException;
	public void eqtUpdate(Eqt eqt) throws SQLException;
	public void deleteById(int eqtId) throws SQLException;
}
