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

public class EqtDaoImp implements EqtDao{
	
	PicDao picdao = DAOFactory.instance().getPicDao();
	//添加装备
	public void insert(Eqt eqt) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "insert into eqt values (eqt_seq.nextval,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, eqt.getEqtName());
		pstmt.setInt(2, eqt.getEqtLevel());
		pstmt.setString(3, eqt.getEqtAttribute());
		pstmt.setInt(4, eqt.getPic().getPicId());
		pstmt.setInt(5, eqt.getEqtPower());
		pstmt.setString(6, eqt.getEqtType());
		pstmt.setString(7, eqt.getEqtQuality());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	//根据id查询装备
	public Eqt queryById(int eqtId) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select * from eqt where eqt_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, eqtId);
		ResultSet rs = pstmt.executeQuery();
		Eqt eqt =null;
		if(rs.next()){
			eqt = new Eqt(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
					picdao.queryById(rs.getInt(5)),rs.getInt(6),rs.getString(7),rs.getString(8));
		}
		rs.close();
		pstmt.close();
		//conn.close();
		return eqt;
	}
	
	//查询所有装备所有信息
	public ArrayList<Eqt> query() throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select * from eqt order by eqt_id";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Eqt> list = new ArrayList<Eqt>();
		while(rs.next()){
			Eqt eqt = new Eqt(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),
					picdao.queryById(rs.getInt(5)),rs.getInt(6),rs.getString(7),rs.getString(8));
			list.add(eqt);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
	//修改装备信息
	public void eqtUpdate(Eqt eqt) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "update eqt set eqt_name=?,eqt_level=?,eqt_attribute=?,eqt_pic_id=?,eqt_power=?,eqt_type=?,eqt_quality=? where eqt_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, eqt.getEqtName());
		pstmt.setInt(2, eqt.getEqtLevel());
		pstmt.setString(3, eqt.getEqtAttribute());
		pstmt.setInt(4, eqt.getPic().getPicId());
		pstmt.setInt(5, eqt.getEqtPower());
		pstmt.setString(6, eqt.getEqtType());
		pstmt.setString(7, eqt.getEqtQuality());
		pstmt.setInt(8, eqt.getEqtId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	//根据id删除装备
	public void deleteById(int eqtId) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "delete from eqt where eqt_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, eqtId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
}
