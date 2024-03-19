package com.library.servlet.manage;

import com.library.entity.Borrow;
import com.library.service.BookService;
import com.library.service.StudentService;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.StudentServiceImpl;
import com.library.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {

    BookService bookService;
    StudentService studentService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        context.setVariable("bookList", bookService.getActiveBookList());
        context.setVariable("studentList", studentService.getStudentList());
        ThymeleafUtil.process("add-borrow.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("book"));
        int sid = Integer.parseInt(req.getParameter("student"));
        String borrow_info = req.getParameter("borrow_info");
        bookService.addBorrow(new Borrow().setBid(bid).setSid(sid).setBorrow_info(borrow_info));
        resp.sendRedirect("index");
    }
}
