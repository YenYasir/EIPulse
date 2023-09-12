package com.eipulse.dao;

import org.hibernate.Session;

import com.eipulse.bean.Contact;
import com.eipulse.bean.Emergency;
import com.eipulse.bean.Employee;

import java.util.List;

public class EmpDaoService implements IEmpDao {
    private EmpDao empDao;

    public EmpDaoService(Session session) {
        empDao = new EmpDao(session);
    }

    public EmpDaoService() {
    }

    @Override
    public Employee insertEmp(Employee emp) {
        return empDao.insertEmp(emp);
    }

    @Override
    public List<Employee> selectByLike(String keyword) {
        return empDao.selectByLike(keyword);
    }

    @Override
    public List<Employee> selectAll() {
        return empDao.selectAll();
    }

    @Override
    public Employee updateEmp(Employee emp) {
        return empDao.updateEmp(emp);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return empDao.updateContact(contact);
    }

    @Override
    public Emergency updateEmergency(Emergency emergency) {
        return empDao.updateEmergency(emergency);
    }

    @Override
    public Employee selectById(int id) {
        return empDao.selectById(id);
    }

    @Override
    public boolean deleteEmp(int empId) {
        return empDao.deleteEmp(empId);
    }
}
