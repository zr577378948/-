package zr.com.chiansoft.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zr.com.chiansoft.vo.Emp;

public class DBUtils {
	static String user = "SCOTT";
	static String password = "TIGER";
	static Connection conn = null;
	static PreparedStatement ps = null;
	/**
	 * ��ȡ����
	 */
	public static Connection getConnection(String user,String password){
		Connection conn = null;
		try {
//			1.��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2.��ȡ���Ӷ���
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection
					(url,"SCOTT","TIGER");
//			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	} 
	/**
	 * �������
	 */
	public static boolean update(String sql,Object obj[]){
		conn = getConnection(user, password);
		int count = 0;
		try {
//			Ԥ����sql
			ps = conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
//				��sql���ռλ����ֵ
				ps.setObject(i+1, obj[i]);
			}
			count = ps.executeUpdate();
			System.out.println("���ݱ����"+count+"��");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(null, ps, conn);
		}
		return count==0?false:true;
	}
	/**
	 * ��ѯȫ�����
	 */
	public static List<Emp> QueryAll(String sql,ResultSet rs){
		conn = getConnection(user, password);
		try {
//			Ԥ����sql
			ps=conn.prepareStatement(sql);
//			ִ��sql
			rs = ps.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List<Emp> list = new ArrayList<>();
		try {
			//����rs
			while(rs.next()){
			int empno = rs.getInt(1);
			String ename1 = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hiredate = rs.getDate(5);
			double sal = rs.getDouble(6);
			double comm = rs.getDouble(7);
			int deptno = rs.getInt(8);
			Emp emp = new Emp(empno,ename1, job, mgr, hiredate, sal, comm, deptno);
			list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 *����������ѯ���
	 */
	public static List<Emp> Query(String sql,ResultSet rs,Object obj[]){
		conn = getConnection(user, password);
		try {
//			Ԥ����sql
			ps=conn.prepareStatement(sql);
//			��sql���ռλ����ֵ
			ps.setObject(1, obj[0]);
//			ִ��sql
			rs = ps.executeQuery();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List<Emp> list = new ArrayList<>();
		try {
//			����rs
			while(rs.next()){
			int empno = rs.getInt(1);
			String ename1 = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			Date hiredate = rs.getDate(5);
			double sal = rs.getDouble(6);
			double comm = rs.getDouble(7);
			int deptno = rs.getInt(8);
			Emp emp = new Emp(empno,ename1, job, mgr, hiredate, sal, comm, deptno);
			list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * �ر�����
	 */
	public static void close(ResultSet rs,Statement stat,Connection conn){
		try {
//			6.�ر�����
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
