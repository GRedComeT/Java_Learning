package com.library.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class Borrow {
    int borrow_id;
    int bid;
    String book_info;
    String borrow_info;
    int sid;
    String student_info;
}
