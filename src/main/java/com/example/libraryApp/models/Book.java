package com.example.libraryApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 50, message = "Title should be between 2 and 50 characters")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 50, message = "Name of author should be between 2 and 50 characters")
    private String author;

    @Column(name = "isbn")
    @NotEmpty
    @Pattern(
            regexp = "^(?:\\d{9}[\\dXx]|\\d{3}-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1})$",
            message = "Invalid ISBN format"
    )
    private int isbn;

    @Column(name = "printYear")
    private int printYear;

    @Column(name = "readAlready")
    private boolean readAlready;

    @Column(name = "image")
    private String image;

    public Book() {

    }
}
