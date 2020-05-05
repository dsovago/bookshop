package service;

import model.Book;
import model.Cart;
import repository.BookRepository;
import repository.IBookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService{

    private IBookRepository bookRepository;
    private List<Book> allBooks;

    public BookService() {
        this.bookRepository = new BookRepository();
        this.allBooks = bookRepository.loadBooks();
    }


    @Override
    public Book getBookById(Long bookId) throws Exception {
        for (Book book : allBooks) {
            if (book.getId() == bookId)
                return book;
        }
        throw new Exception("Cart not found!");
    }

    @Override
    public List<Book> getBooksOfCart(Cart cart) throws Exception {
        List<Long> bookIdList = cart.getBooks();
        List<Book> books = new ArrayList<>();
        for (Long bookId : bookIdList){
            books.add(getBookById(bookId));
        }
        return books;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

}
