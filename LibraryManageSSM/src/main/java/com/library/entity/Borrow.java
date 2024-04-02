package com.library.entity;

import lombok.Data;

@Data
public class Borrow {
    int id;
    int sid;
    int bid;
    String borrow_info;
    String stu_info;
    String book_info;
}
