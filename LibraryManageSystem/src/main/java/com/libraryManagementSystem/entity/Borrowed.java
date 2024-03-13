package com.libraryManagementSystem.entity;


import lombok.Data;

@Data
public class Borrowed {
    int sid;
    int bid;
    int borrowid;
    String borrow_info;
}
