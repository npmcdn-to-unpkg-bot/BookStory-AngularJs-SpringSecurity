package com.ServiceImpl;

import com.DAO.EmployeeDAO;
import com.Model.Employee;
import com.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dexter on 2/7/16.
 */
@Service("EmployeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> allEmployeeList() {
        return employeeDAO.allEmployeeList();
    }

    @Override
    public List<Employee> searchEmployeeList(String text) {
        return null;
    }

    public Employee getElementById(Long id) {
        return employeeDAO.getElementById(id);
    }

    public void removeEmployee(Long id) {
        employeeDAO.removeEmployee(id);

    }

    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }
}
