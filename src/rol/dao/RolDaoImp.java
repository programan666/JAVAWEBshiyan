package rol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commen.DAOFactory;
import commen.DbUtil;
import ocp.dao.OcpDao;
import pic.dao.PicDao;
import reg.dao.RegDao;
import rol.pojo.Rol;

public class RolDaoImp implements RolDao{
		RegDao regdao = DAOFactory.instance().getRegDao();
		OcpDao ocpdao = DAOFactory.instance().getOcpDao();
		PicDao picdao = DAOFactory.instance().getPicDao();
	//插入角色
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
		
		//得到已存在个数
		public int getcount(String sql) throws SQLException{
			Connection conn = DbUtil.getConnection();
			String newsql = "select count(*) "+sql.substring(sql.indexOf("from"));
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
		
		//角色名字已存在
		public boolean rolNameIsExit(String rolName) throws SQLException{
			Connection conn = DbUtil.getConnection();
			String sql = "select count(*) from rol where rol_name = '" + rolName + "'";
			int count = getcount(sql);
			return count==1;
		}
		
		//角色账号已存在
		public boolean rolLoginNameIsExit(String rolLoginName) throws SQLException{
			Connection conn = DbUtil.getConnection();
			String sql = "select count(*) from rol where rol_login_name = '" + rolLoginName + "'";
			int count = getcount(sql);
			return count==1;
		}
		
		//邮箱已存在
		public boolean rolEmailIsExit(String rolEmail) throws SQLException{
			Connection conn = DbUtil.getConnection();
			String sql = "select count(*) from rol where rol_email = '" + rolEmail + "'";
			int count = getcount(sql);
			return count==1;
		}
		
		//根据条件查询
		public ArrayList<Rol> getByCondition(String sql) throws SQLException{
			return getByCondition(sql, 0, Integer.MAX_VALUE);
		}
		
		public ArrayList<Rol> getByCondition(String sql,int start,int over) throws SQLException{
			Connection conn = DbUtil.getConnection();
			System.out.println(sql);
			String newsql = sql+")  where  rn  between  "+start+" and  "+over;
			System.out.println(newsql);
			PreparedStatement pstmt = conn.prepareStatement(newsql);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Rol> rolList = new ArrayList<Rol>();
			while(rs.next()){
				Rol rol = new Rol(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
						picdao.queryById(rs.getInt(7)),regdao.queryById(rs.getInt(8)),ocpdao.queryById(rs.getInt(9)),rs.getInt(10));
				rolList.add(rol);
			}
			rs.close();
			pstmt.close();
			conn.close();
			return rolList;
		}
		
		public ArrayList<Rol> getByCondition(Rol rol, int start,int over) throws SQLException{
			String sql = "select *  from(select r.*,rownum rn  from rol r where ";
			if(!(rol.getRolName()==null||"".equals(rol.getRolName())))
				sql += "and rol_name like '%"+rol.getRolName()+"%' ";
			if(!(rol.getReg()==null||"".equals(rol.getReg())))
				sql += "and rol_reg_id="+rol.getReg().getRegId()+" ";
			if(!(rol.getOcp()==null||"".equals(rol.getOcp())))
				sql += "and rol_ocp_id="+rol.getOcp().getOcpId()+" ";
			sql = sql.replace("where and", "where");
			boolean f = sql.toString().equals("select *  from(select r.*,rownum rn  from rol r where ");
			if(f){
				sql = "select *  from(select r.*,rownum rn  from rol r ";
			}
			return getByCondition(sql, start, over);
		}
		
		public int getcount(Rol rol) throws SQLException{
			String sql = "select * from rol where ";
			if(!(rol.getRolName()==null||"".equals(rol.getRolName())))
				sql += "and rol_name like '%"+rol.getRolName()+"%' ";
			if(!(rol.getReg()==null||"".equals(rol.getReg())))
				sql += "and rol_reg_id="+rol.getReg().getRegId()+" ";
			if(!(rol.getOcp()==null||"".equals(rol.getOcp())))
				sql += "and rol_ocp_id="+rol.getOcp().getOcpId()+" ";
			sql = sql.replace("where and", "where");
			boolean f = sql.toString().equals("select * from rol where ");
			if(f){
				sql = "select * from rol";
			}
			return getcount(sql);
		}
}
