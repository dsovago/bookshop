package main;

import model.Book;
import model.Cart;
import model.User;
import repository.UserRepository;
import service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static IUserService userService;
    private static IBookService bookService;
    private static ICartService cartService;


    public static void main(String[] args) {

        userService = new UserService();
        bookService = new BookService();
        cartService = new CartService();

        bookService.addNewBook(new Book(nextBookId(), "Harry Potter", "JK Rowling", 3900));
        bookService.addNewBook(new Book(nextBookId(), "Da Vinci kód", "Dan Brown", 4200));
        bookService.addNewBook(new Book(nextBookId(), "Kakukkszó", "Robert G.", 3100));

        userService.registerUser(new User(nextUserId(),"Kis Béla", "1234 Bp. Kiss u. 5.", "kisbela",
                "bela123"));
        userService.registerUser(new User(nextUserId(), "Nagy András", "1789 Bp. Fő u. 55.", "nagybandi",
                "pass123"));


        userService.addNewCartToUser(1, new Cart(nextCartId()));
        userService.addNewCartToUser(2, new Cart(nextCartId()));
        userService.addNewCartToUser(2, new Cart(nextCartId()));

        cartService.addBookToCart(1,1);
        cartService.addBookToCart(2,2);
        cartService.addBookToCart(2,3);
        cartService.addBookToCart(3,2);

        cartService.removeBookFromCart(3,2);

        System.out.println(cartService.getTotalPriceOfCart(1));
        System.out.println(cartService.getTotalPriceOfCart(2));
        System.out.println(cartService.getTotalPriceOfCart(3));

        System.out.println("===========");

        for (User user : userService.getAllUsers()){
            System.out.println(user);
        }

        System.out.println("===========");

        for (Book book : bookService.getAllBooks()){
            System.out.println(book);
        }


    }

    public static int nextUserId(){
        int size = userService.getAllUsers().size();
        if (size == 0)
            return 1;
        return userService.getAllUsers().get(size-1).getId() + 1;
    }

    public static int nextCartId(){
        int size = cartService.getAllCarts().size();
        if (size == 0)
            return 1;
        return cartService.getAllCarts().get(size-1).getId() + 1;
    }

    public static int nextBookId(){
        int size = bookService.getAllBooks().size();
        if (size == 0)
            return 1;
        return bookService.getAllBooks().get(size-1).getId() + 1;
    }
}
