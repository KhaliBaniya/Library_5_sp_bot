package com.example.service;

import com.example.dto.BookDto;
import com.example.dto.StudentDTO;
import com.example.entity.BookEntity;
import com.example.entity.StudentEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.BookRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookDto crate(BookDto bookDto) {
        BookEntity entity = new BookEntity();
        entity.setTitle(entity.getTitle());
        entity.setAuthor(entity.getAuthor());
        entity.setAmount(entity.getAmount());
        if (bookDto.getTitle() == null || bookDto.getTitle().isBlank()) {
            throw new AppBadRequestException("Title qani?");
        }
        if (bookDto.getAuthor() == null || bookDto.getAuthor().isBlank()) {
            throw new AppBadRequestException("Author  qani mazgi?");
        }
        bookRepository.saveBook(entity);
        bookDto.setId(entity.getId());
        return bookDto;
    }
}
