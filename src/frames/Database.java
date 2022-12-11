package frames;

import model.Book;
import model.Customer;
import model.SaleHistory;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {
    
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Book> cart = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<SaleHistory> history = new ArrayList<>();
    static Connection connection;
    static String currentCustomerEmail;
    
    public Database() {
        getConnection();
        fetchBooks();
        fetchCustomers();
        fetchSaleHistory();
    }
    
    private static void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymgt", "root",
                    "abcd1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    static void addBook(Book book) {
        try {
            PreparedStatement pSt = connection.prepareStatement(
                    "INSERT INTO books (isbn, title, author, publisher, genre,"
                    + " price, pages) "
                    + "VALUES (?,?,?,?,?,?,?)");
            
            pSt.setString(1, book.getISBN());
            pSt.setString(2, book.getTitle());
            pSt.setString(3, book.getAuthor());
            pSt.setString(4, book.getPublisher());
            pSt.setString(5, book.getGenre());
            pSt.setDouble(6, book.getPrice());
            pSt.setInt(7, book.getPages());
            
            pSt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    static void removeBook(String ISBN) {
        try {
            PreparedStatement pSt = connection.prepareStatement(
                    "DELETE FROM books where isbn = ?");
            
            pSt.setString(1, ISBN);
            pSt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    static void addCustomer(Customer customer) {
        try {
            try (
                    Statement st = connection.createStatement()) {
                PreparedStatement pSt = connection.prepareStatement(
                        "INSERT INTO customers (firstname, lastname, email, phoneno, password) "
                        + "VALUES (?,?,?,?,?)");
                
                pSt.setString(1, customer.getFirstName());
                pSt.setString(2, customer.getLastName());
                pSt.setString(3, customer.getEmail());
                pSt.setString(4, customer.getPhoneNo());
                pSt.setString(5, customer.getPassword());
                
                pSt.executeUpdate();
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    static void insertSaleRecords(SaleHistory saleHistory) {
        try {
            PreparedStatement pSt = connection.prepareStatement(
                    "INSERT INTO salehistory (isbn, genre, author, price, cusemail, date) "
                    + "VALUES (?,?,?,?,?,?)");
            
            pSt.setString(1, saleHistory.getISBN());
            pSt.setString(2, saleHistory.getGenre());
            pSt.setString(3, saleHistory.getAuthor());
            pSt.setDouble(4, saleHistory.getPrice());
            pSt.setString(5, saleHistory.getCusEmail());
            pSt.setString(6, saleHistory.getDate());
            
            pSt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void fetchBooks() {
        
        try {
            try (
                    Statement st = connection.createStatement()) {
                
                String query = "Select * from books";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    books.add(new Book(rs.getString("isbn"), rs.getString("title"),
                            rs.getString("author"), rs.getString("publisher"),
                            rs.getString("genre"), rs.getDouble("price"),
                            rs.getInt("pages")));
                    
                }
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private static void fetchCustomers() {
        
        try {
            try (
                    Statement st = connection.createStatement()) {
                
                String query = "Select * from customers";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    customers.add(new Customer(rs.getString("firstname"), rs.getString("lastname"),
                            rs.getString("email"), rs.getString("phoneno"),
                            rs.getString("password")));
                    
                }
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private static void fetchSaleHistory() {
        
        try {
            try (
                    Statement st = connection.createStatement()) {
                
                String query = "Select * from salehistory";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    history.add(new SaleHistory(rs.getString("isbn"), rs.getString("genre"),
                            rs.getString("author"), rs.getDouble("price"), rs.getString("cusemail"),
                            rs.getString("date")));
                }
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
