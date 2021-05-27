package serv;

import java.io.IOException; 
 
 
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


import entity.Bank;



@WebServlet("/BankList")
public class BankList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   //BankDAO dao=new BankDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			List<Bank>	list=new ArrayList<>();
		Connection con=DBConnection.getConnection();
		String q="Select * from Bank";
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(q);
		
		while (rs.next()) {
			Bank bank=new Bank(rs.getInt(1),rs.getString(2));
			list.add(bank);
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/Index.jsp");
		rd.include(request, response);
		out.println("<html><head><style>table,th,td{\r\n" + 
				"        border: 1px;\r\n" + 
				"        background-color: white;\r\n" + 
				"      }</style></head><body><center>");
		out.println("<Table cellpadding='5' cellspacing='5'>");
		out.println(" <tr><th>Sr-no</th><th>Bank Name</th></tr></br>");
	
		for(Bank b:list)
		{
			out.println("<tr><td>"+b.getBankId()+"</td>		<td><a href="+b.getBankName()+">"+b.getBankName()+"</a></td><tr><br>");
		}
		out.println("</Table></center></body></html>");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
