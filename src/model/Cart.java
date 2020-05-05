package model;

import java.util.List;

public class Cart {

    private Long id;
    private List<Long> books;

    public Cart(Long id, List<Long> books) {
        this.id = id;
        this.books = books;
    }

    public List<Long> getBooks() {
        return books;
    }

    public void setBooks(List<Long> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String s = "";
        for (Long bookId : books)
            s += bookId + ",";
        return id + ";" + s;
    }
}
