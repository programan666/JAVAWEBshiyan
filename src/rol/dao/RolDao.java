package rol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import commen.DAOFactory;
import commen.DbUtil;
import rol.pojo.Rol;

public class RolDao {	
	//�����ɫ
	public void insert(Rol rol) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "insert into rol values (rol_seq.nextval,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, rol.getRolName());
		pstmt.setString(2, rol.getRolLoginName());
		pstmt.setString(3, rol.getRolPwd());
		pstmt.setString(4, rol.getRolEmail());
		pstmt.setString(5, rol.getRolMood());
		pstmt.setInt(6, rol.getPic().getPicId());
		pstmt.setInt(7, rol.getReg().getRegId());
		pstmt.setInt(8, rol.getOcp().getOcpId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	//�õ��Ѵ��ڸ���
	public int getcount(String sql) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String newsql = "select count(*)"+sql.substring(sql.indexOf("from"));
		PreparedStatement pstmt = conn.prepareStatement(newsql);
		ResultSet rs = pstmt.executeQuery();
		int count = 0;
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return count;
	}
	
	//��ɫ�����Ѵ���
	public boolean rolNameIsExit(String rolName) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select count(*) from rol where rol_name = '" + rolName + "'";
		int count = getcount(sql);
		return count==1;
	}
	
	//��ɫ�˺��Ѵ���
	public boolean rolLoginNameIsExit(String rolLoginName) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select count(*) from rol where rol_login_name = '" + rolLoginName + "'";
		int count = getcount(sql);
		return count==1;
	}
	
	//�����Ѵ���
	public boolean rolEmailIsExit(String rolEmail) throws SQLException{
		Connection conn = DbUtil.getConnection();
		String sql = "select count(*) from rol where rol_email = '" + rolEmail + "'";
		int count = getcount(sql);
		return count==1;
	}
}
