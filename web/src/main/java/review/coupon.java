package review;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class coupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String cpnum[] = { "A1316B1004", "C4024A0096", "B1987C3136" };
	PrintWriter pw = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
		try {
			this.pw = response.getWriter();
			String mid = request.getParameter("mid");
			String cou = request.getParameter("cou");
			ArrayList<String> number = new ArrayList<String>(Arrays.asList(this.cpnum));
			
			if(!number.contains(cou)) {
				int cou2 = Integer.parseInt("aa");
			}
			
			request.setAttribute("mid", mid);
			request.setAttribute("cou", cou);
			RequestDispatcher rd = request.getRequestDispatcher("./coupon.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('쿠폰번호를 확인해 주세요');"
					+ "history.go(-1);"
					+ "</script>");
		}finally {
			this.pw.close();
		}

	}

}
