package com.rebook.book.controller;

import com.rebook.book.dto.response.BookResponse;
import com.rebook.book.dto.request.BookCreateRequest;
import com.rebook.book.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
@RestController
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> saveBook(
            @RequestBody @Valid final BookCreateRequest bookCreateRequest
    ) {
        BookResponse book = bookService.save(bookCreateRequest);
        return ResponseEntity.created(URI.create("/api/v1/books/" + book.getId())).body(book);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        final List<BookResponse> books = bookService.getBooks();
        return ResponseEntity.ok()
                .body(books);
    }
}
