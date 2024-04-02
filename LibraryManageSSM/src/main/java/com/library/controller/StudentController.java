package com.library.controller;

import com.library.service.BookService;
import com.library.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    @Resource
    UserService userService;

    @GetMapping("/students")
    public String book(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("studentList", userService.getStudentList());
        return "students";
    }

    @GetMapping("/add-student")
    public String addBook(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addBook(@RequestParam("student_info") String student_info) {
        userService.addStudent(student_info);
        return "redirect:/students";
    }

    @GetMapping("/delete-student")
    public String deleteBook(@RequestParam("id") int id) {
        userService.deleteStudent(id);
        return "redirect:/students";
    }
}
