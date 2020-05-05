package service;

import model.Book;
import model.Cart;

import java.util.List;

public interface IBookService {

    Book getBookById(Long bookId) throws Exception;

    List<Book> getBooksOfCart(Cart cart) throws Exception;
}
