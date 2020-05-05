package service;

import model.Cart;
import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {

    private IUserRepository userRepository;
    private List<User> allUsers;

    public UserService() {
        this.userRepository = new UserRepository();
        this.allUsers = userRepository.loadUsers();
    }

    public void registerUser(User user){
        this.allUsers.add(user);
        userRepository.saveUsers(this.allUsers);
    }

    @Override
    public void addNewCartToUser(Long userId, Cart cart) throws Exception {
        User user = getUserById(userId);
        List<Long> carts = user.getCarts();
        carts.add(cart.getId());
        user.setCarts(carts);
        userRepository.saveUsers(allUsers);
    }

    @Override
    public User getUserById(Long userId) throws Exception{
        for (User user : this.allUsers){
            if (user.getId() == userId)
                return user;
        }
        throw new Exception("User not found!");
    }


    public List<User> getAllUsers() {
        return allUsers;
    }
}
