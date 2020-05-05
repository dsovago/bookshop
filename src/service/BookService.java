package service;

import repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    private static BookService instance;

    public BookService() {
        this.bookRepository = BookRepository.getInstance();
    }





    public static BookService getInstance() {
        if (instance == null)
            instance = new BookService();
        return instance;
    }
}
