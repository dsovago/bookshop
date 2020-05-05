package service;

import model.Book;
import repository.BookRepository;
import repository.IBookRepository;

import java.util.List;


public class BookService implements IBookService{

    private IBookRepository bookRepository;

    public BookService() {
        this.bookRepository = BookRepository.getInstance();
    }


    @Override
    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int bookId) {
        Book book = bookRepository.getBookById(bookId);
        bookRepository.remove(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

}
