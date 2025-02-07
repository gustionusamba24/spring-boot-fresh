package com.gustionusamba.bookcatalog.controller;

import com.gustionusamba.bookcatalog.dto.BookDetailDTO;
import com.gustionusamba.bookcatalog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public String findBookList(Model model) {
        List<BookDetailDTO> books = bookService.findBookListDetail();
        model.addAttribute("books", books);
        return "book/list";
    }
}
