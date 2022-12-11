package model;

import java.util.Date;

public class SaleHistory {

    private final String ISBN;
    private final String genre;
    private final String author;
    private final double price;
    private final String cusEmail;
    private final String date;

    public SaleHistory(String ISBN, String genre, String author, double price,
            String cusEmail) {
        this.ISBN = ISBN;
        this.genre = genre;
        this.author = author;
        this.price = price;
        this.cusEmail = cusEmail;
        this.date = String.valueOf(new Date());
    }

    public SaleHistory(String ISBN, String genre, String author, double price,
            String cusEmail, String date) {
        this.ISBN = ISBN;
        this.genre = genre;
        this.author = author;
        this.cusEmail = cusEmail;
        this.date = date;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public String getDate() {
        return date;
    }
}
