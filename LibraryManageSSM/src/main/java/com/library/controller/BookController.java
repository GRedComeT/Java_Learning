package com.library.controller;

import com.library.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("/books")
    public String book(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("bookMap", bookService.getBookMap());
        return "books";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(@RequestParam("book_info") String book_info) {
        bookService.addBook(book_info);
        return "redirect:/books";
    }

    @PostMapping("delete-book")
    public String deleteBook(@RequestParam("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

}
