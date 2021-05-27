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

@WebServlet("/MpinValidator")
public class MpinValidator extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
    	  PrintWriter out=response.getWriter();
      
        String mpin=request.getParameter("id");
        String mp=request.getParameter("login");
        String rupees=request.getParameter("amount");
        String sname=request.getParameter("sname");
        
        double rup=Double.parseDouble(rupees);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
      
        String query="Select * from Customer where M_pin="+mpin;
        Connection con=DBConnection.getConnection();
        Statement stm=con.createStatement();
        ResultSet rs=stm.executeQuery(query);
        PreparedStatement pstm=con.prepareStatement(query);
        int n=pstm.executeUpdate();
        if(mp.equals(mpin))
        {
        	
            while(rs.next())
            {
                String name=rs.getString("Cust_name");
                String acc=rs.getString("ACC_NO");
                double amo=rs.getDouble("Amount");
                
                if(amo>=rup) {
                System.out.println(amo);
                double ans=amo-rup;
                String sq="update customer set Amount=? where M_pin=?";
                PreparedStatement ps=con.prepareStatement(sq);
                ps.setDouble(1, ans);
                ps.setString(2, mpin);
                int n1=ps.executeUpdate();
                if(n1!=0)
                    
                {
                    System.out.println("Payment done");
                    
                    String sql="insert into TransactionHistory(MoneyFrom, MoneyTo, AccountFrom, AccountTo, TransactionDate, Amount) values(?,?,?,?,?,?)";
                    PreparedStatement pst=con.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, sname);
                    pst.setString(3, acc);
                    pst.setString(4, "-");
                    pst.setString(5, dtf.format(now));
                    pst.setDouble(6, rup);
                    int no=pst.executeUpdate();
                    if(no!=0)
                    {
                        System.out.println("Insert query fired");
                    }
                    
                    RequestDispatcher rd=request.getRequestDispatcher("transction.html");
                    rd.forward(request, response);
                }
                }else {
                	RequestDispatcher rd=request.getRequestDispatcher("mpinValidation");
	                rd.include(request, response);
	                out.println("<html><body><center><h4>insufficient amount in wallet!</h4></center></body></html>");
                }
            }
        
        }

        
        
        else {
            RequestDispatcher rd=request.getRequestDispatcher("mpinValidation");
            rd.include(request, response);
            
            out.println("<html><body><center><p>Invalid m-pin Entered!</p></center></body></html>");
        }
      }catch(Exception e) {
    	  e.printStackTrace();
      }
    
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}