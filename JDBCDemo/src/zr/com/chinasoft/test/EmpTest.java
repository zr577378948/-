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
	System.out.println("���Ա������");
	emp.setEmpno(1122);
	emp.setEname("lilil");
	emp.setJob("Cliker");
	emp.setHiredate(Date.valueOf("2017-05-05"));
	emp.setSal(1111);
	emp.setComm(100);
	emp.setDeptno(10);
	dao.addEmp(emp);
	
	System.out.println("ͨ��empnoɾ��Ա����Ϣ����");
	dao.deleteByEmpno(1122);
	
	System.out.println("ͨ��enameɾ��Ա����Ϣ����");
	dao.deleteByEname("����");
	
	System.out.println("ͨ��empno�޸�Ա����Ϣ����");
	emp.setEmpno(1000);
	emp.setEname("����");
	emp.setJob("Mouse");
	emp.setMgr(100);
	emp.setHiredate(Date.valueOf("1999-9-9"));
	emp.setSal(6666);
	emp.setComm(666);
	emp.setDeptno(10);
	dao.update(emp);
	
	System.out.println("��ѯ����Ա����Ϣ����");
	List<Emp> list = dao.QueryEmp();
	for(Emp empInfo:list){
		System.out.println(empInfo);
	}
	*/
	System.out.println("ͨ��ename��ѯԱ����Ϣ����");
	emp.setEname("����");
	List<Emp> list1 = dao.QueryEmpByEname(emp);
	for(Emp empInfo:list1){
		System.out.println(empInfo);
	}
	
	}
}
