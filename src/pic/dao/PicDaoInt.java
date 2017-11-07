package pic.dao;

import java.sql.Connection;
import java.sql.SQLException;

import pic.pojo.Pic;

public interface PicDaoInt {
	public void insert(Pic pic) throws SQLException;
	public Pic queryById(int picId) throws SQLException;
	public void delete(int picId) throws SQLException;
}
