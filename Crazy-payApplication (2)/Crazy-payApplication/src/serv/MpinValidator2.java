package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MpinValidator2
 */
@WebServlet("/MpinValidator2")
public class MpinValidator2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String number=request.getParameter("mobileNo");
		String rupees1=request.getParameter("rupees");
		String mpin=request.getParameter("pass");
		
		System.out.println(mpin);
		System.out.println(id+"  "+number+"  "+rupees1);
		double rupees=Double.parseDouble(rupees1);
		System.out.println(rupees1);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();
	    if(mpin.equals(id)) {
		        System.out.println(number);
		        System.out.println(rupees);
		        String query="Select * from Customer where Acc_no="+number+" OR MOBILE_NO="+number;
		        Connection con=DBConnection.getConnection();
		        Statement stmt=con.createStatement();
		        ResultSet rs=stmt.executeQuery(query);
		        
		        PreparedStatement pstm=con.prepareStatement(query);
		        int n=pstm.executeUpdate();
		        
		        System.out.println("Hello world1");
		        
		        String query2="Select * from Customer where M_PIN="+id;
		        Statement stmt2=con.createStatement();
		        ResultSet rs2=stmt2.executeQuery(query2);
		        PreparedStatement pstm2=con.prepareStatement(query2);
		        int n2=pstm2.executeUpdate();
		        while(rs2.next()) {
		            double var2=rs2.getDouble("Amount");
		            String accno=rs2.getString("ACC_NO");
		            String nam=rs2.getString("Cust_name");
		            if(var2 >= rupees) {
		                System.out.println(var2);
		                double res2=var2-rupees;
		                System.out.println(res2);
		                String sq2="update customer set Amount=? where M_PIN=?";
		                PreparedStatement pstm3=con.prepareStatement(sq2);
		                pstm3.setDouble(1, res2);
		                pstm3.setString(2, id);
		                int n3=pstm3.executeUpdate();
		                System.out.println("hello world2");
		                
		        if(n!=0)
		        {
		            
		            
		            while(rs.next())
		            {
		                String none=rs.getString("Cust_name");
		                double var=rs.getDouble("Amount");
		                String accno1=rs.getString("ACC_NO");
		                System.out.println(var);
		                double res=var+rupees;
		                System.out.println(res);
		                String sq="update customer set Amount=? where Acc_no=? OR MOBILE_NO=?";
		                PreparedStatement pstm1=con.prepareStatement(sq);
		                pstm1.setDouble(1, res);
		                pstm1.setString(2, number);
		                pstm1.setString(3, number);

		                int n1=pstm1.executeUpdate();
		                
		                if(n1!=0)
		                {
		                    System.out.println("Transaction Completed");
		                    
		                    
		                    System.out.println(nam+" "+none+" "+accno+" "+number+" "+rupees);
		                    String str="insert into TransactionHistory(MoneyFrom, MoneyTo, AccountFrom, AccountTo, TransactionDate, Amount) values(?,?,?,?,?,?)";
		                    PreparedStatement pst=con.prepareStatement(str);
		                    pst.setString(1, nam);
		                    pst.setString(2, none);
		                    pst.setString(3, accno);
		                    pst.setString(4, accno1);
		                    pst.setString(5, dtf.format(now));
		                    pst.setDouble(6, rupees);
		                    int num=pst.executeUpdate();
		                    if(num!=0)
		                    {
		                        System.out.println("Fired Insert Successfully");
		                        
		                    }
		                    
		                    
		                    
		                    RequestDispatcher rd=request.getRequestDispatcher("transction.html");
		                    rd.forward(request, response);
		                }
		                
		            }
		        }
		        else {
		            RequestDispatcher rd=request.getRequestDispatcher("MoneyTran");
		            rd.include(request, response);
		            out.println("<html><body><center><h4>The entered Mobile Number is Invalid!</h4></center></body></html>");
		        }
		        
		            }else {
		                RequestDispatcher rd=request.getRequestDispatcher("MoneyTran");
		                rd.include(request, response);
		                out.println("<html><body><center><h4>insufficient amount in wallet!</h4></center></body></html>");
		            }
		        }
	    }else {
	    	 RequestDispatcher rd=request.getRequestDispatcher("MpinValidation2");
	            rd.include(request, response);
                out.println("<html><body><center> Invalid Mpin entered. <h4></h4></center></body></html>");

	    }
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
		        
		    }
		    
		 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
