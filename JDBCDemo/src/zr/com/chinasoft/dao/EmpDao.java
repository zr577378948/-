package zr.com.chinasoft.dao;

import java.util.List;

import zr.com.chiansoft.vo.Emp;

public interface EmpDao {
	/**
	 * 作者：_借东西的小人
	 * 向表中增加员工信息
	 */
	boolean addEmp(Emp emp);
	/**
	 * 通过empno删除员工信息
	 */
	boolean deleteByEmpno(int empno);
	/**
	 * 通过ename删除员工信息
	 */
	boolean deleteByEname(String ename);
	/**
	 * 通过empno修改员工信息
	 */
	boolean update(Emp emp);
	/**
	 * 查询所有员工信息
	 */
	List<Emp> QueryEmp();
	/**
	 * 通过ename查询员工信息
	 */
	List<Emp> QueryEmpByEname(Emp emp);

}
