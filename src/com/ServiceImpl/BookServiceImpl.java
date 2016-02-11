package com.ServiceImpl;

import com.DAO.BookDAO;
import com.Model.Book;
import com.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dexter on 2/7/16.
 */
@Service("EmployeeService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO employeeDAO;

    public List<Book> allEmployeeList() {
        return employeeDAO.allEmployeeList();
    }

    @Override
    public List<Book> searchEmployeeList(String text) {
        return null;
    }

    public Book getElementById(Long id) {
        return employeeDAO.getElementById(id);
    }

    public void removeEmployee(Long id) {
        employeeDAO.removeEmployee(id);

    }

    public void saveEmployee(Book book) {
        employeeDAO.saveEmployee(book);
    }

    public void updateEmployee(Book book) {
        employeeDAO.updateEmployee(book);
    }
}
