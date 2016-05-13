package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC java与数据库的互联
 * JDBC是由java提供的一套接口，接口中规定了
 * 连接数据库的标准流程以及涉及的一系列方法
 * 功能定义，没有具体的实现。
 * 不同的数据库厂商负责提供一套实现类，用于
 * 操作他们的数据库管理系统
 */
public class JDBCDemo01 {
	/*
	 * 1:加载驱动
	 *   Class.forName("XXX");
	 *   不同的数据库,类名不同
	 * 2:建立连接
	 *   Connection
	 *   DriverManager.getConnection();
	 *   其中需要三个参数
	 *   1、数据库的连接地址 url
	 *   2、数据库的用户名
	 *   3、数据库密码
	 * 3：创建执行SQL语句对象
	 *   Statement
	 *   connection.createStatement();
	 * 4:发送并执行SQL语句
	 *   insert,update,delete  DML
	 *   select                DQL
	 *   create....            DDL
	 *   executeQuery();DQL
	 *   executeUpdate();DML
	 *   execute();DDL
	 * 5:如果执行查询，会得到结果集
	 *   ResultSet
	 *   处理结果集，捕获数据库中的数据
	 * 6:关闭连接
	 */
	public static void main(String[] args) {
		
		Connection conn = null;
		try {
		  //1、
			Class.forName
			("oracle.jdbc.driver.OracleDriver");
			//2、  java.sql
			conn= DriverManager.getConnection(
			"jdbc:oracle:thin:@192.168.201.206:1521:orcl",
			"fancq",
			"open123"
			);
			//需求：查询并显示所有员工信息
			//3、
			Statement stmt = conn.createStatement();
			
			//4、发送SQL语句
			String sql
			= "SELECT empno,ename,sal,job,deptno "+
				"FROM emp";
			/*
			 * ResultSet executeQuery(String sql);
			 * 专门用来发送SELECT语句的方法。
			 * 返回值为执行该查询语句后查询的结果集
			 */
			ResultSet rs =
			stmt.executeQuery(sql);
			//5、
			/*
			 * 1)、boolean next();
			 * 让当前指针表示下一条记录，如果存在
			 * 数据，返回true,如果已经没有记录，
			 * 返回false
			 * 2)、 获取给定字段的值
			 * 提供一组getXxx()方法。
			 * getInt("empno");
			 * getString("ename");
			 * getDouble("sal");.....
			 * 
			 * getInt(1);
			 */
			while(rs.next()){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				System.out.println(
						empno+","+ename+","+
						sal+","+job+","+deptno
				);
				/*
				 * int empno = rs.getInt(1);
				   String ename = rs.getString(2);
					 double sal = rs.getDouble(3);
					 String job = rs.getString(4);
					 int deptno = rs.getInt(5);
				 */
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
