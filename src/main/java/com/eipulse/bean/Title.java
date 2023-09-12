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
@Table(name = "Title")
public class Title {
	@Id
    @Column(name="TitleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int titleId;
    @Column(name="TitleName")
    private String titleName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "title", cascade = CascadeType.ALL)
	private List<EmployeeInfo> employeeInfo;
    
	public Title(int titleId, String titleName, List<EmployeeInfo> employeeInfo) {
		super();
		this.titleId = titleId;
		this.titleName = titleName;
		this.employeeInfo = employeeInfo;
	}

	public Title(String titleName, List<EmployeeInfo> employeeInfo) {
		super();
		this.titleName = titleName;
		this.employeeInfo = employeeInfo;
	}

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public List<EmployeeInfo> getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(List<EmployeeInfo> employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public Title() {
	}

}
