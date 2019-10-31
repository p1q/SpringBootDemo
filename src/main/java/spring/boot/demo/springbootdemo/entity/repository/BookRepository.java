package spring.boot.demo.springbootdemo.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.demo.springbootdemo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
