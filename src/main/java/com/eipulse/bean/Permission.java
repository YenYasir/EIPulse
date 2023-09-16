package com.eipulse.bean;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission {
	@Id
	@Column(name = "PermissionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int permissionId;
	@Column(name = "Grade")
	private String grade;
	@Column(name = "Info")
	private String info;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "employeepermission",
//        joinColumns = {@JoinColumn(name = "permissionid")},
//        inverseJoinColumns = {@JoinColumn(name = "empid")})
//    private List<Employee> employees;
//	@OneToMany(fetch = FetchType.LAZY)
//	private List<EmployeePermission> employeePermission;

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	public Permission() {
	}
}
