package main;

import model.User;
import repository.UserRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserRepository ur = new UserRepository();

        List<User> users;
        users = ur.loadUsers();
        for (User user : users){
            System.out.println(user);
        }
    }
}
