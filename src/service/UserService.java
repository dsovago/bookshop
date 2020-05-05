package service;

import model.Cart;
import model.User;
import repository.CartRepository;
import repository.ICartRepository;
import repository.IUserRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    private IUserRepository userRepository;
    private ICartService cartService;

    public UserService() {
        this.userRepository = UserRepository.getInstance();
        this.cartService = new CartService();
    }

    @Override
    public void registerUser(User user){
        userRepository.save(user);
    }

    @Override
    public void addNewCartToUser(int userId, Cart cart) {
        User user = userRepository.findUserById(userId);
        List<Integer> carts = user.getCarts();
        if (carts == null)
            carts = new ArrayList<>();
        carts.add(cart.getId());
        user.setCarts(carts);
        cartService.addNewCart(cart);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
