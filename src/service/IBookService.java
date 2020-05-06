package service;

import model.Book;
import model.Cart;

import java.util.List;

public interface IBookService {

    void addNewBook(Book book);

    void deleteBook(int bookId);

    List<Book> getAllBooks();

    Book getBookById(int bookId);
}
