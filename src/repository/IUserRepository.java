package repository;

import model.User;

import java.util.List;

public interface IUserRepository {

    List<User> findAll();

    void save(User user);

    void remove(User user);

    User findUserById(int id);
}
