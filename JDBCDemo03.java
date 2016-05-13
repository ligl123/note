package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 需求：关联查询
 * 列出职员的ename,sal,job,dname,loc
 * 
 * SELECT e.ename,e.sal,
 *    e.job,d.dname,d.loc
 * FROM emp e,dept d
 * WHERE e.deptno = d.deptno
 */
public class JDBCDemo03 {
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
			Statement stmt = conn.createStatement();
			/*
			 * 如果职员表中有没有部门的员工，
			 * 开发中通常使用外联接查询
			 * SELECT e.ename,e.sal,e.job,
			 *         d.dname,d.loc
			 * FROM emp e LEFT OUTER JOIN
			 *      dept d
			 * ON e.deptno=d.deptno   
			 */			
			String sql
			= "SELECT e.ename,e.sal, "+
			  "       e.job,d.dname,d.loc "+
			  "FROM emp e,dept d "+
			  "WHERE e.deptno = d.deptno";
			ResultSet rs
			= stmt.executeQuery(sql);
			while(rs.next()){
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				String job = rs.getString("job");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(
					ename+","+sal+","+job
					+","+dname+","+loc
				);
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
