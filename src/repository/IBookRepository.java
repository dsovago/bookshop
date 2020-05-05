package repository;

import model.Book;

import java.util.List;

public interface IBookRepository {

    List<Book> loadBooks();

    void saveBooks(List<Book> books);
}
