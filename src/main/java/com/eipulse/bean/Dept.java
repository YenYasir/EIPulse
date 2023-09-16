package com.eipulse.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Dept")
public class Dept {
	@Id
	@Column(name = "DeptId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	@Column(name = "DeptName")
	private String deptName;
	@Column(name = "DeptOffice")
	private String deptOffice;

	public Dept(String deptName, String deptOffice) {
		super();
		this.deptName = deptName;
		this.deptOffice = deptOffice;
	}

	public Dept(int deptId, String deptName, String deptOffice) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptOffice = deptOffice;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptOffice() {
		return deptOffice;
	}

	public void setDeptOffice(String deptOffice) {
		this.deptOffice = deptOffice;
	}

	public Dept() {
	}

}
