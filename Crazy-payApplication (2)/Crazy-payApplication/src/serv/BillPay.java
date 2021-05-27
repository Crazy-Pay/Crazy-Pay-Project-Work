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

/**
 * Servlet implementation class BillPay
 */
@WebServlet("/BillPay")
public class BillPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
		String id=request.getParameter("id");
		String query="Select * from customer where M_Pin="+id;
		Connection con=DBConnection.getConnection();
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(query);
		if(rs.next()) {
		String name = rs.getString("CUST_NAME");
		double money= rs.getDouble("AMOUNT");
		out.print("<html>\r\n" + 
				"    <head>\r\n" + 
				"     <style>\r\n" + 
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
				".background{\r\n" + 
				"  background-image: url('img_girl.jpg');\r\n" + 
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
				"h2 {\r\n" + 
				"  text-align: center;\r\n" + 
				"  font-size: 16px;\r\n" + 
				"  font-weight: 600;\r\n" + 
				"  text-transform: uppercase;\r\n" + 
				"  display:inline-block;\r\n" + 
				"  margin: 40px 8px 10px 8px; \r\n" + 
				"  color: #cccccc;\r\n" + 
				"}\r\n" + 
				"h4 {\r\n" + 
				"  text-align: center;\r\n" + 
				"  font-size: 16px;\r\n" + 
				"  font-weight: 600;\r\n" + 
				"  text-transform: uppercase;\r\n" + 
				"  display:inline-block;\r\n" + 
				"  margin: 40px 8px 10px 8px; \r\n" + 
				"  color: black;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"#formContent {\r\n" + 
				"  -webkit-border-radius: 10px 10px 10px 10px;\r\n" + 
				"  border-radius: 10px 10px 10px 10px;\r\n" + 
				"  background: #fff;\r\n" + 
				"  padding: 30px;\r\n" + 
				"  width: 90%;\r\n" + 
				"  max-width: 450px;\r\n" + 
				"  position: relative;\r\n" + 
				"  padding: 0px;\r\n" + 
				"  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);\r\n" + 
				"  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);\r\n" + 
				"  text-align: center;\r\n" + 
				"}\r\n" + 
				"#formFooter {\r\n" + 
				"  background-color: #f6f6f6;\r\n" + 
				"  border-top: 1px solid #dce8f1;\r\n" + 
				"  padding: 25px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  -webkit-border-radius: 0 0 10px 10px;\r\n" + 
				"  border-radius: 0 0 10px 10px;\r\n" + 
				"}\r\n" + 
				"h2.inactive {\r\n" + 
				"  color: #cccccc;\r\n" + 
				"}\r\n" + 
				"h2.active {\r\n" + 
				"  color: #0d0d0d;\r\n" + 
				"  border-bottom: 2px solid #5fbae9;\r\n" + 
				"}\r\n" + 
				"input[type=button], input[type=submit], input[type=reset]  {\r\n" + 
				"  background-color: #56baed;\r\n" + 
				"  border: none;\r\n" + 
				"  color: white;\r\n" + 
				"  padding: 15px 80px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  text-decoration: none;\r\n" + 
				"  display: inline-block;\r\n" + 
				"  text-transform: uppercase;\r\n" + 
				"  font-size: 13px;\r\n" + 
				"  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);\r\n" + 
				"  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);\r\n" + 
				"  -webkit-border-radius: 5px 5px 5px 5px;\r\n" + 
				"  border-radius: 5px 5px 5px 5px;\r\n" + 
				"  margin: 5px 20px 40px 20px;  \r\n" + 
				"}\r\n" + 
				"input[type=button]:hover, input[type=submit]:hover, input[type=reset]:hover  {\r\n" + 
				"  background-color: #39ace7;\r\n" + 
				"}\r\n" + 
				"input[type=button]:active, input[type=submit]:active, input[type=reset]:active  {\r\n" + 
				"  -moz-transform: scale(0.95);\r\n" + 
				"  -webkit-transform: scale(0.95);\r\n" + 
				"  -o-transform: scale(0.95);\r\n" + 
				"  -ms-transform: scale(0.95);\r\n" + 
				"  transform: scale(0.95);\r\n" + 
				"}\r\n" + 
				"input[type=text] {\r\n" + 
				"  background-color: #f6f6f6;\r\n" + 
				"  border: none;\r\n" + 
				"  color: #0d0d0d;\r\n" + 
				"  padding: 15px 32px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  text-decoration: none;\r\n" + 
				"  display: inline-block;\r\n" + 
				"  font-size: 16px;\r\n" + 
				"  margin: 5px;\r\n" + 
				"  width: 85%;\r\n" + 
				"  border: 2px solid #f6f6f6;\r\n" + 
				"  \r\n" + 
				"  -webkit-border-radius: 5px 5px 5px 5px;\r\n" + 
				"  border-radius: 5px 5px 5px 5px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"input[type=text]:focus {\r\n" + 
				"  background-color: #fff;\r\n" + 
				"  border-bottom: 2px solid #5fbae9;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"input[type=text]:placeholder {\r\n" + 
				"  color: #cccccc;\r\n" + 
				"}\r\n" + 
				".fadeInDown {  \r\n" + 
				"  -webkit-animation-duration: 1s;\r\n" + 
				"  animation-duration: 1s;\r\n" + 
				"  -webkit-animation-fill-mode: both;\r\n" + 
				"  animation-fill-mode: both;\r\n" + 
				"  align-items:center;\r\n" + 
				"}\r\n" + 
				".underlineHover:after {\r\n" + 
				"  display: block;\r\n" + 
				"  left: 0;\r\n" + 
				"  bottom: -10px;\r\n" + 
				"  width: 0;\r\n" + 
				"  height: 2px;;\r\n" + 
				"  transition: width 0.2s;\r\n" + 
				"}\r\n" + 
				".underlineHover:hover {\r\n" + 
				"  color: #0d0d0d;\r\n" + 
				"}\r\n" + 
				".underlineHover:hover:after{\r\n" + 
				"  width: 100%;\r\n" + 
				"}\r\n" + 
				"*:focus {\r\n" + 
				"    outline: none;\r\n" + 
				"} \r\n" + 
				"#icon {\r\n" + 
				"  width:60%;\r\n" + 
				"}\r\n" + 
				"* {\r\n" + 
				"  box-sizing: border-box;\r\n" + 
				"}\r\n" + 
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
				"              <a href=\"UserAccount?id="+id+"\" class=\"img\"><img src=\"photo/11.png\" width=\"90px\" height=\"70px\"></a>  \r\n" + 
				"              </span>\r\n" + 
				"            </div>\r\n" + 
				"          </div>\r\n" + 
				"        </nav>\r\n" + 
				"       </header>\r\n" + 
				"                 \r\n" + 
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
				"                 <br><br>\r\n" + 
				"                      <div class=\"row\">\r\n" + 
				"                        <div class=\"col-md-6\">\r\n" + 
				"                          <div id=\"formContent\">\r\n" + 
				"                            <form class=\"effect\">\r\n" + 
				"                              <a href='MobileRecharge?id="+id+"' class=\"text\"><h4 class=\"active pt-4\" >Mobile Recharge</h4><br/><br/><img src=\"photo/mobilerecharge.png\"   width=\"200px\" height=\"250px\" class=\"image\"></a> <br/><br/>\r\n" + 
				"                            </form>  \r\n" + 
				"                           </div>\r\n" + 
				"                         </div>\r\n" + 
				"                        <div class=\"col-md-6\">\r\n" + 
				"                          <div id=\"formContent\">\r\n" + 
				"                            <form  class=\"effect\">\r\n" + 
				"                              <a href='ElectricityBill?id="+id+"'  class=\"text\"><h4 class=\"active pt-4\" >Electricity Bill</h4><br/><br/><img src=\"photo/electricitybill.png\"   width=\"200px\" height=\"250px\" class=\"image\"></a> <br/><br/>\r\n" + 
				"                            </form>   \r\n" + 
				"                        </div>\r\n" + 
				"                      </div>\r\n" + 
				"                     <br/><br/>\r\n" + 
				"                    \r\n" + 
				"                 \r\n" + 
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
