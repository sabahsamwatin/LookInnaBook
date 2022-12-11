package model;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNo;
    private final String password;

    public Customer(String firstName, String lastName, String email, String phoneNo,
            String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPassword() {
        return password;
    }

}
