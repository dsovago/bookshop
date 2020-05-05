package model;

import java.util.List;

public class User {

    private Long id;
    private String name;
    private String address;
    private String username;
    private String password;
    private List<Long> carts;

    public User(Long id, String name, String address, String username, String password, List<Long> carts) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.carts = carts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Long> getCarts() {
        return carts;
    }

    public void setCarts(List<Long> carts) {
        this.carts = carts;
    }

    @Override
    public String toString() {
        String s = "";
        for (Long cartId : carts)
            s += cartId + ',';
        return id + ';' + name + ';' + address + ';' + username + ';' + password + ';' + s;
    }
}
