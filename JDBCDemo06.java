package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����ʹ��JDBCִ��DML���
 * ��t_user�������һ����¼
 */
public class JDBCDemo06 {
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
			= "INSERT INTO t_user(id,username, "+
			  "            password,email,account) "+
			  "VALUES" +
			  "     (t_user_id_seq.NEXTVAL,'JACK' " +
			  "     ,'123456','JACK@tedu.cn',30000)";
			/*
			 * int executeUpdate(String sql);
			 * �÷�������ִ��DML��䣬����ֵΪִ�к�
			 * Ӱ�����ݿ�������ݵ�����
			 * JDBCĬ���Զ��ύ��������ִ��insert
			 * ��䣬���ݾͻ����õı��浽����
			 */
			int n = stmt.executeUpdate(sql);
			if(n>0){
				System.out.println("����ɹ���");
			}
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
