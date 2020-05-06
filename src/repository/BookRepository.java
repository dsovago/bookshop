package repository;

import model.Book;
import model.Cart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    private List<Book> allBooks;
    private static BookRepository instance;

    protected BookRepository() {
        allBooks = new ArrayList<>();
    }


    @Override
    public List<Book> findAll() {
        return allBooks;
    }

    @Override
    public void save(Book book) {
        book.setId(nextBookId());
        allBooks.add(book);
    }

    @Override
    public void remove(Book book) {
        allBooks.remove(book);
    }

    @Override
    public Book getBookById(int id) {
        for (Book book : allBooks) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }

    @Override
    public List<Book> getBooksOfCart(Cart cart) {
        List<Integer> bookIdList = cart.getBooks();
        List<Book> books = new ArrayList<>();
        for (int bookId : bookIdList){
            books.add(getBookById(bookId));
        }
        return books;
    }

    private int nextBookId(){
        int size = findAll().size();
        if (size == 0)
            return 1;
        return findAll().get(size-1).getId() + 1;
    }

    public static BookRepository getInstance(){
        if (instance == null)
            instance = new BookRepository();
        return instance;
    }
}
