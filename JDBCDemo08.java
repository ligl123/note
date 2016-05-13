package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用JDBC实现模拟转账功能
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
			//设置JDBC连接对象的自动提交方式
			//为非自动提交
			conn.setAutoCommit(false);
			
			Statement stmt
			= conn.createStatement();
			//用户lc转账给JACK
			String sql1 
			= "UPDATE t_user " +
			  "SET account=account-5000 " +
			  "WHERE username='lc'";
			int n1 = stmt.executeUpdate(sql1);
			if(n1>0){
				System.out.println("转出成功！");
			}else{
				System.out.println("转出失败！");
				return;
			}
			String sql2
			= "UPDATE t_user " +
			  "SET account=account+5000 " +
			  "WHERE username='JAC'";
			int n2 = stmt.executeUpdate(sql2);
			if(n2>0){
				System.out.println("转入成功！");
				//提交事务
				conn.commit();
				conn.setAutoCommit(true);
			}else{
				System.out.println("转入失败！");
				//回滚事务
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
