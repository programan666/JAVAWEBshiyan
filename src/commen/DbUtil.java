package commen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import oracle.jdbc.driver.OracleDriver;

public class DbUtil {
	private static ComboPooledDataSource dataSource;//数据源对象
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();//本地线程对象
	
	static{
			dataSource= new ComboPooledDataSource();
			
			try {
				
				//连接参数设置
				dataSource.setUser("mygame");//设置用户名
				dataSource.setPassword("acm666666");//设置密码
				dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");//连接字符串
				dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");//驱动类
				
				//连接池设置
				dataSource.setInitialPoolSize(5);//初始连接数
				dataSource.setMinPoolSize(5);//连接池最少保留的链接数量
				dataSource.setMaxPoolSize(20);//连接池最多的连接数上限
				dataSource.setMaxIdleTime(60);//最大空闲时间60秒
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//通过连接池对象返回数据库连接
	public static Connection getConnection() throws SQLException{
		
		//从threadLocal获取连接对象
		Connection conn = threadLocal.get();
		// 如果连接对象不存在或者是已经被关闭的，就从连接池取出一个连接对象返回，如果已经存在，就直接返回
		if(conn == null || conn.isClosed()){
			conn = dataSource.getConnection();
			threadLocal.set(conn);
		}
		
		// 测试语句
		System.out.println("获得数据库连接：" + conn + "剩余空闲连接数=" + dataSource.getNumIdleConnections());

		return conn;
		
	}
	
	//通用关闭连接方法
	public static void closed(){
		
		//从本地线程获取连接
		Connection conn = threadLocal.get();
				
		try {
			//在连接不为空且未关闭时
			if(conn != null && !conn.isClosed()){
				//解除绑定
				threadLocal.set(null);
				//关闭连接
				conn.close();
			}	
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
