package spring.boot.demo.springbootdemo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.demo.springbootdemo.dto.BookDto;
import spring.boot.demo.springbootdemo.dto.BookDtoUtil;
import spring.boot.demo.springbootdemo.entity.Book;
import spring.boot.demo.springbootdemo.entity.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(BookDto bookDto) {
        Book book = BookDtoUtil.getBookFromDto(bookDto);
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> updateById(Long bookId, BookDto bookDto) {
        Optional<Book> byId = bookRepository.findById(bookId);
        if (byId.isPresent()) {
            Book book = BookDtoUtil.getBookFromDto(bookDto);
            book.setBookId(bookId);
            bookRepository.save(book);
            return Optional.of(book);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
