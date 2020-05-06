package service;

import model.Cart;
import model.User;

import java.util.List;

public interface IUserService {

    void registerUser(User user);

    void addNewCartToUser(int userId);

    List<Cart> getCartsOfUser(int userId);

    List<User> getAllUsers();

}
