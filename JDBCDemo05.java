package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * ����ͨ��JDBCΪ��t_user_xxx����һ��
 * ���У���������t_user_xxx��������ID��ֵ
 * 
 * CREATE SEQUENCE t_user_id_seq
 * START WITH 1000
 * INCREMENT BY 10
 */
public class JDBCDemo05 {
	
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
			Statement stmt
			= conn.createStatement();			
			String sql
			= "CREATE SEQUENCE t_user_id_seq "+
			  "START WITH 1000 "+
			  "INCREMENT BY 10 ";
			boolean result = stmt.execute(sql);
			System.out.println(result);
			System.out.println("�����Ѵ���");
		} catch (Exception e) {
			e.printStackTrace();
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
