package com.library.servlet.pages;

import com.library.entity.User;
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

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

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
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        context.setVariable("borrowList", bookService.getBorrowList());
        context.setVariable("stuNumber", studentService.getStudentList().size());
        context.setVariable("bookNumber", bookService.getBookList().size());
        context.setVariable("borrowNumber", bookService.getBorrowList().size());
        ThymeleafUtil.process("index.html", context, resp.getWriter());
    }
}
