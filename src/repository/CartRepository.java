package repository;

import model.Cart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CartRepository implements ICartRepository {

    private String filename = "carts.txt";

    @Override
    public List<Cart> loadCarts() {
        List<Cart> carts = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null){
                String[] data = line.split(";");
                List<Long> books = new ArrayList<>();
                for (int i = 1; i < data.length-1; i++) {
                    books.add(Long.parseLong(data[i]));
                }

                carts.add(new Cart(Long.parseLong(data[0]), books));
                line = br.readLine();
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return carts;
    }

    @Override
    public void saveCarts(List<Cart> carts) {
        try {
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);

            for (Cart cart : carts) {
                pw.println(cart);
            }

            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
