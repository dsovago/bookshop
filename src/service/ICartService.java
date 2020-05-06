package service;


import model.Cart;

import java.util.List;

public interface ICartService {

    int getTotalPriceOfCart(int cartId);

    void addBookToCart(int cartId, int bookId) throws Exception;

    void removeBookFromCart(int cartId, int bookId);

    List<Cart> getAllCarts();

    void addNewCart(Cart cart);

    void cartPayment(int cartId);
}
