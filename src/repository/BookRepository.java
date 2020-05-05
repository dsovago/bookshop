package repository;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    private String filename = "books.txt";

    public BookRepository() {}

    @Override
    public List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                String[] data = line.split(";");
                books.add(new Book(Long.parseLong(data[0]), data[1], data[2], Integer.parseInt(data[3])));

                line = br.readLine();
            }

            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void saveBooks(List<Book> books) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            PrintWriter pw = new PrintWriter(fw);

            for (Book book : books){
                pw.println(book);
            }

            pw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
