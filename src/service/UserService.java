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
    private ICartRepository cartRepository;

    public UserService() {
        this.userRepository = UserRepository.getInstance();
        this.cartRepository = CartRepository.getInstance();
    }

    @Override
    public void registerUser(User user){
        userRepository.save(user);
    }

    @Override
    public void addNewCartToUser(int userId) {
        User user = userRepository.findUserById(userId);
        List<Integer> carts = user.getCarts();
        if (carts == null)
            carts = new ArrayList<>();
        Cart cart = new Cart();
        cartRepository.save(cart);
        carts.add(cart.getId());
        user.setCarts(carts);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public List<Cart> getCartsOfUser(int userId){
        User user = userRepository.findUserById(userId);
        return cartRepository.findCartsOfUser(user);
    }

}
