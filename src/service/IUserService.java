package service;

import model.Cart;
import model.User;

import java.util.List;

public interface IUserService {

    void registerUser(User user);

    void addNewCartToUser(int userId, Cart cart);

    List<User> getAllUsers();

}
