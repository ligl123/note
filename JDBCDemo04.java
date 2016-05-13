package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 通过JDBC创建表
 * 发送DDL语句
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
			 * 通常使用该方法发送DDL语句
			 * 可以发送DML,DQL,DDL
			 * 如果返回true，表示发送的sql语句
			 * 有结果集，
			 * 如果返回false,没有结果集。
			 * 如果SQL语句执行失败，会抛出异常
			 */
			boolean result = stmt.execute(sql);
			System.out.println(result);
			System.out.println("表已创建");
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
