package com.ServiceImpl;

import com.DAO.BookDAO;
import com.Model.Author;
import com.Model.Book;
import com.Model.Genre;
import com.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by dexter on 2/7/16.
 */
@Service("EmployeeService")
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<Book> allList() {
        return bookDAO.allList();
    }

    public Book getElementById(Long id) {
        return bookDAO.getElementById(id);
    }

    public void remove(Long id) {
        bookDAO.remove(id);

    }

    @Override
    public void save(Book book, Genre genre, Author author) {
        bookDAO.save(book, genre, author);
    }

    public void save(Book book) {
        bookDAO.save(book);
    }

    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public Boolean ifExists(String name) {
        return bookDAO.ifExists(name);
    }

    @Override
    public Long order(Long id) {
        return bookDAO.order(id);
    }
}
