import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "訂購資料確認";
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\n" + "<HTML>\n"
				+ "<HEAD><TITLE>" + title + "</TITLE>");
		out.println(
				"<STYLE>table { margin: 25px; font-family: DFKai-sb; background-color: rgb(252, 238, 233); border-collapse: collapse; border: 1px solid black; margin-left: auto; margin-right: auto;}</STYLE>");
		out.println("</HEAD><BODY>\n");
		out.println("<table><tr><td><H2 ALIGN=CENTER>" + title + "</H2>\n");
		out.println("訂購人姓名：");
		out.println(request.getParameter("name") + "<br>");
		out.println("<br>連絡電話：");
		out.println(request.getParameter("phone") + "<br>");
		out.println("<br>E-mail：");
		out.println(request.getParameter("email") + "<br>");
		out.println("<br>領取方式：");
		out.println(this.transferBlankValue("t", request) + " " + request.getParameter("dt1").replace("T", " ")
				+ request.getParameter("address") + "<br>");
		out.println("<br>蛋糕主題：");
		out.println(this.transferBlankValue("topic", request) + request.getParameter("other") + "<br>");
		out.println("<br>蛋糕口味選擇：");
		out.println(this.transferBlankValue("cake", request) + "<br>");
		out.println("<br>蛋糕內餡選擇：");
		String[] stuffing = request.getParameterValues("stuf");
		if (stuffing == null || stuffing.length == 0) {
			out.println("無" + "<br>");
		} else {
			for (int i = 0; i < stuffing.length; i++) {
				out.println(stuffing[i]);
			}
			out.println("<br>");
		}
		out.println("<br>是否為生日蛋糕：");
		out.println(this.transferBlankValue("yn", request) + "<br>");
		out.println("<br>蠟燭數字：");
		out.println(this.transferBlankValue("number", request) + "<br>");
		out.println("<br>特別需求：");
		out.println(this.transferBlankValue("spnd", request) + "<br><br><br>");

		out.println("訂購步驟已完成，感謝您的支持!" + "<br>");
		out.println("請稍後片刻，我們將會回傳訂購確認通知至訂購人的信箱。<br><br></td></tr></table>");
		out.println("</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String transferBlankValue(String key, HttpServletRequest request) {
		String value = request.getParameter(key);
		if (value == null || "".equals(value.trim())) {
			return "無";
		}
		return value;
	}

}