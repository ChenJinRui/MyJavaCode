package com.soul.demo;

import java.util.Date;

import com.soul.demo.bean.Employee;
import com.soul.demo.bean.Manager;

public class Inheritance {

	public static void main(String[] args) {
		
		
		// ArrayList<Manager> managers;
		Manager[] managers = new Manager[3];
		Employee[] employees = new Employee[3];

		managers[0] = new Manager("ZhangSan", 20000);
		managers[1] = new Manager("LiSan", 15000, 8000);
		managers[2] = new Manager("WangSan", 18000, 6000);
		managers[0].setBonus(5000);

		employees = managers;
		System.out.println(employees[0].toString());

		Employee aEmployee = new Employee();
		Manager aManager;
		try {
			// 强制转换可能出错 父类 Employee 一般情况都没有Manager 新增的元素
			aManager = (Manager) aEmployee;
			
		} catch (ClassCastException e) {
			// TODO: handle exception
		}
		// 强制转换 确认父类 Employee 中包含有Manager 的元素才
		if(employees[1] instanceof Manager){//如果检查是否能够成功转换 但是需要尽量减少这种使用和强制转换
			aManager = (Manager) employees[1];
			System.out.println(aManager.toString());
		}
		
		
		Employee iEmployee;
		Manager iManager = new Manager();
		// 子类转 父类没有问题 
		iEmployee = iManager;
		System.out.println(iEmployee.toString());
		
		
	}
}
