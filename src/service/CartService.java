package service;

import model.Book;
import model.Cart;
import repository.BookRepository;
import repository.CartRepository;
import repository.IBookRepository;
import repository.ICartRepository;

import java.util.ArrayList;
import java.util.List;

public class CartService implements ICartService {

    private ICartRepository cartRepository;
    private IBookRepository bookRepository;

    public CartService() {
        this.cartRepository = CartRepository.getInstance();
        this.bookRepository = BookRepository.getInstance();
    }

    @Override
    public int getTotalPriceOfCart(int cartId) {
        Cart cart = cartRepository.findCartById(cartId);
        List<Book> books = bookRepository.getBooksOfCart(cart);
        int total = 0;
        for (Book book : books){
            total += book.getPrice();
        }
        return total;
    }

    @Override
    public void addBookToCart(int cartId, int bookId) {
        Cart cart = cartRepository.findCartById(cartId);
        List<Integer> booksIdList = cart.getBooks();
        if (booksIdList == null)
            booksIdList = new ArrayList<>();
        booksIdList.add(bookId);
        cart.setBooks(booksIdList);
        cartRepository.save(cart);
    }

    @Override
    public void removeBookFromCart(int cartId, int bookId) {
        Cart cart = cartRepository.findCartById(cartId);
        List<Integer> booksIdList = cart.getBooks();
        booksIdList.remove(booksIdList.indexOf(bookId));
        cart.setBooks(booksIdList);
    }

    public void addNewCart(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }



}
