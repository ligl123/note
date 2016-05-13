package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 需求：使用JDBC执行DML语句
 * 向t_user表中添加一条记录
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
			 * 该方法用来执行DML语句，返回值为执行后
			 * 影响数据库表中数据的条数
			 * JDBC默认自动提交事务。所以执行insert
			 * 语句，数据就会永久的保存到表中
			 */
			int n = stmt.executeUpdate(sql);
			if(n>0){
				System.out.println("保存成功！");
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
