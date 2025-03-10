package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class shoppingcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
		this.pw = response.getWriter();
		String mtotal = request.getParameter("mtotal"); //최종 결제금액
		String mpay = request.getParameter("mpay");	//결제수단

		request.setAttribute("mpay", mpay);
		request.setAttribute("mtotal", mtotal);
		
		RequestDispatcher rd = request.getRequestDispatcher("./shoppingcart.jsp");
		rd.forward(request, response);
		
		}catch(Exception e) {
			
		}finally {
			
		}
		
		
		
	}

}
