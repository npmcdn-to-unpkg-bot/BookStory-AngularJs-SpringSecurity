package com.DAOImpl;

import com.DAO.EmployeeDAO;
import com.Model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dexter on 2/7/16.
 */
@Repository("EmployeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

    Session session;
    Transaction transaction;

    @SuppressWarnings("unchecked")
    public List<Employee> allEmployeeList() {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        List employees = session.createQuery("from Employee ").list();
        transaction.commit();
        session.close();
        return employees;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> searchEmployeeList(String text) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session.createQuery("from Employee where upper(firstName) like '%" + text.toUpperCase() + "%'" +
                "or upper(lastName) like '%" + text.toUpperCase() + "%'"
                + "or upper(mobile) like '%" + text.toUpperCase() + "%'"
                + "or upper(email) like '%" + text.toUpperCase() + "%'"
                + "or upper(state) like '%" + text.toUpperCase() + "%'"
        ).list();
    }

    public Employee getElementById(Long id) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return (Employee) session.get(Employee.class, id);
    }

    public void removeEmployee(Long id) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Employee employee = getElementById(id);
        if (employee != null) {
            session.delete(employee);
        }
        transaction.commit();
        session.close();
    }

    public void saveEmployee(Employee employee) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public void updateEmployee(Employee employee) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Employee updateEmployee = getElementById(employee.getId());
        updateEmployee.setId(employee.getId());
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setMobile(employee.getMobile());
        updateEmployee.setPassword(employee.getPassword());
        updateEmployee.setState(employee.getState());
        session.update(updateEmployee);
        transaction.commit();
        session.close();
    }
}