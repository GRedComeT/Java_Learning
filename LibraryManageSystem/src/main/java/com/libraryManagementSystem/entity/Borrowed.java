package com.libraryManagementSystem.entity;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Borrowed {
    int sid;
    int bid;
    int borrowid;
    String borrow_info;
}
