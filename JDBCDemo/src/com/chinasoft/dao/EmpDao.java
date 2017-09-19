package com.chinasoft.dao;

import java.util.List;

import com.chiansoft.vo.Emp;

public interface EmpDao {
	/**
	 * ���ߣ�_�趫����С��
	 * ���������Ա����Ϣ
	 */
	boolean addEmp(Emp emp);
	/**
	 * ͨ��empnoɾ��Ա����Ϣ
	 */
	boolean deleteByEmpno(int empno);
	/**
	 * ͨ��enameɾ��Ա����Ϣ
	 */
	boolean deleteByEname(String ename);
	/**
	 * ͨ��empno�޸�Ա����Ϣ
	 */
	boolean update(Emp emp,int empno);
	/**
	 * ��ѯ����Ա����Ϣ
	 */
	List<Emp> QueryEmp();
	/**
	 * ͨ��ename��ѯԱ����Ϣ
	 */
	List<Emp> QueryEmpByEname(String ename);

}
