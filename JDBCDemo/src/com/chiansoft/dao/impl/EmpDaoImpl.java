package com.chiansoft.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chiansoft.dbUtils.DBUtils;
import com.chiansoft.vo.Emp;
import com.chinasoft.dao.EmpDao;

public class EmpDaoImpl implements EmpDao{

//	数据库用户名
	String user = "SCOTT";
//	数据库密码
	String password = "TIGER";
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	int count = 0;
	List<Emp> list = new ArrayList<Emp>();
	
	/**
	 * 向表中增加员工信息
	 */
	@Override
	public boolean addEmp(Emp emp) {
		try {
//			1.加载驱动
//			2.获取连接对象
			conn = DBUtils.getConnection(user, password);
//			3.编写sql语句
			String sql = "insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) "
					+ "values ("+emp.getEmpno()+",'"+emp.getEname()+"','"+emp.getJob()+"',"
					+ ""+emp.getMgr()+",to_date('"+String.valueOf(emp.getHiredate())+"','YYYY-MM-DD'),"
					+ ""+emp.getSal()+","+emp.getComm()+","+emp.getDeptno()+")";
//			4.创建Statement对象
			stat = conn.createStatement();
//			5.执行sql语句
			count = stat.executeUpdate(sql);
			System.out.println("成功插入信息"+count+"条");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
//		6.关闭连接
		DBUtils.close(null, stat, conn);
		}
		return count==0?false:true;
	}

	/**
	 * 通过empno删除员工信息
	 */
	@Override
	public boolean deleteByEmpno(int empno) {
		try {
			conn = DBUtils.getConnection(user, password);
			String sql = "delete from emp where empno="+empno+"";
			stat = conn.createStatement();
			count = stat.executeUpdate(sql);
			System.out.println("成功删除记录"+count+"条");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(null, stat, conn);
		}
		return count==0?false:true;
	}
	
	/**
	 * 通过ename删除员工信息
	 */
	@Override
	public boolean deleteByEname(String ename) {
		try {
			conn = DBUtils.getConnection(user, password);
			String sql = "delete from emp where ename='"+ename+"'";
			stat = conn.createStatement();
			count = stat.executeUpdate(sql);
			System.out.println("成功删除记录"+count+"条");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(null, stat, conn);
		}
		return count==0?false:true;
	}

	/**
	 * 通过empno修改员工信息
	 */
	@Override
	public boolean update(Emp emp,int empno) {
		try {
			conn = DBUtils.getConnection(user, password);
			String sql = "update emp set ename='"+emp.getEname()+"',job='"+emp.getJob()+"',"
					+ "mgr="+emp.getMgr()+",hiredate=to_date('"+String.valueOf(emp.getHiredate())+"','YYYY-MM-DD'),"
							+ "sal="+emp.getSal()+",comm="+emp.getComm()+",deptno="+emp.getDeptno()+" "
									+ "where empno = "+empno+"";
			stat = conn.createStatement();
			count = stat.executeUpdate(sql);
			System.out.println("成功修改记录"+count+"条");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(null, stat, conn);
		}
		return count==0?false:true;
	}

	/**
	 * 查询所有员工信息
	 */
	@Override
	public List<Emp> QueryEmp() {
		try {
			conn = DBUtils.getConnection(user, password);
			String sql = "select * from emp";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				Date hiredate = rs.getDate(5);
				double sal = rs.getDouble(6);
				double comm = rs.getDouble(7);
				int deptno = rs.getInt(8);
				Emp emp = new Emp(empno,ename, job, mgr, hiredate, sal, comm, deptno);
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(rs, stat, conn);
		}
		return list;
	}

	/**
	 * 通过ename查询员工信息
	 */
	@Override
	public List<Emp> QueryEmpByEname(String ename) {
		try {
			conn = DBUtils.getConnection(user, password);
			String sql = "select * from emp where ename='"+ename+"'";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
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
		}finally{
			DBUtils.close(rs, stat, conn);
		}
		return list;
	}

}
