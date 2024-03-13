CREATE DATABASE IF NOT EXISTS LibraryManagementSystem;

USE LibraryManagementSystem;

CREATE TABLE IF NOT EXISTS Students (
                                        sid INT PRIMARY KEY,
                                        stu_info VARCHAR(100) NOT NULL
    );
CREATE TABLE IF NOT EXISTS Books (
                                     bid INT PRIMARY KEY,
                                     book_info VARCHAR(100) NOT NULL
    );
CREATE TABLE IF NOT EXISTS Borrowed (
                                        sid INT,
                                        bid INT,
                                        borrowid INT PRIMARY KEY,
                                        FOREIGN KEY (sid) REFERENCES Students(sid),
    FOREIGN KEY (bid) REFERENCES Books(bid),
    borrow_info VARCHAR(100) NOT NULL
    );

# Insert test information
INSERT INTO Students (sid, stu_info) values(1, 'John');
INSERT INTO Students (sid, stu_info) values(2, 'Alice');
INSERT INTO Students (sid, stu_info) values(3, 'Bob');

INSERT INTO Books values(1, 'Book1');
INSERT INTO Books values(2, 'Book2');
INSERT INTO Books values(3, 'Book3');

INSERT INTO Borrowed values(1, 1, 1, 'Borrowed by John');
INSERT INTO Borrowed values(1, 2, 2, 'Borrowed by John');
INSERT INTO Borrowed values(3, 3, 3, 'Borrowed by Bob');




