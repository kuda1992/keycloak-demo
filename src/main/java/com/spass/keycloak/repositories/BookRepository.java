package com.spass.keycloak.repositories;


import com.spass.keycloak.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepository {

    private static Map<String, Book> books = new ConcurrentHashMap<>();

    static {
        books.put("B01", new Book("B01", "Harry Potter and the Deathly Hallows", "J.K. Rowling"));
        books.put("B02", new Book("B02", "The Lord of the Rings", "J.R.R. Tolkien"));
        books.put("B03", new Book("B03", "War and Peace", "Leo Tolstoy"));
    }


    public List<Book> readAll() {
        ArrayList<Book> books = new ArrayList<>(BookRepository.books.values());
        books.sort(Comparator.comparing(Book::getId));
        return books;
    }

    public void create(Book book) {
        books.put(book.getId(), book);
    }

    public Book read(String bookId) {
        return books.get(bookId);
    }

    public void update(Book book) {
        books.put(book.getId(), book);
    }

    public void delete(Book book) {
        books.remove(book.getId());
    }


}
