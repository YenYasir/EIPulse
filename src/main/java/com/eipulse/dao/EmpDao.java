package com.eipulse.dao;

import org.hibernate.Session;

import com.eipulse.bean.Contact;
import com.eipulse.bean.Emergency;
import com.eipulse.bean.Employee;

import java.util.List;

public class EmpDao implements IEmpDao{
    private Session session;

    public EmpDao(Session session) {
        this.session = session;
    }

    public EmpDao() {
    }

    @Override
    public Employee insertEmp(Employee emp) {
        session.persist(emp);
        return emp;
    }

    @Override
    public List<Employee> selectByLike(String keyword) {
        String hql = "from Employee  where empName like :keyword";
        return session.createQuery(hql,Employee.class).setParameter("keyword","%"+keyword+"%").list();
    }

    @Override
    public List<Employee> selectAll() {
        List<Employee> employees = session.createQuery("from Employee",Employee.class).list();
        return employees;
    }

    @Override
    public Employee updateEmp(Employee emp) {
        try {
            Employee result = session.merge(emp);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Contact updateContact(Contact contact) {
        try {
            Contact result = session.merge(contact);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Emergency updateEmergency(Emergency emergency) {
        try {
            Emergency result = session.merge(emergency);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee selectById(int id) {
        return session.get(Employee.class,id);
    }

    @Override
    public boolean deleteEmp(int empId) {
        Employee emp =session.get(Employee.class,empId);
        if(emp!= null){
            session.remove(emp);
            session.flush();
            return true;
        }
        return false;
    }
}
