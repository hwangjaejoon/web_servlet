package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class movieok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		this.pw = res.getWriter();
		try {
		String mname = req.getParameter("mname");
		String mno = req.getParameter("mno");
		String subject = req.getParameter("subject");
		String dt = req.getParameter("dt");
		//ArrayList<String> all = new ArrayList<String>;
			req.setAttribute("mname", mname);
			req.setAttribute("mno", mno);
			req.setAttribute("subject", subject);
			req.setAttribute("dt", dt);
			
			RequestDispatcher rd = req.getRequestDispatcher("./movieok.jsp");
			rd.forward(req, res);
			
		}catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('잘못된 접근입니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}finally {
			this.pw.close();
		}
		
	}

}
