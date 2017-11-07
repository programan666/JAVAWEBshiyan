package reg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commen.DbUtil;
import reg.pojo.Reg;

//大区dao
public class RegDao implements RegDaoInt{
	//插入大区
	public void insert(Reg reg) throws SQLException{
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "insert into reg values (reg_seq.nextval,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reg.getRegName());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();

	}
	
	//修改
	public void update(Reg reg) throws SQLException{
		
		Connection conn = DbUtil.getConnection();
		
		String sql = "update reg set reg_name=? where reg_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, reg.getRegName());
		pstmt.setInt(2, reg.getRegId());
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	//删除
	public void delete(int regId) throws SQLException{
		Connection conn = DbUtil.getConnection();
		
		String sql = "delete from reg where reg_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, regId);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	//通过ID查询
	public Reg queryById(int regId) throws SQLException{
		Connection conn = DbUtil.getConnection();
		
		String sql = "select * from reg where reg_id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, regId);
		
		ResultSet rs = pstmt.executeQuery();
		
		Reg reg = null;
		
		if(rs.next()){
			reg = new Reg(rs.getInt(1),rs.getString(2));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return reg;
	}
	
	//通过name查询
	public Reg queryByName(String regName) throws SQLException{
		Connection conn = DbUtil.getConnection();
		
		String sql = "select * from reg where reg_name=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, regName);
		
		ResultSet rs = pstmt.executeQuery();
		
		Reg reg = null;
		
		if(rs.next()){
			reg = new Reg(rs.getInt(1),rs.getString(2));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return reg;
	}
	
	//查询所有数据
	public ArrayList<Reg> query() throws SQLException{
		Connection conn = DbUtil.getConnection();
		
		String sql = "select * from reg order by reg_id";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Reg> list = new ArrayList<Reg>();
		
		while(rs.next()){
			Reg reg = new Reg(rs.getInt(1),rs.getString(2));
			list.add(reg);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
}
