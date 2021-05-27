package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RechargeValidation")
public class RechargeValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
		String id1=request.getParameter("id");
		double rup=Double.parseDouble(request.getParameter("login"));
		String query="Select * from Customer where M_pin="+id1;
		Connection con=DBConnection.getConnection();
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(query);
		PreparedStatement pstm=con.prepareStatement(query);
		int n=pstm.executeUpdate();
		if(n!=0)
		{
			while(rs.next())
			{
				double amo=rs.getDouble("Amount");
				System.out.println(amo);
				double ans=amo-rup;
				String sq="update customer set Amount=? where M_pin=?";
				PreparedStatement ps=con.prepareStatement(sq);
				ps.setDouble(1, ans);
				ps.setString(2, id1);
				int n1=ps.executeUpdate();
				if(n1!=0)
				{
					System.out.println("Payment done");
					
					RequestDispatcher rd=request.getRequestDispatcher("mpinValidation");
					rd.forward(request, response);
				}
			}
		}
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
