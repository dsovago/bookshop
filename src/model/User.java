package model;

import java.util.List;

public class User {

    private int id;
    private String name;
    private String address;
    private String username;
    private String password;
    private List<Integer> carts;

    public User(String name, String address, String username, String password) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public User(String name, String address, String username, String password, List<Integer> carts) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.carts = carts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getCarts() {
        return carts;
    }

    public void setCarts(List<Integer> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", carts=" + carts +
                '}';
    }
}
