package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{

    private List<User> allUsers;
    private static UserRepository instance;

    protected UserRepository() {
        this.allUsers = new ArrayList<>();
    }


    @Override
    public List<User> findAll() {
        return allUsers;
    }

    @Override
    public void save(User user) {
        allUsers.add(user);
    }

    @Override
    public void remove(User user) {
        allUsers.remove(user);
    }

    @Override
    public User findUserById(int id) {
        for (User user : this.allUsers){
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public static UserRepository getInstance() {
        if (instance == null)
            instance = new UserRepository();
        return instance;
    }
}
