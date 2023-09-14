package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

    @Column(name="Phone")
    private String phone;
    @Column(name="Tel")
    private String tel;
    @Column(name="Address")
    private String address;
    @Column(name="Email")
    private String email;
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmpId", referencedColumnName = "empid")
	private Employee employee;

	public Contact(Employee employee,String phone, String tel, String address, String email) {
		super();
		this.phone = phone;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.employee = employee;
	}

	public Contact(String phone, String tel, String address, String email) {
		super();
		this.phone = phone;
		this.tel = tel;
		this.address = address;
		this.email = email;
	}

	public Contact(String phone, String tel, String address, String email, Employee employee) {
		super();
		this.phone = phone;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.employee = employee;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Contact() {
	}

}
