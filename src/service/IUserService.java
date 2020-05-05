package service;

import model.Cart;
import model.User;

public interface IUserService {

    void registerUser(User user);

    void addNewCartToUser(Long userId, Cart cart) throws Exception;

    User getUserById(Long userId) throws Exception;
}
