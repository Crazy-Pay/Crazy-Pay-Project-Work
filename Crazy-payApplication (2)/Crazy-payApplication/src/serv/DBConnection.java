package serv;
import java.sql.*;
import java.util.ResourceBundle;
public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {        
        ResourceBundle rb = ResourceBundle.getBundle("oracle");
        String url = rb.getString("db.url");
        String username = rb.getString("db.username");
        String password = rb.getString("db.password");
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c =DriverManager.getConnection(url,username,password);
        return c;
	}
}