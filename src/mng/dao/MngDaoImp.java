package mng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import commen.DbUtil;
import mng.pojo.Mng;

public class MngDaoImp implements MngDao {

	
	//添加管理员
		public void insert(Mng mng) throws SQLException{
			
			Connection conn = DbUtil.getConnection();
			String sql = "insert into mng values(mng_seq.nextval,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mng.getMngLoginName());
			pstmt.setString(2, mng.getMngPwd());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
		//根据用户名查找
		public Mng queryByLoginName(String loginName) throws SQLException{
			Connection conn = DbUtil.getConnection();
			String sql = "select * from mng where mng_login_name = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginName);
			ResultSet rs = pstmt.executeQuery();
			Mng mng = null;
			if(rs.next()){
				mng = new Mng(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			rs.close();
			pstmt.close();
			conn.close();
			return mng;
		}
		
		
		//修改
		public void update(Mng mng) throws SQLException{
			Connection conn = DbUtil.getConnection();
			String sql = "update mng set mng_login_name=?,mng_pwd=? where mng_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mng.getMngLoginName());
			pstmt.setString(2, mng.getMngPwd());
			pstmt.setInt(3,mng.getMngId());
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
		//删除
		public void delete(int mngId) throws SQLException{
			Connection conn = DbUtil.getConnection();
			String sql = "delete from mng where mng_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,mngId);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		}
		
		//判断登录
		public int checkLogin(String mngLoginName,String mngPwd) throws SQLException{
			Connection conn = DbUtil.getConnection();
			String i = null;
			Mng mng = null;
			String sql = "select * from mng where mng_login_name=?";
			PreparedStatement pstmt;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mngLoginName);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()){
					mng = new Mng(rs.getInt(1),rs.getString(2),rs.getString(3));
				}
				System.out.println(mng);
				i = mng.getMngPwd();
				if(i.equals(mngPwd)){
					rs.close();
					pstmt.close();
					conn.close();
					return 3;
				}
				else{
					rs.close();
					pstmt.close();
					conn.close();
					System.out.println("密码错误");
					return 2;
				}
			} catch (Exception e) {
				conn.close();
				// TODO Auto-generated catch block
				System.out.println("用户名不存在");
				return 1;
			}
			
			
		}
}
