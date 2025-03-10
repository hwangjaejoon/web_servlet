package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//하나의 Controller에 하나의 View가 적용됨. 단 , 해당 View 안에 여러 개의 include(jsp)가 있는 상황
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String corp = "에이핑크 사단법인";
		
		request.setAttribute("corp", corp);
		
		RequestDispatcher rd = request.getRequestDispatcher("./main.jsp");
		rd.forward(request, response);
	}

}
