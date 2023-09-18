package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "NotificationField")
public class NotificationField {
	@Id
	@Column(name = "NotificationId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notificationId;
	@Column(name = "EmpId")
	private int empId;
	@Column(name = "Message")
	private String message;
	@Column(name = "Link")
	private String link;
	@Column(name = "CreatedAt")
	private String createdAt;
	@Column(name = "ReadAt")
	private String readAt;
	@ManyToOne
	@JoinColumn(name = "EmpId", referencedColumnName = "empId", insertable = false, updatable = false)
	private Employee employee;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getReadAt() {
		return readAt;
	}

	public void setReadAt(String readAt) {
		this.readAt = readAt;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public NotificationField() {
	}

}
