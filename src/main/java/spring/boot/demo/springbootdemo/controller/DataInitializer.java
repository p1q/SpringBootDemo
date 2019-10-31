package spring.boot.demo.springbootdemo.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.boot.demo.springbootdemo.entity.Book;
import spring.boot.demo.springbootdemo.service.BookService;

@Component
public class DataInitializer {
    @Autowired
    private BookService bookService;

    @PostConstruct
    public void initData() {
        saveBooks();
    }

    private void saveBooks() {
        Book kobzar = new Book("Kobzar", 2019, 100.0);
        kobzar.setDescription("This book is avesome");
        bookService.save(kobzar);
        Book kobzar1 = new Book("Kobzar", 2015, 80.0);
        bookService.save(kobzar1);
        Book lysovaMavka = new Book("LysovaMavka", 2018, 121.15);
        bookService.save(lysovaMavka);
        Book lysovaPisnya = new Book("Lysova Pisnya", 1981, 42.0);
        bookService.save(lysovaPisnya);
        Book kamenyary = new Book("Kamenyary", 2010, 29.99);
        bookService.save(kamenyary);
        Book kemenyaryGold = new Book("Kamenyary. Gold Edition", 1990, 439.99);
        bookService.save(kemenyaryGold);
    }
}
