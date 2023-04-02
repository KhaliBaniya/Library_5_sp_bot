package com.example.controller;

import com.example.dto.BookDto;
import com.example.dto.StudentDTO;
import com.example.exp.AppBadRequestException;
import com.example.service.BookService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;
    private List<BookDto> bookDtoList = new LinkedList<>();
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody BookDto bookDto) {

        try {
            BookDto response = bookService.crate(bookDto);
            return ResponseEntity.ok(response);
        } catch (AppBadRequestException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping(value = "/create/all")
    public Boolean createAll(@RequestBody List<BookDto> list) {
        for (BookDto dto : list) {
            dto.setId(1);
            bookDtoList.add(dto);
        }
        return true;
    }
    @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") String id, @RequestBody BookDto bookDto) {
        for (BookDto dto : bookDtoList) {
            if (dto.getId().equals(id)) {
                dto.setTitle(bookDto.getTitle());
                dto.setAuthor(bookDto.getAuthor());
                return true;
            }
        }
        return false;
    }
}
