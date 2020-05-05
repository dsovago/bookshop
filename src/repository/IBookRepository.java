package repository;

import model.Book;
import model.Cart;

import java.util.List;

public interface IBookRepository {

    List<Book> findAll();

    void save(Book book);

    void remove(Book book);

    Book getBookById(int id);

    List<Book> getBooksOfCart(Cart cart);
}
