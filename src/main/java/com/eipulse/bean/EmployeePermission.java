package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeePermission")
public class EmployeePermission {
	@Id
	@Column(name = "EmpId")
	private int empId;
	@Id
	@Column(name = "PermissionId")
	private int permissionId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EmpId", referencedColumnName = "empid",insertable = false, updatable = false)
	private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PermissionId", referencedColumnName = "permissionId",insertable = false, updatable = false)
	private Permission permission;
	
	
	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public int getPermissionId() {
		return permissionId;
	}


	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Permission getPermission() {
		return permission;
	}


	public void setPermission(Permission permission) {
		this.permission = permission;
	}


	public EmployeePermission() {
	}

}
