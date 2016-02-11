package com.Controller;

import com.HashCode.MD5;
import com.Model.Employee;
import com.Service.EmployeeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dexter on 2/6/16.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add")
    public Employee addOrUpdateEmployee(HttpServletRequest request) {
        String hideId = request.getParameter("hideId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        password = MD5.getMD5(password);
        String state = request.getParameter("state");
        Employee employee;
        if (!(hideId.equals(""))) {
            Long id = Long.parseLong(hideId);
            employee = new Employee(id, firstName, lastName, mobile, email, password, state);
            employeeService.updateEmployee(employee);
        } else {
            employee = new Employee(firstName, lastName, mobile, email, password, state);
            employeeService.saveEmployee(employee);
        }
        return employee;
    }

    @RequestMapping(value = "/allList")
    public String allListEmployee() {
        List employees = employeeService.allEmployeeList();
        Gson gson = new Gson();
        return gson.toJson(employees, employees.getClass());
    }

    @RequestMapping(value = "/delete")
    public void deleteEmployee(HttpServletRequest request) {
        String i = request.getParameter("id");
        Long id = Long.parseLong(i);
        employeeService.removeEmployee(id);
    }


    @RequestMapping(value = "/getElementById")
    public Employee getElementById(HttpServletRequest request) {
        String i = request.getParameter("id");
        Long id = Long.parseLong(i);
        return employeeService.getElementById(id);
    }

    @RequestMapping(value = "/getSearchEmployees")
    public String getSearchEmployee(HttpServletRequest request) {
        String text = request.getParameter("text");
        List<Employee> employeeList = employeeService.searchEmployeeList(text);
        if (employeeList != null) {
            Gson gson = new Gson();
            return gson.toJson(employeeList, employeeList.getClass());
        } else {
            return "not found employee";
        }
    }
}
