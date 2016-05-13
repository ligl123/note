package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * �����û�����ÿҳ��ʾ���������Լ�
 * ҳ������ʾ��Ӧ������
 * �г�emp����Ա����ţ�Ա������нˮ��ְλ
 */
public class JDBCDemo02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ÿҳ��ʾ��������");
		int pageSize
		= Integer.parseInt(sc.nextLine());
		System.out.println("������ҳ����");
		int page
		= Integer.parseInt(sc.nextLine());
		System.out.println("�������£�");
		int start = (page-1)*pageSize+1;
		int end = page*pageSize;
		
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
			 * Oracle��ҳsql
			 * rownum
			 * �Ӳ�ѯ
			 * SELECT * FROM
			 * (SELECT ROWNUM rn,t.*
			 * (SELECT empno,ename,sal,job
			 * FROM emp) t)
			 * WHERE rn between 3 and 5
			 */
			String sql
			= "SELECT * FROM "+
			  "(SELECT ROWNUM rn,t.* FROM "+
				"(SELECT empno,ename,sal,job "+
			  "FROM emp) t) "+
				"WHERE rn BETWEEN "+start+" AND "+end;
			ResultSet rs = 
			stmt.executeQuery(sql);
			while(rs.next()){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				double sal = rs.getDouble("sal");
				String job = rs.getString("job");
				System.out.println(
						empno+","+ename+","+
						sal+","+job
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
