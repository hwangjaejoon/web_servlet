package self;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 
 	로그인 화면 만들기 자바 파일  
  
 */

public class login_self extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String mid = request.getParameter("mid"); //html에서 아이디의 name 값
		String mpass = request.getParameter("mpass"); //html에서 패스워드의 name 값
		PrintWriter pw = response.getWriter();
		
		if(mid.equals("hwang7596") && mpass.equals("wowns1234")) {
			pw.write("<script>"
					+ "alert('로그인 됐습니다.');"					
					+ "</script>");
		}
		else {
			pw.write("<script>"
					+ "alert('아이디 및 비밀번호를 확인하세요');"
					+ "history.go(-1);"
					+ "</script>");
		}
		
	}

}
