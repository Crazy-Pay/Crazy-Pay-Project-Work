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
@WebServlet("/TransferValidation")
public class TransferValidation extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        PrintWriter out=response.getWriter();
        
        System.out.println("Hello");
        String number=request.getParameter("num");
        String id=request.getParameter("id");
        double rupees=Double.parseDouble(request.getParameter("login"));
        
        String rupees2=request.getParameter("login");
        
        RequestDispatcher rd=request.getRequestDispatcher("MpinValidation2?id="+id+"&mb="+number+"&rupees2="+rupees2);
        rd.forward(request, response);
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}