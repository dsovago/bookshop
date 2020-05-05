package repository;

import model.Cart;

import java.util.List;

public interface ICartRepository {

    List<Cart> loadCarts();

    void saveCarts(List<Cart> carts);
}
