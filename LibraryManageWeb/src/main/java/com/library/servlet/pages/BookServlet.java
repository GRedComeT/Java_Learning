package com.library.servlet.pages;

import com.library.entity.Book;
import com.library.entity.User;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;
import com.library.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    BookService service;

    @Override
    public void init() throws ServletException {
        service = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        context.setVariable("bookMap", service.getBookList());
        ThymeleafUtil.process("books.html", context, resp.getWriter());
    }


}
