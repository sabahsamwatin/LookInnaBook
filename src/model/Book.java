package model;

public class Book {

    private final String ISBN;
    private final String title;
    private final String author;
    private final String publisher;
    private final String genre;
    private final double price;
    private final int pages;

    public Book(String ISBN, String title, String author, String publisher,
            String genre, double price, int pages) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.price = price;
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

}
