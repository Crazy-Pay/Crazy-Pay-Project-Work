package serv;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TransactionHistory")
public class TransactionHistory extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        try {
        String id=request.getParameter("id");
       
		String query="Select * from customer where M_Pin="+id;
		
		Connection con=DBConnection.getConnection();
		Statement smt=con.createStatement();
		ResultSet rs2=smt.executeQuery(query);
		if(rs2.next()) {
			String name=rs2.getString("Cust_Name");
		double money= rs2.getDouble("AMOUNT");
		String acc=rs2.getString("ACC_NO");
		
        String sql="Select * from TransactionHistory where ACCOUNTFROM="+acc+"";
        Statement stmt1=con.createStatement();
        ResultSet rs=stmt1.executeQuery(sql);
        
        
        out.println("<html>\r\n" + 
                "    <head>\r\n" + 
                "     <style>\r\n" + 
                "     \r\n" + 
                "table {\r\n" + 
                "  width: 100%;\r\n" + 
                "  background-color: white;\r\n" + 
                "  text-align: center;\r\n" + 
                "  border: 2px solid black;\r\n" + 
                "  border-collapse: collapse;\r\n" + 
                "}\r\n" + 
                "\r\n" + 
                ".classhover{\r\n" + 
                "  background-color: white;\r\n" + 
                "}\r\n" + 
                ".text{\r\n" + 
                "  color: #0d0d0d;\r\n" + 
                " }\r\n" + 
                ".image{\r\n" + 
                "  border: 2px solid black;\r\n" + 
                "  border-color: #0d0d0d;\r\n" + 
                "  align-items: center;\r\n" + 
                "}\r\n" + 
                "a.nav-link:hover{\r\n" + 
                "  background-color: #56baed;\r\n" + 
                "}\r\n" + 
                "body {\r\n" + 
                "  font-family: \"Poppins\", sans-serif;\r\n" + 
                "  height: 100vh;\r\n" + 
                "  background: #00c6ff;\r\n" + 
                "  background: -webkit-linear-gradient(to right, #00c6ff, #0072ff);\r\n" + 
                "  background: linear-gradient(to right, #00c6ff, #0072ff);\r\n" + 
                "  }\r\n" + 
                "\r\n" + 
                "a {\r\n" + 
                "  color: #92badd;\r\n" + 
                "  display:inline-block;\r\n" + 
                "  text-decoration: none;\r\n" + 
                "  font-weight: 400;\r\n" + 
                "}\r\n" + 
                "\r\n" + 
                "nav-link:hover{\r\n" + 
                "background-color:#56baed ;\r\n" + 
                "}\r\n" + 
                ".effect:hover{\r\n" + 
                "  transform: scale(1.01);\r\n" + 
                "  box-shadow:  6px 6px 12px whitesmoke,-6px -6px 12px whitesmoke;\r\n" + 
                "}\r\n" + 
                "    </style>\r\n" + 
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0\" crossorigin=\"anonymous\">\r\n" + 
                "</head>\r\n" + 
                "    <body>\r\n" + 
                "      <header>\r\n" + 
                "        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n" + 
                "          <div class=\"container-fluid\">\r\n" + 
                "            <a class=\"navbar-brand\" href=\"login.jsp\"><img src=\"photo/crazzy.png\" width=\"150\" height=\"75\"></a>\r\n" + 
                "            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarText\" aria-controls=\"navbarText\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
                "              <span class=\"navbar-toggler-icon\"></span>\r\n" + 
                "            </button>\r\n" + 
                "            <div class=\"collapse navbar-collapse\" id=\"navbarText\">\r\n" + 
                "              <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n" + 
                "                <li class=\"nav-item\">\r\n" + 
                "                  <a class=\"nav-link\" href=\"#\" style=\"font-size:large;color: black;\" class=\"btn btn-primary\" data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\">Account Balance</a>\r\n" + 
                "                </li>\r\n" + 
                "                <li class=\"nav-item\">\r\n" + 
                "                  <a class=\"nav-link\" href=\"Report.html\" style=\"font-size:large;color: black;\">Report</a>\r\n" + 
                "                </li>\r\n" + 
                "                <li class=\"nav-item\">\r\n" + 
                "                  <a class=\"nav-link\" href=\"login.jsp\" style=\"font-size:large;color: black;\">Log-Out</a>\r\n" + 
                "                </li>\r\n" + 
                "              </ul>\r\n" + 
                "              <span class=\"navbar-text\" style=\"font-size:large;color: black;\">\r\n" + 
                "                Hi "+name+"\r\n" + 
                "              </span>\r\n" + 
                "              <span class=\"navbar-text\">\r\n" + 
                "              <img src=\"photo/11.png\" width=\"90px\" height=\"70px\">  \r\n" + 
                "              </span>\r\n" + 
                "            </div>\r\n" + 
                "          </div>\r\n" + 
                "        </nav>\r\n" + 
                "       </header>\r\n" + 
                "       <div class=\"row\">\r\n" + 
                "        <div class=\"col-md-1\">\r\n" + 
                "        </div>\r\n" + 
                "        <div class=\"col-md-10\">\r\n" + 
                "         <center>\r\n" + 
                "          <br><h1>Transaction History</h1>\r\n" + 
                "         </center> \r\n" + 
                "          <br><table class=\"table table-striped\" id=\"table\" border=\"2\">\r\n" + 
                "              <tr>\r\n" + 
                "                <th>Debiter Name</th>\r\n" + 
                "                <th>Crediter Name</th>\r\n" + 
                "                <th>Sender Account Number</th>\r\n" + 
                "                <th>Reciever Account Number</th>\r\n" + 
                "                <th>Transaction Date & Time</th>\r\n" + 
                "                <th>Amount</th>\r\n" + 
                "              </tr>\r\n"); 
                
                while(rs.next())
                {
                    out.println("<tr>"
                            + "<td>"+rs.getString("MoneyFrom")+"</td>"
                                    + "<td>"+rs.getString("MoneyTo")+"</td>"
                                        + "<td>"+rs.getString("ACCOUNTFROM")+"</td>"
                                            + "<td>"+rs.getString("ACCOUNTTO")+"</td>"
                                                    + "<td>"+rs.getString("TRANSACTIONDATE")+"</td>"
                                                            + "<td>"+rs.getDouble("AMOUNT")+"</td>"
                                + "</tr>");
                    
                }
                
                
                out.println("</table>\r\n" + 
                "        </div>  \r\n" + 
                "                  <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n" + 
                "                    <div class=\"modal-dialog\">\r\n" + 
                "                      <div class=\"modal-content\">\r\n" + 
                "                        <div class=\"modal-header\">\r\n" + 
                "                          <h5 class=\"modal-title\" id=\"exampleModalLabel\">Account Balance</h5>\r\n" + 
                "                          <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n" + 
                "                        </div>\r\n" + 
                "                        <div class=\"modal-body\">\r\n" + 
                "                          The total amount present is Rs."+money+"\r\n" + 
                "                        </div>\r\n" + 
                "                        <div class=\"modal-footer\">\r\n" + 
                "                          <button type=\"button\" class=\"btn btn-primary\" data-bs-dismiss=\"modal\">Close</button>\r\n" + 
                "                        </div>\r\n" + 
                "                      </div>\r\n" + 
                "                    </div>\r\n" + 
                "                  </div>\r\n" + 
                "                    \r\n" + 
                "      <center>\r\n" + 
                "                 \r\n" + 
                "                    \r\n" + 
                "                  <!-- <footer>\r\n" + 
                "                    <div style=\"background-color: white;\r\n" + 
                "                    left: 0;\r\n" + 
                "                    bottom: 0;\r\n" + 
                "                    width: 100%;\">\r\n" + 
                "                      <h4 style=\"color: #0d0d0d;\">Thank You for Visting Our Page</h4><br/>\r\n" + 
                "                      <h6>Contact Us email:-crazypay@info.com<br/>phone:-9911882277</h6>\r\n" + 
                "                    </div>\r\n" + 
                "                  </footer> -->\r\n" + 
                "                </center>\r\n" + 
                "                    \r\n" + 
                "          <script  src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8\" crossorigin=\"anonymous\"></script>\r\n" + 
                "\r\n" + 
                "    </body>\r\n" + 
                "</html>");
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