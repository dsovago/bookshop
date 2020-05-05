package model;

public class User {

    private String name;
    private String address;
    private String username;
    private String password;
    private Long cartId;

    public User(String name, String address, String username, String password, Long cardId) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.cartId = cardId;
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

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }


    @Override
    public String toString() {
        return name + ';' + address + ';' + username + ';' + password + ';' + cartId;
    }
}
