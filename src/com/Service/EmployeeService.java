package com.Service;

import com.Model.Employee;

import java.util.List;

/**
 * Created by dexter on 2/6/16.
 */
public interface EmployeeService {
    List<Employee> allEmployeeList();
    List<Employee> searchEmployeeList(String text);
    Employee getElementById(Long id);
    void removeEmployee(Long id);
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
}
