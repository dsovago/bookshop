package service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {

    private static UserService instance;

    private UserRepository userRepository;
    private List<User> allUser;

    public UserService() {
        this.userRepository = UserRepository.getInstance();
        this.allUser = userRepository.loadUsers();
    }

    public void registerUser(User user){
        this.allUser.add(user);
        userRepository.saveUsers(this.allUser);
    }

    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }
}
