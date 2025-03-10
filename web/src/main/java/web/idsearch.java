package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idsearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();

		try {

			String mname = request.getParameter("mname");
			String number = request.getParameter("number");
			int numcheck = Integer.parseInt(number); // 왜..?
			String email = request.getParameter("email");
			String mid = "";
			if (mname.equals("홍길동") && number.equals("01010041919") && email.equals("hong@naver.com")) {
				mid = "hong2025";
				// System.out.println("trtrtrtrtrtr");
			} else {
				mid = "가입정보가 확인 되지 않습니다";
				pw.write("<img src = 'E:\\web_servlet\\web\\src\\main\\webapp\\immg.jpeg'>");
				// System.out.println("fsfsfsfsfsfsfs");
			}
			// System.out.println("test!!!!!"+mid);


			request.setAttribute("mid", mid);

			RequestDispatcher rd = request.getRequestDispatcher("./idsearch.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			pw.write("<script>" + "alert('연락처 란에는 숫자만 입력해 주십쇼');" + "history.go(-1);" + "</script>");
		}finally {
			pw.close();
		}

	}

}
