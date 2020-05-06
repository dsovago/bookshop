package repository;

import model.Cart;
import model.User;

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
    public List<Cart> findCartsOfUser(User user) {
        List<Cart> carts = new ArrayList<>();
        for (int cartId : user.getCarts()){
            carts.add(findCartById(cartId));
        }
        return carts;
    }

    @Override
    public void save(Cart cart) {
        cart.setId(nextCartId());
        cart.setBooks(new ArrayList<>());
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

    private int nextCartId(){
        int size = findAll().size();
        if (size == 0)
            return 1;
        return findAll().get(size-1).getId() + 1;
    }
}
