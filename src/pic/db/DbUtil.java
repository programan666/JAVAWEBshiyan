package pic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class DbUtil {
	public static Connection GetConnection() throws SQLException{
		DriverManager.registerDriver(new OracleDriver());
		//���ݿ�����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "mygame";
		String password = "acm666666";
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	
/*	 private static Connection con = null;
	 private static PreparedStatement ps = null;
	 private static ResultSet rs = null;*/
	
	  /**
     * ׼������
     */
 /*   static {
        try {*/
        	/*Class.forName("oracle.jdbc.OracleDriver");*/
/*        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("��������ʧ�ܣ�");
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        try {*/
        	/*String url = "jdbc:oracle:thin:@localhost:1521:xe";
    		String user = "mygame";
    		String password = "acm666666";
            con = DriverManager.getConnection(url,user,password);*/
            // System.out.println(con);
       /* } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("����ʧ�ܣ�");
            e.printStackTrace();
        }
        return con;
    }
    
    public static void closeAll(ResultSet rs, PreparedStatement ps,
            Connection con) {
        try {
            if (null != rs) {
                rs.close();
            }
            if (null != ps) {
                ps.close();
            }
            if (null != con) {
                con.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
    
    
	
}
