package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SBIBank;

/**
 * Servlet implementation class MPinSBI
 */
@WebServlet("/MPinSBI")
public class MPinSBI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		PrintWriter out = response.getWriter();	
		String id2=request.getParameter("id");
		String pass=request.getParameter("login");
		String bank=request.getParameter("bankName");
		System.out.println(bank);
		
		Connection con=DBConnection.getConnection();
		String query="Select * from "+bank+" where CUSTOMER_ID='"+id2+"'";
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(query);
		
		
		
		String query1="Select * from customer where M_pin='"+pass+"'";
		
		PreparedStatement pmt=con.prepareStatement(query1);
		int n=pmt.executeUpdate();
		
		if(n==0) {
			System.out.println("m_pin storing ....");
			String query2="Insert into customer(M_PIN,BANK_NAME,CUST_NAME,ACC_NO,MOBILE_NO,BIRTH_DAY, AMOUNT)values(?,?,?,?,?,?,?) ";
			PreparedStatement pmt1=con.prepareStatement(query2);
			while(rs.next()) {
			System.out.println(rs.getDouble("AMOUNT"));	
			pmt1.setString(1, pass);
			pmt1.setString(2, bank);
			pmt1.setString(3, rs.getString("CUSTOMER_NAME"));
			pmt1.setString(4, rs.getString("ACCOUNT_NO"));
			pmt1.setString(5, rs.getString("MOBILE_NO"));
			pmt1.setString(6, rs.getString("BIRTH_DATE"));
			pmt1.setDouble(7, rs.getDouble("AMOUNT"));
			
			}
			int n1=pmt1.executeUpdate();
			if(n1==1) {
			RequestDispatcher rd2 =  request.getRequestDispatcher("Welcome?id="+pass);
             rd2.forward(request,response);
				System.out.println("mpin is stored.");
			}
			
		}else
		{
			out.println("<html><script>alert('m_pin already exists')</script><html>");
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
