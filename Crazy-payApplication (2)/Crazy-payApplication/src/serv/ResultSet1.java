package serv;

import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultSet
 */
@WebServlet("/ResultSet1")
public class ResultSet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connection = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Prat$_2002");
        Statement statement = connection.createStatement();
        String sql ="SELECT * FROM AxisBank";
        ResultSet  rs= statement.executeQuery(sql);
        
        while(rs.next()) {
        	String name=rs.getString("CUSTOMER_NAME");
        	System.out.println(name);
        }
        
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
