package repository;

import model.Cart;
import model.User;

import java.util.List;

public interface ICartRepository {

    List<Cart> findAll();

    List<Cart> findCartsOfUser(User user);

    void save(Cart cart);

    void remove(Cart cart);

    Cart findCartById(int cartId);

}
