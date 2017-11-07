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

public class OcpDao implements OcpDaoInt{
	PicDao picdao = DAOFactory.instance().getPicDao();
	//添加职业
	public void insert(Ocp ocp) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "insert into ocp values(ocp_seq.nextval,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ocp.getOcpName());
		pstmt.setInt(2, ocp.getPic().getPicId());
		pstmt.setString(3, ocp.getOcpAttribute());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	//通过name查询
	public Ocp queryByName(String ocpName) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select * from ocp where ocp_name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ocpName);
		ResultSet rs = pstmt.executeQuery();
		Ocp ocp = null;
		if(rs.next()){
			ocp = new Ocp(rs.getInt(1),rs.getString(2),picdao.queryById(rs.getInt(3)),rs.getString(4));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return ocp;
	}
	
	//通过ID查询
	public Ocp queryById(int ocpId) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select * from ocp where ocp_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ocpId);
		ResultSet rs = pstmt.executeQuery();
		Ocp ocp = null;
		if(rs.next()){
			ocp = new Ocp(rs.getInt(1),rs.getString(2),picdao.queryById(rs.getInt(3)),rs.getString(4));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return ocp;
	}
	
	//删除职业
	public void delete(int ocpId) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "delete from ocp where ocp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ocpId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	//修改职业
	public void update(Ocp ocp) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "update ocp set ocp_name=?,ocp_pic_id=?,ocp_attribute=? where ocp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ocp.getOcpName());
		pstmt.setInt(2, ocp.getPic().getPicId());
		pstmt.setString(3, ocp.getOcpAttribute());
		pstmt.setInt(4, ocp.getOcpId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	//查询所有职业
	public ArrayList<Ocp> query() throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select * from ocp order by ocp_id";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Ocp> list = new ArrayList<Ocp>();
		while(rs.next()){
			Ocp ocp = new Ocp(rs.getInt(1),rs.getString(2),picdao.queryById(rs.getInt(3)),rs.getString(4));
			list.add(ocp);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	} 
	
}
