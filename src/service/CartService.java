package service;

import model.Book;
import model.Cart;
import repository.CartRepository;
import repository.ICartRepository;

import java.util.List;

public class CartService implements ICartService {

    private ICartRepository cartRepository;
    private IBookService bookService;
    private List<Cart> allCarts;

    public CartService() {
        this.cartRepository = new CartRepository();
        this.bookService = new BookService();
        this.allCarts = cartRepository.loadCarts();
    }

    @Override
    public int getTotalPriceOfCart(Long cartId) throws Exception {
        Cart cart = getCartById(cartId);
        List<Book> books = bookService.getBooksOfCart(cart);
        int total = 0;
        for (Book book : books){
            total += book.getPrice();
        }
        return total;
    }

    @Override
    public Cart getCartById(Long cartId) throws Exception {
        for (Cart cart : allCarts) {
            if (cart.getId() == cartId)
                return cart;
        }
        throw new Exception("Cart not found!");
    }


    public List<Cart> getAllCarts() {
        return allCarts;
    }



}
