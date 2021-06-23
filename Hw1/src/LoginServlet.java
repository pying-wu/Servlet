import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * This servlet simply prints out HTTP method name and query string in it's service method.
 * 
 *
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;


 public void doGet(HttpServletRequest req, HttpServletResponse res)
   throws javax.servlet.ServletException, java.io.IOException {
  doPost(req, res);
 }

 public void doPost(HttpServletRequest req, HttpServletResponse res)
   throws javax.servlet.ServletException, java.io.IOException {
  req.setCharacterEncoding("UTF-8");
  res.setContentType("text/html;charset=UTF-8");
  PrintWriter out = res.getWriter();
  String title = "登入結果";
  out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\n" + "<HTML>\n"
    + "<HEAD><TITLE>" + title + "</TITLE>   <style>\r\n"
    		+ "     body{\r\n"
    		+ "     background-color:rgb(214, 250, 249);\r\n"
    		+ "     text-align:center;\r\n"
    		+ "     }\r\n"
    		+ "     </style></HEAD><BODY>\n");

  ServletConfig config = this.getServletConfig();
  String xmlusername = config.getInitParameter("username");
  String xmlpassword = config.getInitParameter("password");
  String userid = req.getParameter("userid");
  String password = req.getParameter("password");

  if (userid != null && password != null && userid.equals(xmlusername) && password.equals(xmlpassword)) {
   out.println("登入成功!");
  } else {
   out.println("登入失敗!");
  }
  out.println("</BODY></HTML>");
 }
}