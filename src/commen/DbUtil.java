package commen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import oracle.jdbc.driver.OracleDriver;

public class DbUtil {
	private static ComboPooledDataSource dataSource;//����Դ����
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();//�����̶߳���
	
	static{
			dataSource= new ComboPooledDataSource();
			
			try {
				
				//���Ӳ�������
				dataSource.setUser("mygame");//�����û���
				dataSource.setPassword("acm666666");//��������
				dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");//�����ַ���
				dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");//������
				
				//���ӳ�����
				dataSource.setInitialPoolSize(5);//��ʼ������
				dataSource.setMinPoolSize(5);//���ӳ����ٱ�������������
				dataSource.setMaxPoolSize(20);//���ӳ���������������
				dataSource.setMaxIdleTime(60);//������ʱ��60��
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//ͨ�����ӳض��󷵻����ݿ�����
	public static Connection getConnection() throws SQLException{
		
		//��threadLocal��ȡ���Ӷ���
		Connection conn = threadLocal.get();
		// ������Ӷ��󲻴��ڻ������Ѿ����رյģ��ʹ����ӳ�ȡ��һ�����Ӷ��󷵻أ�����Ѿ����ڣ���ֱ�ӷ���
		if(conn == null || conn.isClosed()){
			conn = dataSource.getConnection();
			threadLocal.set(conn);
		}
		
		// �������
		System.out.println("������ݿ����ӣ�" + conn + "ʣ�����������=" + dataSource.getNumIdleConnections());

		return conn;
		
	}
	
	//ͨ�ùر����ӷ���
	public static void closed(){
		
		//�ӱ����̻߳�ȡ����
		Connection conn = threadLocal.get();
				
		try {
			//�����Ӳ�Ϊ����δ�ر�ʱ
			if(conn != null && !conn.isClosed()){
				//�����
				threadLocal.set(null);
				//�ر�����
				conn.close();
			}	
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
