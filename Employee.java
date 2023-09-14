package com.eipulse.bean;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name="EmpId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column(name="IdNumber")
    private String idNumber;
    @Column(name="EmpName")
    private String empName;
    @Column(name="Gender")
    private String gender;
    @Column(name="JobAge")
    private double JobAge;
    @Column(name="Birth")
    private String birth;
    @Column(name="Photo")
    private byte[] photo;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        name = "EmployeePermission",
//        joinColumns = {@JoinColumn(name = "EmpId")},
//        inverseJoinColumns = {@JoinColumn(name = "PermissionId")})
//    private List<Permission> permissions;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeePermission> permissions;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "employee", cascade = CascadeType.ALL)
	private Login login;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Emergency> emergencies;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeInfo employeeInfo;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "employee", cascade = CascadeType.ALL)
	private Contact contact;

		public Employee(int empId, String idNumber, String empName, String gender, String birth, byte[] photo) {
		super();
		this.empId = empId;
		this.idNumber = idNumber;
		this.empName = empName;
		this.gender = gender;
		this.birth = birth;
		this.photo = photo;
	}

		public Employee(String idNumber, String empName, String gender, String birth, byte[] photo) {
		super();
		this.idNumber = idNumber;
		this.empName = empName;
		this.gender = gender;
		this.birth = birth;
		this.photo = photo;
	}
    
    public Employee(String idNumber) {
		super();
		this.idNumber = idNumber;

	}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getIdNumber() {
			return idNumber;
		}

		public void setIdNumber(String idNumber) {
			this.idNumber = idNumber;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public double getJobAge() {
			return JobAge;
		}

		public void setJobAge(double jobAge) {
			JobAge = jobAge;
		}

		public String getBirth() {
			return birth;
		}

		public void setBirth(String birth) {
			this.birth = birth;
		}

		public byte[] getPhoto() {
			return photo;
		}

		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}

		public Login getAccounts() {
			return login;
		}

		public void setAccounts(Login login) {
			this.login = login;
		}

		public List<Emergency> getEmergencies() {
			return emergencies;
		}

		public void setEmergencies(List<Emergency> emergencies) {
			this.emergencies = emergencies;
		}

		public EmployeeInfo getEmployeeInfo() {
			return employeeInfo;
		}

		public void setEmployeeInfo(EmployeeInfo employeeInfo) {
			this.employeeInfo = employeeInfo;
		}

		public Contact getContact() {
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}

		public List<EmployeePermission> getPermissions() {
			return permissions;
		}

		public void setPermissions(List<EmployeePermission> permissions) {
			this.permissions = permissions;
		}

		public Login getLogin() {
			return login;
		}

		public void setLogin(Login login) {
			this.login = login;
		}

		public Employee() {
	}

}

