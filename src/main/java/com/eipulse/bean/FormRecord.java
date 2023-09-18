package com.eipulse.bean;

import java.util.List;

import com.eipulse.action.approval.Overtime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="formrecord")
public class FormRecord {

	@Id
	@Column(name="FormId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int formId;
	@Column(name="TypeId")
	private int typeId;
	@Column(name="EmpId")
	private int empId;
	@Column(name="StartDate")
	private String startDate;
	@Column(name="EndDate")
	private String endDate;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "formRecord", cascade = CascadeType.ALL)
    private List<FormAuditEventLog> formAuditEventLog;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "formRecord", cascade = CascadeType.ALL)
    private List<FormEventLog> formEventLog;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TypeId", referencedColumnName = "typeId",insertable = false, updatable = false)
	private FormType formType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EmpId", referencedColumnName = "empid",insertable = false, updatable = false)
	private Employee employee;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "formRecord", cascade = CascadeType.ALL)
	private OverTime overTime;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "formRecord", cascade = CascadeType.ALL)
	private LeaveTable leaveTable;
	
	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<FormAuditEventLog> getFormAuditEventLog() {
		return formAuditEventLog;
	}

	public void setFormAuditEventLog(List<FormAuditEventLog> formAuditEventLog) {
		this.formAuditEventLog = formAuditEventLog;
	}

	public List<FormEventLog> getFormEventLog() {
		return formEventLog;
	}

	public void setFormEventLog(List<FormEventLog> formEventLog) {
		this.formEventLog = formEventLog;
	}

	public FormType getFormType() {
		return formType;
	}

	public void setFormType(FormType formType) {
		this.formType = formType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public OverTime getOverTime() {
		return overTime;
	}

	public void setOverTime(OverTime overTime) {
		this.overTime = overTime;
	}

	public LeaveTable getLeaveTable() {
		return leaveTable;
	}

	public void setLeaveTable(LeaveTable leaveTable) {
		this.leaveTable = leaveTable;
	}

	public FormRecord() {
	}

}
