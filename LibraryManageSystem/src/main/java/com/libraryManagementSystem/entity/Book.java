package com.libraryManagementSystem.entity;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Book {
    int bid;
    String book_info;
}
