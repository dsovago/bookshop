package service;

import model.Book;
import model.Cart;
import model.User;
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
    public void addBookToCart(int cartId, int bookId) throws Exception{
        Cart cart = cartRepository.findCartById(cartId);
        List<Integer> booksIdList = cart.getBooks();
        if (bookRepository.getBookById(bookId).getQuantity() < 1)
            throw new Exception("Book is not in stock!");
        booksIdList.add(bookId);
        cart.setBooks(booksIdList);
    }

    @Override
    public void removeBookFromCart(int cartId, int bookId) {
        Cart cart = cartRepository.findCartById(cartId);
        List<Integer> booksIdList = cart.getBooks();
        booksIdList.remove(booksIdList.indexOf(bookId));
        cart.setBooks(booksIdList);
    }

    @Override
    public void addNewCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void cartPayment(int cartId) {
        Cart cart = cartRepository.findCartById(cartId);
        List<Book> books = bookRepository.getBooksOfCart(cart);
        for (Book book : books){
            book.setQuantity(book.getQuantity()-1); // a megvett könyvek raktári mennyiségéből levon egyet
        }
        cartRepository.remove(cart); //fizetés után törli a kosarat
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

}
