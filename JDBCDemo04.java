package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ͨ��JDBC������
 * ����DDL���
 * t_user
 * id NUMBER(4)
 * username VARCHAR2(20)
 * password VARCAHR2(16)
 * email VARCHAR2(30)
 * account NUMBER(8)
 */
public class JDBCDemo04 {
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
			/*
			 * CREATE TABLE t_user(
			 * 	id NUMBER(4),
			 *  username VARCHAR2(20),
			 *  password VARCHAR2(16),
			 *  email VARCHAR2(30),
			 *  account NUMBER(8)
			 * )
			 */
			String sql
			= "CREATE TABLE t_user("+
			  "id NUMBER(4), "+
			  "username VARCHAR2(20), "+
			  "password VARCHAR2(16), "+
			  "email VARCHAR2(30), "+
			  "account NUMBER(8) "+
			  ")";
			/*
			 * boolean execute(String sql);
			 * ͨ��ʹ�ø÷�������DDL���
			 * ���Է���DML,DQL,DDL
			 * �������true����ʾ���͵�sql���
			 * �н������
			 * �������false,û�н������
			 * ���SQL���ִ��ʧ�ܣ����׳��쳣
			 */
			boolean result = stmt.execute(sql);
			System.out.println(result);
			System.out.println("���Ѵ���");
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
