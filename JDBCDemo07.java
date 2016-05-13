package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 需求：修改lc用户余额 加30000 
 * UPDATE T_USER 
 * SET account=account+30000
 * WHERE username='lc';
 */
public class JDBCDemo07 {
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
			= "UPDATE T_USER "+
			  "SET account=account+30000 "+
			  "WHERE username='lc' ";
			int n = stmt.executeUpdate(sql);
			if(n>0){
				System.out.println("更新成功！");
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
