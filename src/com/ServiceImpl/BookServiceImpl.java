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

    public List<Book> allList() {
        return employeeDAO.allList();
    }

    public List<Book> searchList(String text) {
        return null;
    }

    public Book getElementById(Long id) {
        return employeeDAO.getElementById(id);
    }

    public void remove(Long id) {
        employeeDAO.remove(id);

    }

    public void save(Book book) {
        employeeDAO.save(book);
    }

    public void update(Book book) {
        employeeDAO.update(book);
    }
}
