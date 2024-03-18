package com.library.servlet;

import com.library.service.UserService;
import com.library.service.impl.UserServiceImpl;
import com.library.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        if (req.getSession().getAttribute("login-failure") != null) {
            context.setVariable("loginFailure", true);
            req.getSession().removeAttribute("login-failure");
        }
        ThymeleafUtil.process("login.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember-me");
        if (service.auth(username, password, req.getSession())) {
            resp.getWriter().write("Success login!");
        } else {
            req.getSession().setAttribute("login-failure", new Object());
            this.doGet(req, resp);
        }
    }
}
