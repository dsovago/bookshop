package service;

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


    public List<User> getAllUsers() {
        return allUsers;
    }
}
