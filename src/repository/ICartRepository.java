package repository;

import model.Cart;

import java.util.List;

public interface ICartRepository {

    List<Cart> findAll();

    void save(Cart cart);

    void remove(Cart cart);

    Cart findCartById(int cartId);

}
