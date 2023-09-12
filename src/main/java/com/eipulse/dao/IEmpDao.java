package com.eipulse.dao;

import java.util.List;

import com.eipulse.bean.Contact;
import com.eipulse.bean.Emergency;
import com.eipulse.bean.Employee;

public interface IEmpDao {
    Employee insertEmp(Employee emp);
    List<Employee> selectByLike(String keyword);
    List<Employee> selectAll();
    Employee updateEmp(Employee emp);
    Contact updateContact(Contact contact);
    Emergency updateEmergency(Emergency emergency);
    Employee selectById(int id);
    boolean deleteEmp(int empId);
}
