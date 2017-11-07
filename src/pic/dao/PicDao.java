package pic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pic.db.DbUtil;
import pic.pojo.Pic;

public class PicDao implements PicDaoInt{
	
	//����ͼƬ
	public void insert(Pic pic) throws SQLException{
		Connection conn = DbUtil.GetConnection();
		String sql = "insert into pic values (pic_seq.nextval,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pic.getPicName());
		pstmt.setString(2, pic.getInfo());
		pstmt.setInt(3, pic.getPicSize());
		pstmt.setBlob(4, pic.getPicData());
		/*pstmt.setBinaryStream(4, pic.getPicData(), 101606);*/
		pstmt.setDate(5, new java.sql.Date(pic.getPicDatetime().getTime()));
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	//��ѯͼƬ��Ϣ
	public Pic queryById(int picId) throws SQLException{
		Connection conn = DbUtil.GetConnection();
		String sql = "select pic_id,pic_name,pic_info,pic_data from pic where pic_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, picId);
		ResultSet rs = pstmt.executeQuery();
		Pic pic = null;
		if(rs.next()){
			pic = new Pic(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBinaryStream(4));
		}
		rs.close();
		pstmt.close();
		//conn.close();//���ܻ����
		return pic;
	}
	
	//ɾ��ͼƬ
	public void delete(int picId) throws SQLException{
		Connection conn = DbUtil.GetConnection();
		String sql = "delete from pic where pic_id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, picId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	//����ͼƬ
	public void update(Pic pic) throws SQLException{
		Connection conn = DbUtil.GetConnection();
		String sql = "update pic set pic_id = ?,pic_name = ?,pic_info = ?,pic_size = ?,pic_data = ?,pic_datetime = ? where pic_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pic.getPicId());
		pstmt.setString(2, pic.getPicName());
		pstmt.setString(3,pic.getInfo());
		pstmt.setInt(4, pic.getPicSize());
		pstmt.setBlob(5, pic.getPicData());
		pstmt.setDate(6, new java.sql.Date(pic.getPicDatetime().getTime()));
		pstmt.setInt(7, pic.getPicId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	
	
}
