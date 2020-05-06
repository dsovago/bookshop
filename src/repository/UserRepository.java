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
        user.setId(nextUserId());
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

    private int nextUserId(){
        int size = findAll().size();
        if (size == 0)
            return 1;
        return findAll().get(size-1).getId() + 1;
    }

    public static UserRepository getInstance() {
        if (instance == null)
            instance = new UserRepository();
        return instance;
    }
}
