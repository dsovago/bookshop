package repository;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{

    private String filename = "users.txt";

    @Override
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                String[] data = line.split(";");
                users.add(new User(data[0], data[1], data[2], data[3], Long.parseLong(data[4])));

                line = br.readLine();
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void saveUsers(List<User> users) {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);

            for (User user : users) {
                pw.println(user);
            }

            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}