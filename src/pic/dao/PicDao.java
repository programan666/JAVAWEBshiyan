package pic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pic.db.DbUtil;
import pic.pojo.Pic;

public interface PicDao {
	
	public void insert(Pic pic) throws SQLException;
	public Pic queryById(int picId) throws SQLException;
	public int queryByName(String picName) throws SQLException;
	public void delete(int picId) throws SQLException;
	public void update(Pic pic) throws SQLException;
	
}
