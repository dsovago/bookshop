package main;

import model.Book;
import model.Cart;
import model.User;
import repository.UserRepository;
import service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static IUserService userService = new UserService();
    private static IBookService bookService = new BookService();
    private static ICartService cartService = new CartService();


    public static void main(String[] args) {

        init();

        System.out.println("Könyvek:");
        for (Book book : bookService.getAllBooks()){
            System.out.println(book);
        }

        System.out.println("Userek:");
        for (User user : userService.getAllUsers()){
            System.out.println(user);
        }

        System.out.println("1. user kosarai:");
        for (Cart cart : userService.getCartsOfUser(1)){
            System.out.println(cart);
        }

        System.out.println("2. user kosarai:");
        for (Cart cart : userService.getCartsOfUser(2)){
            System.out.println(cart);
        }

        System.out.println("Fizetés:");


        System.out.println("1. kosár összege:" + cartService.getTotalPriceOfCart(1) + " Ft");
        cartService.cartPayment(1);
        System.out.println("Sikeres fizetés!");

        System.out.println("2. kosár összege:" + cartService.getTotalPriceOfCart(2) + " Ft");
        cartService.cartPayment(2);
        System.out.println("Sikeres fizetés!");

        System.out.println("3. kosár összege:" + cartService.getTotalPriceOfCart(3) + " Ft");
        cartService.cartPayment(3);
        System.out.println("Sikeres fizetés!");

    }

    public static void init() {
        bookService.addNewBook(new Book("Harry Potter", "JK Rowling", 3900, 2));
        bookService.addNewBook(new Book("Da Vinci kód", "Dan Brown", 4200,4));
        bookService.addNewBook(new Book("Kakukkszó", "Robert G.", 3100, 5));

        userService.registerUser(new User("Kis Béla", "1234 Bp. Kiss u. 5.", "kisbela",
                "bela123"));
        userService.registerUser(new User("Nagy András", "1789 Bp. Fő u. 55.", "nagybandi",
                "pass123"));


        userService.addNewCartToUser(1);
        userService.addNewCartToUser(2);
        userService.addNewCartToUser(2);

        try {
            cartService.addBookToCart(1,1);
            cartService.addBookToCart(2,2);
            cartService.addBookToCart(2,3);
            cartService.addBookToCart(3,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
