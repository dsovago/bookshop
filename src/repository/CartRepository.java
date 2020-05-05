package repository;

import model.Cart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository implements ICartRepository {

    private List<Cart> allCarts;
    private static CartRepository instance;

    protected CartRepository() {
        this.allCarts = new ArrayList<>();
    }


    @Override
    public List<Cart> findAll() {
        return allCarts;
    }

    @Override
    public void save(Cart cart) {
        allCarts.add(cart);
    }

    @Override
    public void remove(Cart cart) {
        allCarts.remove(cart);
    }

    @Override
    public Cart findCartById(int cartId) {
        for (Cart cart : allCarts) {
            if (cart.getId() == cartId)
                return cart;
        }
        return null;
    }

    public static CartRepository getInstance() {
        if (instance == null)
            instance = new CartRepository();
        return instance;
    }
}
