package model;

import java.util.List;

public class Cart {

    private int id;
    private List<Integer> books;

    public Cart(int id, List<Integer> books) {
        this.id = id;
        this.books = books;
    }

    public Cart(int id) {
        this.id = id;
    }

    public List<Integer> getBooks() {
        return books;
    }

    public void setBooks(List<Integer> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
