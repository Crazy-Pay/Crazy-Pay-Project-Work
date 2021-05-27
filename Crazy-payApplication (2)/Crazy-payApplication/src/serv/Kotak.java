package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Kotak")
public class Kotak extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	    out.print("<!DOCTYPE html>\r\n" + 
	            "<html>\r\n" + 
	            "<head>\r\n" + 
	            "    <style>\r\n" + 
	            "        @import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');\r\n" + 
	            "\r\n" + 
	            "* {\r\n" + 
	            "   box-sizing: border-box;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "body {\r\n" + 
	            "   background: #56baed;\r\n" + 
	            "   display: flex;\r\n" + 
	            "   justify-content: center;\r\n" + 
	            "   align-items: center;\r\n" + 
	            "   flex-direction: column;\r\n" + 
	            "   font-family: 'Montserrat', sans-serif;\r\n" + 
	            "   height: 100vh;\r\n" + 
	            "   margin: -20px 0 50px;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "h1 {\r\n" + 
	            "   font-weight: bold;\r\n" + 
	            "   margin: 0;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "p {\r\n" + 
	            "   font-size: 14px;\r\n" + 
	            "   font-weight: 100;\r\n" + 
	            "   line-height: 20px;\r\n" + 
	            "   letter-spacing: 0.5px;\r\n" + 
	            "   margin: 20px 0 30px;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "span {\r\n" + 
	            "   font-size: 12px;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "a {\r\n" + 
	            "   color: #333;\r\n" + 
	            "   font-size: 14px;\r\n" + 
	            "   text-decoration: none;\r\n" + 
	            "   margin: 15px 0;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "button {\r\n" + 
	            "   border-radius: 20px;\r\n" + 
	            "   border: 1px solid #56baed;\r\n" + 
	            "   background-color: #56baed;\r\n" + 
	            "   color: #FFFFFF;\r\n" + 
	            "   font-size: 12px;\r\n" + 
	            "   font-weight: bold;\r\n" + 
	            "   padding: 12px 45px;\r\n" + 
	            "   letter-spacing: 1px;\r\n" + 
	            "   text-transform: uppercase;\r\n" + 
	            "   transition: transform 80ms ease-in;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "form {\r\n" + 
	            "   background-color: #FFFFFF;\r\n" + 
	            "   display: flex;\r\n" + 
	            "   align-items: center;\r\n" + 
	            "   justify-content: center;\r\n" + 
	            "   flex-direction: column;\r\n" + 
	            "   padding: 0 50px;\r\n" + 
	            "   height: 100%;\r\n" + 
	            "   text-align: center;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "input {\r\n" + 
	            "   background-color: #eee;\r\n" + 
	            "   border: none;\r\n" + 
	            "   padding: 12px 15px;\r\n" + 
	            "   margin: 8px 0;\r\n" + 
	            "   width: 100%;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            ".container {\r\n" + 
	            "   background-color: #fff;\r\n" + 
	            "   border-radius: 10px;\r\n" + 
	            "   box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);\r\n" + 
	            "   position: relative;\r\n" + 
	            "   overflow: hidden;\r\n" + 
	            "   width: 768px;\r\n" + 
	            "   max-width: 100%;\r\n" + 
	            "   min-height: 480px;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            ".form-container {\r\n" + 
	            "   position: absolute;\r\n" + 
	            "   top: 0;\r\n" + 
	            "   height: 100%;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            ".log-in-container {\r\n" + 
	            "   left: 0;\r\n" + 
	            "   width: 50%;\r\n" + 
	            "   z-index: 2;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "\r\n" + 
	            ".overlay-container {\r\n" + 
	            "   position: absolute;\r\n" + 
	            "   top: 0;\r\n" + 
	            "   left: 50%;\r\n" + 
	            "   width: 50%;\r\n" + 
	            "   height: 100%;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "\r\n" + 
	            ".overlay {\r\n" + 
	            "   background:#057bb6;\r\n" + 
	            "   background: -webkit-linear-gradient(to right, #057bb6, #057bb6);\r\n" + 
	            "   background: linear-gradient(to right, #057bb6, #057bb6);\r\n" + 
	            "   background-repeat: no-repeat;\r\n" + 
	            "   background-size: cover;\r\n" + 
	            "   background-position: 0 0;\r\n" + 
	            "   color: #FFFFFF;\r\n" + 
	            "   position: relative;\r\n" + 
	            "   left: -100%;\r\n" + 
	            "   height: 100%;\r\n" + 
	            "   width: 200%;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            ".overlay-panel {\r\n" + 
	            "   position: absolute;\r\n" + 
	            "   display: flex;\r\n" + 
	            "   align-items: center;\r\n" + 
	            "   justify-content: center;\r\n" + 
	            "   flex-direction: column;\r\n" + 
	            "   padding: 0 40px;\r\n" + 
	            "   text-align: center;\r\n" + 
	            "   top: 0;\r\n" + 
	            "   height: 100%;\r\n" + 
	            "   width: 50%;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "\r\n" + 
	            ".overlay-right {\r\n" + 
	            "   right: 0;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            "\r\n" + 
	            ".social-container {\r\n" + 
	            "   margin: 50px 0;\r\n" + 
	            "}\r\n" + 
	            "\r\n" + 
	            ".social-container a {\r\n" + 
	            "   border: 1px solid #DDDDDD;\r\n" + 
	            "   border-radius: 50%;\r\n" + 
	            "   display: inline-flex;\r\n" + 
	            "   justify-content: center;\r\n" + 
	            "   align-items: center;\r\n" + 
	            "   margin: 0 5px;\r\n" + 
	            "   height: 40px;\r\n" + 
	            "   width: 40px;\r\n" + 
	            "}\r\n" + 
	            "    </style>\r\n" + 
	            "   \r\n" + 
	            "</head>\r\n" + 
	            "<body>\r\n" + 
	            "   <div class=\"container\" id=\"container\">\r\n" + 
	            "       <div class=\"form-container log-in-container\">\r\n" + 
	            "           <form action='ValidateKotak' method='post'>\r\n" + 
	            "                <img src=\"photo/11.png\" width=\"200px\" height=\"150px\"><br>\r\n" + 
	            "               <h1>Welcome</h1>\r\n" + 
	            "               <br>\r\n" + 
	            "                \r\n" + 
	            "\r\n" + 
	            "               <input type=\"text\" placeholder=\"Enter Customer Id\" name=\"id\">\r\n"+
	            "               <input type=\"text\" placeholder=\"Enter Registered Mobile Number\" name=\"number\"/>\r\n" + 
	            "               <input type=\"text\" placeholder=\"Enter Date of Birth\" name=\"date\"/>\r\n" + 
	            "               <br><input type=\"submit\" value=\"Link\" style=\"background-color: #56baed;border: none;\r\n" + 
	            "                    color: white;\r\n" + 
	            "                    padding: 15px 32px;\r\n" + 
	            "                    text-align: center;\r\n" + 
	            "                    text-decoration: none;\r\n" + 
	            "                    display: inline-block;\r\n" + 
	            "                    font-size: 16px;\r\n" + 
	            "                    margin: 4px 2px;\r\n" + 
	            "                    cursor: pointer;\">\r\n" + 
	            "               \r\n" + 
	            "           </form>\r\n" + 
	            "       </div>\r\n" + 
	            "        <br>\r\n" + 
	            "        <br>\r\n" + 
	            "\r\n" + 
	            "       <div class=\"overlay-container\">\r\n" + 
	            "           <div class=\"overlay\">\r\n" + 
	            "               <div class=\"overlay-panel overlay-right\">\r\n" + 
	            "                   <img src=\"photo/Kotak.png\" width=\"250px\" height=\"250px\">\r\n" + 
	            "               </div>\r\n" + 
	            "           </div>\r\n" + 
	            "       </div>\r\n" + 
	            "   </div>\r\n" + 
	            "</body>\r\n" + 
	            "</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}