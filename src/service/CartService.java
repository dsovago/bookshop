package service;

import model.Cart;
import repository.CartRepository;
import repository.ICartRepository;

import java.util.List;

public class CartService {

    private ICartRepository cartRepository;
    private List<Cart> allCarts;

    public CartService() {
        this.cartRepository = new CartRepository();
        this.allCarts = cartRepository.loadCarts();
    }

    public List<Cart> getAllCarts() {
        return allCarts;
    }
}
