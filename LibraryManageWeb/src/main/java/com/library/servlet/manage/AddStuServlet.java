package com.library.servlet.manage;

import com.library.service.StudentService;
import com.library.service.impl.StudentServiceImpl;
import com.library.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/add-student")
public class AddStuServlet extends HttpServlet {

    StudentService service;

    @Override
    public void init() throws ServletException {
        service = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        ThymeleafUtil.process("add-student.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stu_info = req.getParameter("student_info");
        service.addStudent(stu_info);
        resp.sendRedirect("students");
    }
}
