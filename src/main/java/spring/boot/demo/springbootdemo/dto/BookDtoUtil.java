package spring.boot.demo.springbootdemo.dto;

import spring.boot.demo.springbootdemo.entity.Book;

public class BookDtoUtil {
    public static Book getBookFromDto(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setYear(bookDto.getYear());
        return book;
    }
}
