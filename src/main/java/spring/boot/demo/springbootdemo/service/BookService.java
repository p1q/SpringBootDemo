package spring.boot.demo.springbootdemo.service;

import java.util.List;
import java.util.Optional;
import spring.boot.demo.springbootdemo.dto.BookDto;
import spring.boot.demo.springbootdemo.entity.Book;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);

    Optional<Book> updateById(Long bookId, BookDto bookDto);

    void delete(Long bookId);
}
