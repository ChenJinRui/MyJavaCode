package com.soul.demo.bean;

import java.util.Random;

/**
 * @version bean demo 2018年6月5日17:33:29
 * @since V 0.1
 * @author Soul
 *
 */
/**
 * 依赖 Use Employee  
 * 继承 Is Employee
 * 聚合 Has Employee
 */

public class Employee {

	private String name;
	private int id;
	private double salary;
	private static int nextId = 0;

	public Employee() {
//		name = "";
//		salary = 0;
		//调用Employee(String name, double salary)构造器
		this("",0);
		
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	 
	static{
		Random initId = new Random();
		nextId = initId.nextInt(1000);//0~999的值
	}
	/*
	 * 初始化块（initialization block）
	 * 首先运行初始化块，然后才运行构造器的主体部分
	 * 放在域值定义后面
	 */
	{
		id = nextId;
		nextId++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Id 不容许更改所以没有set
	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(this == obj){
			return true;
		}
		if(getClass() == obj.getClass()){
			return true;
		}
		if(obj instanceof Employee){
			Employee eObj = (Employee) obj;
			return id == eObj.getId();
		}else{
			return false;
		}
		
	}

	@Override
	public String toString() {
		return getClass().getName()+" [name=" + name + ", id=" + id + ", salary=" + salary
				+ "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new Integer(id).hashCode();
	}
}
