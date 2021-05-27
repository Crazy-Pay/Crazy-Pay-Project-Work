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

@WebServlet("/TransValidationAccno")
public class TransValidationAccno extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        try {
        System.out.println("Hello");
        String id=request.getParameter("id");
        String number=request.getParameter("name");
        double rupees=Double.parseDouble(request.getParameter("login"));
        String rupees2=request.getParameter("login");
        System.out.println(number);
        System.out.println(rupees);
        String query="Select * from Customer where Acc_no="+number;
        Connection con=DBConnection.getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        PreparedStatement pstm=con.prepareStatement(query);
        int n=pstm.executeUpdate();
        
        
        String query2="Select * from Customer where M_PIN="+id;
        Statement stmt2=con.createStatement();
        ResultSet rs2=stmt2.executeQuery(query2);
        PreparedStatement pstm2=con.prepareStatement(query2);
        int n2=pstm2.executeUpdate();
        while(rs2.next()) {
            double var2=rs2.getDouble("Amount");
            if(var2 >= rupees) {
            	System.out.println(var2);
                double res2=var2-rupees;
                System.out.println(res2);
                String sq2="update customer set Amount=? where M_PIN=?";
                PreparedStatement pstm3=con.prepareStatement(sq2);
                pstm3.setDouble(1, res2);
                pstm3.setString(2, id);
                int n3=pstm3.executeUpdate();
                
        if(n!=0)
        {
            
            while(rs.next())
            {
                double var=rs.getDouble("Amount");
                System.out.println(var);
                double res=var+rupees;
                System.out.println(res);
                String sq="update customer set Amount=? where Acc_no=?";
                PreparedStatement pstm1=con.prepareStatement(sq);
                pstm1.setDouble(1, res);
                pstm1.setString(2, number);
                int n1=pstm1.executeUpdate();
                
                if(n1!=0)
                {
                    System.out.println("Transaction Completed");
                    
                    RequestDispatcher rd=request.getRequestDispatcher("mpinValidation?id="+id);
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
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
        
    
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
    }
}