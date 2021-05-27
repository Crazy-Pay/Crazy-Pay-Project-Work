package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginValid
 */
@WebServlet("/LoginValid")
public class LoginValid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		PrintWriter out=response.getWriter();	
		String name=request.getParameter("Login");
		String pass=request.getParameter("pass");

		String query="Select * from Customer where CUST_NAME='"+name+"' AND M_PIN='"+pass+"'";
		
		Connection con=DBConnection.getConnection();
		PreparedStatement pmt=con.prepareStatement(query);
		int n=pmt.executeUpdate();
		if(n==1) {
			System.out.println("if");
			RequestDispatcher rd=request.getRequestDispatcher("Welcome?id="+pass);
			rd.forward(request, response);
		}
		else {
			System.out.println("else");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			out.print("<script> alert(\"Check Name and Password(Check caps on)\")  </script>"); 
			rd.include(request, response);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
