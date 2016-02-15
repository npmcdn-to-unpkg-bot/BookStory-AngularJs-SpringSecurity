package com.Controller;

import com.HashCode.MD5;
import com.Model.User;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dexter on 2/12/16.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Boolean exist = userService.ifExists(email, password);
        if (exist) {
            request.getSession().setAttribute("username", email);
            response.sendRedirect("/user");
        } else {
            response.sendRedirect("/login");
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        password = MD5.getMD5(password);
        User user = new User(firstName, lastName, email, mobile, password);
        Boolean exist = userService.ifExists(email);
        if (!exist) {
            userService.save(user);
            request.getSession().setAttribute("username", email);
            response.sendRedirect("/user");
        } else {
            request.getSession().setAttribute("notify", "user already exists");
            response.sendRedirect("/register");
        }
    }
}
