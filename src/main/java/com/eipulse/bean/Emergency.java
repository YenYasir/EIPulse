package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emergency")
public class Emergency {

	@Id
	@Column(name = "EmergencyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emergencyId;
	@Column(name = "EmergencyName")
	private String emergencyName;
	@Column(name = "EmergencyPhone")
	private String emergencyPhone;
	@Column(name = "EmergencyRelationship")
	private String emergencyRelationship;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EmpId", referencedColumnName = "empid")
	private Employee employee;

	public Emergency(String emergencyName, String emergencyPhone, String emergencyRelationship) {
		super();
		this.emergencyName = emergencyName;
		this.emergencyPhone = emergencyPhone;
		this.emergencyRelationship = emergencyRelationship;
	}

	public Emergency(int emergencyId, String emergencyName, String emergencyPhone, String emergencyRelationship) {
		super();
		this.emergencyId = emergencyId;
		this.emergencyName = emergencyName;
		this.emergencyPhone = emergencyPhone;
		this.emergencyRelationship = emergencyRelationship;
	}

	public Emergency(String emergencyName, String emergencyPhone, String emergencyRelationship, Employee employee) {
		super();
		this.emergencyName = emergencyName;
		this.emergencyPhone = emergencyPhone;
		this.emergencyRelationship = emergencyRelationship;
		this.employee = employee;
	}

	public Emergency(int emergencyId, String emergencyName, String emergencyPhone, String emergencyRelationship,
			Employee employee) {
		super();
		this.emergencyId = emergencyId;
		this.emergencyName = emergencyName;
		this.emergencyPhone = emergencyPhone;
		this.emergencyRelationship = emergencyRelationship;
		this.employee = employee;
	}

	public int getEmergencyId() {
		return emergencyId;
	}

	public void setEmergencyId(int emergencyId) {
		this.emergencyId = emergencyId;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergencyPhone() {
		return emergencyPhone;
	}

	public void setEmergencyPhone(String emergencyPhone) {
		this.emergencyPhone = emergencyPhone;
	}

	public String getEmergencyRelationship() {
		return emergencyRelationship;
	}

	public void setEmergencyRelationship(String emergencyRelationship) {
		this.emergencyRelationship = emergencyRelationship;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Emergency() {
	}

}
