package service;

import model.Book;
import model.Cart;

import java.util.List;

public interface ICartService {

    int getTotalPriceOfCart(Long cartId) throws Exception;

    Cart getCartById(Long cartId) throws Exception;
}
