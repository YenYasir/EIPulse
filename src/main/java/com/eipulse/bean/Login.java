package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login")
public class Login {
	@Id
	@Column(name="EmpId")
	private int empId;
	
	@Column(name="PassWord")
    private String passWord;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmpId", referencedColumnName = "empid")
    private Employee employee;
    
	public Login(String passWord, Employee employee) {
		super();
		this.passWord = passWord;
		this.employee = employee;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public Login() {
		
	}

}
