package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateHDFC
 */
@WebServlet("/ValidateHDFC")
public class ValidateHDFC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body><center>");
		try {
		Connection con=DBConnection.getConnection();
		//	Statement statement = connection.createStatement();
		
        String sql = "SELECT * FROM HDFC where MOBILE_NO=? AND BIRTH_DATE=?";
        
        String Bname="HDFC";
        System.out.println("hi");
        PreparedStatement pmt=con.prepareStatement(sql);
        String id1=request.getParameter("id");
		String phone=request.getParameter("number");
		System.out.println(phone);
		String bday=request.getParameter("date");
		System.out.println(bday);
		
        pmt.setString(1, phone);
        pmt.setString(2, bday);
        int n =  pmt.executeUpdate();
        
      // ServletContext context=getServletContext();
      // context.setAttribute("id", id1);
        
        if(n>0) {
        	System.out.print("AA");
				out.println("<html>\r\n" + 
						"    <head>\r\n" + 
						"    <style>\r\n" + 
						"      select{\r\n" + 
						"        align-items: center;\r\n" + 
						"            align-self: center;\r\n" + 
						"            align-content: center;\r\n" + 
						"            \r\n" + 
						"      }\r\n" + 
						"        form{\r\n" + 
						"            align-items: center;\r\n" + 
						"            align-self: center;\r\n" + 
						"            align-content: center;\r\n" + 
						"           \r\n" + 
						"        }\r\n" + 
						"        a.nav-link:hover{\r\n" + 
						"  background-color: #56baed;\r\n" + 
						"}\r\n" + 
						"html {\r\n" + 
						"  background-color: #56baed;\r\n" + 
						"}\r\n" + 
						"body {\r\n" + 
						"  font-family: \"Poppins\", sans-serif;\r\n" + 
						"  height: 100vh;\r\n" + 
						"  \r\n" + 
						" background: #00c6ff; /* fallback for old browsers */\r\n" + 
						"  background: -webkit-linear-gradient(to right, #00c6ff, #0072ff); /* Chrome 10-25, Safari 5.1-6 */\r\n" + 
						"  background: linear-gradient(to right, #00c6ff, #0072ff); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */\r\n" + 
						"}\r\n" + 
						"a {\r\n" + 
						"  color: #92badd;\r\n" + 
						"  display:inline-block;\r\n" + 
						"  text-decoration: none;\r\n" + 
						"  font-weight: 400;\r\n" + 
						"}\r\n" + 
						"h2 {\r\n" + 
						"  text-align: center;\r\n" + 
						"  font-size: 16px;\r\n" + 
						"  font-weight: 600;\r\n" + 
						"  text-transform: uppercase;\r\n" + 
						"  display:inline-block;\r\n" + 
						"  margin: 40px 8px 10px 8px; \r\n" + 
						"  color: #cccccc;\r\n" + 
						"}\r\n" + 
						"\r\n" + 
						"/* STRUCTURE */\r\n" + 
						".wrapper {\r\n" + 
						"  display: flex;\r\n" + 
						"  align-items: center;\r\n" + 
						"  flex-direction: column; \r\n" + 
						"  justify-content: center;\r\n" + 
						"  width: 100%;\r\n" + 
						"  min-height: 100%;\r\n" + 
						"  padding: 20px;\r\n" + 
						"}\r\n" + 
						"#formContent {\r\n" + 
						"  -webkit-border-radius: 10px 10px 10px 10px;\r\n" + 
						"  border-radius: 10px 10px 10px 10px;\r\n" + 
						"  background: #fff;\r\n" + 
						"  padding: 30px;\r\n" + 
						"  width: 100%;\r\n" + 
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
						"\r\n" + 
						"/* TABS */\r\n" + 
						"h2.inactive {\r\n" + 
						"  color: #cccccc;\r\n" + 
						"}\r\n" + 
						"h2.active {\r\n" + 
						"  color: #0d0d0d;\r\n" + 
						"  border-bottom: 2px solid #5fbae9;\r\n" + 
						"}\r\n" + 
						"\r\n" + 
						"/* FORM TYPOGRAPHY*/\r\n" + 
						"input[type=button], input[type=submit], input[type=reset] {\r\n" + 
						"  background-color: #39ace7;\r\n" + 
						"  border: none;\r\n" + 
						"  color: white;\r\n" + 
						"  padding: 15px 80px;\r\n" + 
						"  align-items:center;\r\n" + 
						"  text-align: center;\r\n" + 
						"  align-content: center;\r\n" + 
						"  text-decoration: none;\r\n" + 
						"  display: inline-block;\r\n" + 
						"  text-transform: uppercase;\r\n" + 
						"  font-size: 13px;\r\n" + 
						"  -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);\r\n" + 
						"  box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);\r\n" + 
						"  -webkit-border-radius: 5px 5px 5px 5px;\r\n" + 
						"  border-radius: 5px 5px 5px 5px;\r\n" + 
						"  margin: 5px 20px 40px 20px;\r\n" + 
						"  -webkit-transition: all 0.3s ease-in-out;\r\n" + 
						"  -moz-transition: all 0.3s ease-in-out;\r\n" + 
						"  -ms-transition: all 0.3s ease-in-out;\r\n" + 
						"  -o-transition: all 0.3s ease-in-out;\r\n" + 
						"  transition: all 0.3s ease-in-out;\r\n" + 
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
						"input[type=text],input[type=password] {\r\n" + 
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
						"  -webkit-transition: all 0.5s ease-in-out;\r\n" + 
						"  -moz-transition: all 0.5s ease-in-out;\r\n" + 
						"  -ms-transition: all 0.5s ease-in-out;\r\n" + 
						"  -o-transition: all 0.5s ease-in-out;\r\n" + 
						"  transition: all 0.5s ease-in-out;\r\n" + 
						"  -webkit-border-radius: 5px 5px 5px 5px;\r\n" + 
						"  border-radius: 5px 5px 5px 5px;\r\n" + 
						"}\r\n" + 
						"input[type=text]:focus {\r\n" + 
						"  background-color: #fff;\r\n" + 
						"  border-bottom: 2px solid #5fbae9;\r\n" + 
						"}\r\n" + 
						"input[type=text]:placeholder {\r\n" + 
						"  color: #cccccc;\r\n" + 
						"}\r\n" + 
						"\r\n" + 
						"/* ANIMATIONS */\r\n" + 
						"/* Simple CSS3 Fade-in-down Animation */\r\n" + 
						".fadeInDown {\r\n" + 
						" \r\n" + 
						"  -webkit-animation-duration: 1s;\r\n" + 
						"  animation-duration: 1s;\r\n" + 
						"  -webkit-animation-fill-mode: both;\r\n" + 
						"  animation-fill-mode: both;\r\n" + 
						"  align-items:center;\r\n" + 
						"  \r\n" + 
						"}\r\n" + 
						"\r\n" + 
						"/* Simple CSS3 Fade-in Animation */\r\n" + 
						".underlineHover:after {\r\n" + 
						"  display: block;\r\n" + 
						"  left: 0;\r\n" + 
						"  bottom: -10px;\r\n" + 
						"  width: 0;\r\n" + 
						"  height: 2px;\r\n" + 
						"  background-color: #56baed;\r\n" + 
						"  content: \"\";\r\n" + 
						"  transition: width 0.2s;\r\n" + 
						"}\r\n" + 
						".underlineHover:hover {\r\n" + 
						"  color: #0d0d0d;\r\n" + 
						"}\r\n" + 
						".underlineHover:hover:after{\r\n" + 
						"  width: 90%;\r\n" + 
						"}\r\n" + 
						"\r\n" + 
						"/* OTHERS */\r\n" + 
						"*:focus {\r\n" + 
						"    outline: none;\r\n" + 
						"} \r\n" + 
						"#icon {\r\n" + 
						"  width:100%;\r\n" + 
						"}\r\n" + 
						"* {\r\n" + 
						"  box-sizing: border-box;\r\n" + 
						"}\r\n" + 
						"nav-link:hover{\r\n" + 
						"background-color:#56baed ;\r\n" + 
						"}\r\n" + 
						".activated{\r\n" + 
						"            display: block !important;\r\n" + 
						"        }\r\n" + 
						"    </style>\r\n" + 
						"   \r\n" + 
						"    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0\" crossorigin=\"anonymous\">\r\n" + 
						"</head>\r\n" + 
						"    <body style=\"background-color: #56baed;\">\r\n" + 
						"        <header>\r\n" + 
						"            <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n" + 
						"              <div class=\"container-fluid\">\r\n" + 
						"                <img src=\"1.png\" width=\"150\" height=\"75\">\r\n" + 
						"                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNavDropdown\" aria-controls=\"navbarNavDropdown\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
						"                  <span class=\"navbar-toggler-icon\"></span>\r\n" + 
						"                </button>\r\n" + 
						"                <div class=\"collapse navbar-collapse\" id=\"navbarNavDropdown\">\r\n" + 
						"                  <ul class=\"navbar-nav\">\r\n" + 
						"                    \r\n" + 
						"                    <li class=\"nav-item\">\r\n" + 
						"                      <a class=\"nav-link\" href=\"login1.html\" style=\"font-size:large;color: black;\">Login</a>\r\n" + 
						"                    </li>\r\n" + 
						"                    <li class=\"nav-item\">\r\n" + 
						"                      <a class=\"nav-link\" href=\"#\" style=\"font-size:large;color: black;\">Features</a>\r\n" + 
						"                    </li>\r\n" + 
						"                    <li class=\"nav-item\">\r\n" + 
						"                        <a class=\"nav-link\" href=\"#\" style=\"font-size:large;color: black;\">Do's & Don't</a>\r\n" + 
						"                      \r\n" + 
						"                      <li class=\"nav-item\">\r\n" + 
						"                        <a class=\"nav-link\" href=\"#\" style=\"font-size:large;color: black;\">FAQ</a>\r\n" + 
						"                      </li>\r\n" + 
						"                  </header>\r\n" + 
						"                 \r\n" + 
						"                  <br>\r\n" + 
						"                  <br>\r\n" + 
						"      <center>\r\n" + 
						"          <form action='MPinSBI' method='post'>\r\n" + 
						"             <br>\r\n" + 
						"             \r\n" + 
						"              <div id=\"formContent\">\r\n" + 
						"              \r\n" + 
						"                <h4 class=\"active pt-4\" id=\"floatingSelect\"> Create M-Pin</h4>\r\n" + 
						"                <br><input type=\"password\" class=\"fadeIn third\" name=\"login\" placeholder=\"Enter New M-Pin\" id=\"account\" pattern=\"[0-9]{4}\" maxlength=\"6\"><br>\r\n" + 
						"                <br><input type=\"password\" class=\"fadeIn third\" name=\"login\" placeholder=\"Re-Enter M-Pin\" id=\"account\" pattern=\"[0-9]{4}\" maxlength=\"6\"><br>\r\n" + 
										"<br><input type='hidden' value='"+id1+"' name='id'>"+
										"<br><input type='hidden' value='"+Bname+"' name='bankName'>"+

						"                <br><input type=\"submit\" class=\"fadeIn fourth btn btn-primary\" value=\"Create\"  data-bs-toggle=\"modal\" data-bs-target=\"#exampleModal\" id=\"account\"><br/><br/><br/>\r\n" + 

						"            </form> \r\n" + 
						"                \r\n" + 
						"            \r\n" + 
						"                <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\r\n" + 
						"                    <div class=\"modal-dialog\">\r\n" + 
						"                      <div class=\"modal-content\">\r\n" + 
						"                        <div class=\"modal-header\">\r\n" + 
						"                          <h5 class=\"modal-title\" id=\"exampleModalLabel\">M-Pin Status</h5>\r\n" + 
						"                          <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n" + 
						"                        </div>\r\n" + 
						"                        <div class=\"modal-body\">\r\n" + 
						"                          M-Pin Generated Successfully\r\n" + 
						"                        </div>\r\n" + 
						"                        <div class=\"modal-footer\">\r\n" + 
						"                            <a href=\"login1.html\"><input type=\"button\" value=\"Go back to Login Page\"></a>\r\n" + 
						"                        </div>\r\n" + 
						"                      </div>\r\n" + 
						"                      </div>\r\n" + 
						"            \r\n" + 
						"              </div>\r\n" + 
						"            </div>\r\n" + 
						"          </div>\r\n" + 
						"            \r\n" + 
						"          </div>\r\n" + 
						"          \r\n" + 
						"        </center>\r\n" + 
						"          <script  src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8\" crossorigin=\"anonymous\"></script>\r\n" + 
						"    </body>\r\n" + 
						"</html>");
			}
		
		
		else 
		{
			out.println("<script>"
					+ "alert('invalid Mobile Number and Date of Birth')"
					+ "</script>");
		}
	
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

			
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
