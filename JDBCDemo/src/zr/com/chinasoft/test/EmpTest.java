package zr.com.chinasoft.test;

import java.sql.Date;
import java.util.List;

import zr.com.chiansoft.dao.impl.EmpDaoImpl;
import zr.com.chiansoft.vo.Emp;
import zr.com.chinasoft.dao.EmpDao;
public class EmpTest {
	
public static void main(String[] args) {
	EmpDao dao = new EmpDaoImpl();
	Emp emp = new Emp();
/*	
	System.out.println("添加员工测试");
	emp.setEmpno(1122);
	emp.setEname("lilil");
	emp.setJob("Cliker");
	emp.setHiredate(Date.valueOf("2017-05-05"));
	emp.setSal(1111);
	emp.setComm(100);
	emp.setDeptno(10);
	dao.addEmp(emp);
	
	System.out.println("通过empno删除员工信息测试");
	dao.deleteByEmpno(1122);
	
	System.out.println("通过ename删除员工信息测试");
	dao.deleteByEname("狼狼");
	
	System.out.println("通过empno修改员工信息测试");
	emp.setEmpno(1000);
	emp.setEname("泡泡");
	emp.setJob("Mouse");
	emp.setMgr(100);
	emp.setHiredate(Date.valueOf("1999-9-9"));
	emp.setSal(6666);
	emp.setComm(666);
	emp.setDeptno(10);
	dao.update(emp);
	
	System.out.println("查询所有员工信息测试");
	List<Emp> list = dao.QueryEmp();
	for(Emp empInfo:list){
		System.out.println(empInfo);
	}
	*/
	System.out.println("通过ename查询员工信息测试");
	emp.setEname("泡泡");
	List<Emp> list1 = dao.QueryEmpByEname(emp);
	for(Emp empInfo:list1){
		System.out.println(empInfo);
	}
	
	}
}
