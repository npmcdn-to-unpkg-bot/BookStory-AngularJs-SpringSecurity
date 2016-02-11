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

    public List<Book> allBookList() {
        return employeeDAO.allBookList();
    }

    @Override
    public List<Book> searchBookList(String text) {
        return null;
    }

    public Book getElementById(Long id) {
        return employeeDAO.getElementById(id);
    }

    public void removeBook(Long id) {
        employeeDAO.removeBook(id);

    }

    public void saveBook(Book book) {
        employeeDAO.saveBook(book);
    }

    public void updateBook(Book book) {
        employeeDAO.updateBook(book);
    }
}
