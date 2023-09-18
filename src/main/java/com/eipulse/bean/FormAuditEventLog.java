package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "formauditeventlog")
public class FormAuditEventLog {

	@Id
	@Column(name = "EventId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	@Column(name = "Auditor")
	private int auditor;
	@Column(name = "FormStatus")
	private String formStatus;
	@Column(name = "Message")
	private String message;
	@Column(name="EndDate")
	private String endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FormId", referencedColumnName = "formId")
	private FormRecord formRecord;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Auditor", referencedColumnName = "empId",insertable = false, updatable = false)
	private Employee employee;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getAuditor() {
		return auditor;
	}

	public void setAuditor(int auditor) {
		this.auditor = auditor;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FormRecord getFormRecord() {
		return formRecord;
	}

	public void setFormRecord(FormRecord formRecord) {
		this.formRecord = formRecord;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public FormAuditEventLog() {
	}

}
