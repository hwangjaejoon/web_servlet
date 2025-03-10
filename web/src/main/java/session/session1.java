package session;
/*
 	session : 일정시간 동안 브라우저에 해당 값을 저장 및 유지시키는 방식(back-end)
 	cookie : 브라우저의 cache 메모리에 값을 저장하는 방식 (도메인 및 ip기준) - front,back 
 	storage : 메모리에 저장 front,back (local, session) 위의 session이랑 다름..
 
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//session1 => session을 생성하는 컨트롤러
public class session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response 만 쓴 이유 : 아디 비번에 한글이 넘어올 일이 없어서
		response.setContentType("text/html;charset=utf-8");
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		this.pw = response.getWriter();
		
		
		//아디 비번 다 맞는 상황
		if(mid.equals("hong") && mpass.equals("a1234")) {
			String username = "홍길동";
			String usertel = "01049087596";
			
			//HttpSession : 브라우저의 cache 메모리에 데이터를 임시저장 
			HttpSession se = request.getSession();
			//session 생성
			se.setAttribute("id", mid);	//아이디
			se.setAttribute("name", username); //이름
			se.setAttribute("tel", usertel);  //전번
		}
		//아이디 및 패스워드가 틀릴 경우
		else {   
			this.pw.write("<script>"
					+ "alert('아이디 및 패스워드를 확인하세요');"
					+ "history.go(-1);"
					+ "</script>");
		}
	}

}
