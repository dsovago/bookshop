package service;

import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

import java.util.List;

public class BookService {

    private IBookRepository bookRepository;
    private List<Book> allBooks;

    public BookService() {
        this.bookRepository = new BookRepository();
        this.allBooks = bookRepository.loadBooks();
    }


    public List<Book> getAllBooks() {
        return allBooks;
    }
}
