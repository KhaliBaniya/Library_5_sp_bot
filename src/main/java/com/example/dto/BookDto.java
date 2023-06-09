package com.example.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDto {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publishYear;
    private Integer amount;
    private Boolean visible;
}
