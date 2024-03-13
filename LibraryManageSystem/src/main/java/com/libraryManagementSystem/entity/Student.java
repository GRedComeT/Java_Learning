package com.libraryManagementSystem.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Student {
    int sid;
    String stu_info;
    List<Book> borrowedList;

    public Student() {
        borrowedList = null;
    }
}
