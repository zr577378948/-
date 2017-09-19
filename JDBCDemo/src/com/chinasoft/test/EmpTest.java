package com.chinasoft.test;

import java.sql.Date;
import java.util.List;

import com.chiansoft.dao.impl.EmpDaoImpl;
import com.chiansoft.vo.Emp;
import com.chinasoft.dao.EmpDao;
public class EmpTest {
	
public static void main(String[] args) {
	EmpDao dao = new EmpDaoImpl();
	Emp emp = new Emp();
	
	System.out.println("���Ա������");
	emp.setEmpno(1114);
	emp.setEname("lilili");
	emp.setJob("Cliker");
	emp.setHiredate(Date.valueOf("2017-05-05"));
	emp.setSal(1111);
	emp.setComm(100);
	emp.setDeptno(10);
	dao.addEmp(emp);
	
	System.out.println("ͨ��empnoɾ��Ա����Ϣ����");
	dao.deleteByEmpno(1111);
	
	System.out.println("ͨ��enameɾ��Ա����Ϣ����");
	dao.deleteByEname("lilili");
	
	System.out.println("ͨ��empno�޸�Ա����Ϣ����");
	emp.setEname("������");
	emp.setJob("Mouse");
	emp.setHiredate(Date.valueOf("1999-9-9"));
	emp.setSal(6666);
	emp.setComm(66);
	emp.setDeptno(10);
	dao.update(emp,1000);
	
	System.out.println("��ѯ����Ա����Ϣ����");
	List<Emp> list = dao.QueryEmp();
	for(Emp empInfo:list){
		System.out.println(empInfo);
	}
	
	System.out.println("ͨ��ename��ѯԱ����Ϣ����");
	List<Emp> list1 = dao.QueryEmpByEname("������");
	for(Emp empInfo:list1){
		System.out.println(empInfo);
	}
	}
}
