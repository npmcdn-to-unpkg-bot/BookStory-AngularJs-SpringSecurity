package com.Controller;

import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
            response.sendRedirect("/error");
        }
    }
}
