package com.example.projectweek5.Repositry;

import com.example.projectweek5.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositry extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);

    Book findBookByNameEquals(String name);

    List<Book> findAllByGenreEquals(String genre);
}
