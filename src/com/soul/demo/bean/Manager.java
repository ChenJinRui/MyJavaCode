package com.soul.demo.bean;

public class Manager extends Employee{
	
	private double bonus;
	
	public Manager() {
		super();
		bonus = 0;
	}
	public Manager(String name, double salary) {
		super(name,salary);
		bonus = 0;
	}
	
	public Manager(String name, double salary,double bonus) {
		super(name,salary);
		this.bonus = bonus;
	}



	/**
	 * 重写工资结构
	 */
	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		//(getSalary() + bonus ) = won't work  
		double wage = super.getSalary() + bonus; 
		return wage;
	}



	public double getBonus() {
		return bonus;
	}



	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " [name=" + super.getName() + ", id=" + super.getId() 
				+ ", salary=" + getSalary()+ "]";
	}


}
