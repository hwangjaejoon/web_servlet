package self;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class pollok_self extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String subject = request.getParameter("subject");
		String etc[] = request.getParameterValues("etc");
		
		PrintWriter pw = response.getWriter();

		try {
			request.setAttribute("etc", etc);
			request.setAttribute("subject", subject);
			RequestDispatcher rd = request.getRequestDispatcher("./pollok_self.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			pw.write("<script>" + "alert('올바른 접근이 아닙니다.');" + "history.go(-1)" + "</script>");
		} finally {
			pw.close();
		}

	}

}
