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
	
	System.out.println("添加员工测试");
	emp.setEmpno(1114);
	emp.setEname("lilili");
	emp.setJob("Cliker");
	emp.setHiredate(Date.valueOf("2017-05-05"));
	emp.setSal(1111);
	emp.setComm(100);
	emp.setDeptno(10);
	dao.addEmp(emp);
	
	System.out.println("通过empno删除员工信息测试");
	dao.deleteByEmpno(1111);
	
	System.out.println("通过ename删除员工信息测试");
	dao.deleteByEname("lilili");
	
	System.out.println("通过empno修改员工信息测试");
	emp.setEname("韩跑跑");
	emp.setJob("Mouse");
	emp.setHiredate(Date.valueOf("1999-9-9"));
	emp.setSal(6666);
	emp.setComm(66);
	emp.setDeptno(10);
	dao.update(emp,1000);
	
	System.out.println("查询所有员工信息测试");
	List<Emp> list = dao.QueryEmp();
	for(Emp empInfo:list){
		System.out.println(empInfo);
	}
	
	System.out.println("通过ename查询员工信息测试");
	List<Emp> list1 = dao.QueryEmpByEname("韩跑跑");
	for(Emp empInfo:list1){
		System.out.println(empInfo);
	}
	}
}
