package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeeinfo")
public class EmployeeInfo {
	
	
	@Column(name = "DeptId")
	private int deptId;
	@Column(name = "TitleId")
	private int titleId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DeptId", referencedColumnName = "deptid",insertable = false, updatable = false)
	private Dept dept;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TitleId", referencedColumnName = "titleid",insertable = false, updatable = false)
	private Title title;
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EmpId", referencedColumnName = "empid")
	private Employee employee;

	public EmployeeInfo(int deptId, int titleId, Employee employee) {
		super();
		this.deptId = deptId;
		this.titleId = titleId;
		this.employee = employee;
	}

	public EmployeeInfo(int deptId, int titleId) {
		super();
		this.deptId = deptId;
		this.titleId = titleId;
	}

	public EmployeeInfo(int deptId, int titleId, Dept dept, Title title, Employee employee) {
		super();
		this.deptId = deptId;
		this.titleId = titleId;
		this.dept = dept;
		this.title = title;
		this.employee = employee;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeInfo() {
	}

}
