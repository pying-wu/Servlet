

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterFormServlet
 */
@WebServlet("/RegisterFormServlet")
public class RegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
	    String title = "報名資料確認";
	    out.println(
	    		    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	 			    "Transitional//EN\n" +
	 	            "<HTML>\n" +
	 	            "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" + 
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=CENTER>" + title + "</H1>\n"
	               );
	    out.println("姓名：<br>");
	    out.println(request.getParameter("name")+"<br>");
	    out.println("<br><br>畢業學校：<br>");
	    out.println(request.getParameter("school")+"<br>");
	    out.println("<br><br>畢業科系：<br>");
	    out.println(request.getParameter("department")+"<br>");
	    out.println("<br><br>性別：<br>");
	    out.println(request.getParameter("gender")+"<br>");
	    out.println("<br><br>交通工具：<br>");
	    
	    String[] vehicles = request.getParameterValues("vehicle");
	    
	    for (int i=0; i<vehicles.length; i++)
	    	out.println(vehicles[i]+"<br>");    
	    
	    out.println("</BODY></HTML>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
