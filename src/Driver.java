
import frames.Database;
import frames.Login;

public class Driver {

    public static void main(String[] args) {

        Database db = new Database();
        Login login = new Login();
        login.setVisible(true);
    }

}
