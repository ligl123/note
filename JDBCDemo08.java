package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ʹ��JDBCʵ��ģ��ת�˹���
 */
public class JDBCDemo08 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName
			("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@192.168.201.206:1521:orcl",
			"openlab",
			"open123"
			);
			//����JDBC���Ӷ�����Զ��ύ��ʽ
			//Ϊ���Զ��ύ
			conn.setAutoCommit(false);
			
			Statement stmt
			= conn.createStatement();
			//�û�lcת�˸�JACK
			String sql1 
			= "UPDATE t_user " +
			  "SET account=account-5000 " +
			  "WHERE username='lc'";
			int n1 = stmt.executeUpdate(sql1);
			if(n1>0){
				System.out.println("ת���ɹ���");
			}else{
				System.out.println("ת��ʧ�ܣ�");
				return;
			}
			String sql2
			= "UPDATE t_user " +
			  "SET account=account+5000 " +
			  "WHERE username='JAC'";
			int n2 = stmt.executeUpdate(sql2);
			if(n2>0){
				System.out.println("ת��ɹ���");
				//�ύ����
				conn.commit();
				conn.setAutoCommit(true);
			}else{
				System.out.println("ת��ʧ�ܣ�");
				//�ع�����
				conn.rollback();
				conn.setAutoCommit(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
