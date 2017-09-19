package zr.com.chiansoft.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zr.com.chiansoft.dbUtils.DBUtils;
import zr.com.chiansoft.vo.Emp;
import zr.com.chinasoft.dao.EmpDao;

public class EmpDaoImpl implements EmpDao{

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	boolean re = false;
	int count = 0;
	List<Emp> list = new ArrayList<Emp>();
	
	/**
	 * ���������Ա����Ϣ
	 */
	@Override
	public boolean addEmp(Emp emp) {
//			1.��������
//			2.��ȡ���Ӷ���
//			3.��дsql���
			String sql = "insert into emp (empno,ename,job,mgr,hiredate,sal,comm,deptno) "
					+ "values (?,?,?,?,?,?,?,?)";
			Object obj[] = {emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),
						emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno()}; 
			DBUtils.update(sql, obj);
//		6.�ر�����
		DBUtils.close(null, ps, conn);
		return re;
	}

	/**
	 * ͨ��empnoɾ��Ա����Ϣ
	 */
	@Override
	public boolean deleteByEmpno(int empno) {
		String sql = "delete from emp where empno=?";
		Object obj[] = {empno};
		re = DBUtils.update(sql, obj);
		DBUtils.close(null, ps, conn);
		return re;
	}
	
	/**
	 * ͨ��enameɾ��Ա����Ϣ
	 */
	@Override
	public boolean deleteByEname(String ename) {
			String sql = "delete from emp where ename=?";
			Object obj[] = {ename};
			re = DBUtils.update(sql, obj);
			DBUtils.close(null, ps, conn);
		return re;
	}

	/**
	 * ͨ��empno�޸�Ա����Ϣ
	 */
	@Override
	public boolean update(Emp emp) {
		String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
		Object obj[] = {emp.getEname(),emp.getJob(),emp.getMgr(),
					emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()}; 
		re = DBUtils.update(sql, obj);
		DBUtils.close(null, ps, conn);
		return re;
	}

	/**
	 * ��ѯ����Ա����Ϣ
	 */
	@Override
	public List<Emp> QueryEmp() {
		String sql = "select * from emp";
		list = DBUtils.QueryAll(sql,rs);
		DBUtils.close(rs, ps, conn);
		return list;
	}

	/**
	 * ͨ��ename��ѯԱ����Ϣ
	 */
	@Override
	public List<Emp> QueryEmpByEname(Emp emp) {
		String sql = "select * from emp where ename=?";
		Object []obj = {emp.getEname()};
		list = DBUtils.Query(sql,rs,obj);
		DBUtils.close(rs, ps, conn);
		return list;
	}


}
