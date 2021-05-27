package serv;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BillValidation")
public class BillValidation extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        try {
        String mpin=request.getParameter("id");
        double rup=Double.parseDouble(request.getParameter("login"));
        String rup1=request.getParameter("login");
        String sname = request.getParameter("sname");
        System.out.println(mpin+" "+rup+" "+sname);

        RequestDispatcher rd=request.getRequestDispatcher("mpinValidation?id="+mpin+"&amount="+rup1+"&sname="+sname);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
        
        
        
        
        
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
        
        
    }
}