package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC java�����ݿ�Ļ���
 * JDBC����java�ṩ��һ�׽ӿڣ��ӿ��й涨��
 * �������ݿ�ı�׼�����Լ��漰��һϵ�з���
 * ���ܶ��壬û�о����ʵ�֡�
 * ��ͬ�����ݿ⳧�̸����ṩһ��ʵ���࣬����
 * �������ǵ����ݿ����ϵͳ
 */
public class JDBCDemo01 {
	/*
	 * 1:��������
	 *   Class.forName("XXX");
	 *   ��ͬ�����ݿ�,������ͬ
	 * 2:��������
	 *   Connection
	 *   DriverManager.getConnection();
	 *   ������Ҫ��������
	 *   1�����ݿ�����ӵ�ַ url
	 *   2�����ݿ���û���
	 *   3�����ݿ�����
	 * 3������ִ��SQL������
	 *   Statement
	 *   connection.createStatement();
	 * 4:���Ͳ�ִ��SQL���
	 *   insert,update,delete  DML
	 *   select                DQL
	 *   create....            DDL
	 *   executeQuery();DQL
	 *   executeUpdate();DML
	 *   execute();DDL
	 * 5:���ִ�в�ѯ����õ������
	 *   ResultSet
	 *   �����������������ݿ��е�����
	 * 6:�ر�����
	 */
	public static void main(String[] args) {
		
		Connection conn = null;
		try {
		  //1��
			Class.forName
			("oracle.jdbc.driver.OracleDriver");
			//2��  java.sql
			conn= DriverManager.getConnection(
			"jdbc:oracle:thin:@192.168.201.206:1521:orcl",
			"fancq",
			"open123"
			);
			//���󣺲�ѯ����ʾ����Ա����Ϣ
			//3��
			Statement stmt = conn.createStatement();
			
			//4������SQL���
			String sql
			= "SELECT empno,ename,sal,job,deptno "+
				"FROM emp";
			/*
			 * ResultSet executeQuery(String sql);
			 * ר����������SELECT���ķ�����
			 * ����ֵΪִ�иò�ѯ�����ѯ�Ľ����
			 */
			ResultSet rs =
			stmt.executeQuery(sql);
			//5��
			/*
			 * 1)��boolean next();
			 * �õ�ǰָ���ʾ��һ����¼���������
			 * ���ݣ�����true,����Ѿ�û�м�¼��
			 * ����false
			 * 2)�� ��ȡ�����ֶε�ֵ
			 * �ṩһ��getXxx()������
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
