package spring.boot.demo.springbootdemo.controller;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.demo.springbootdemo.dto.BookDto;
import spring.boot.demo.springbootdemo.entity.Book;
import spring.boot.demo.springbootdemo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> allBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Long bookId) {
        return bookService.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Book with ID " + bookId + " not found"));
    }

    @PostMapping
    public void add(@Valid @RequestBody BookDto bookDto) {
        Book book = new Book(bookDto.getTitle(), bookDto.getYear(), bookDto.getPrice());
        bookService.save(book);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long bookId) {
        bookService.delete(bookId);
    }

    @PutMapping("/{bookId}")
    public Book update(@PathVariable("bookId") Long bookId, @Valid @RequestBody BookDto bookDto) {
        Optional<Book> book = bookService.updateById(bookId, bookDto);
        return book.orElse(null);
    }
}
