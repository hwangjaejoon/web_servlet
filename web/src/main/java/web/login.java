package web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet : Java를 웹에서 사용할 수 있도록 처리하는 클래스?
public class login extends HttpServlet {
	//serialVersionUID : Backend 가상의 페이지 일련번호
	private static final long serialVersionUID = 1L;
	//doGet, doPost : Front-end 가 Form 태그에 method를 설정한 사항과 동일한 정보를 처리하는 메소드
	//request : front-end 에게 전달 받는 값
	//response : back-end 가 처리하는 결과값을 출력하는 역할
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter : front-end에서 전달되는 name 이름
		request.setCharacterEncoding("utf-8");	//front 가 한글일 경우 한글 깨짐 방지용 언어셋
		
		response.setCharacterEncoding("utf-8"); //back 이 한글일 경우 한글 깨짐 방지용 언어셋
		response.setContentType("text/html"); 	//얘까지 
		
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		//Printwriter : javascript 핸들링
		PrintWriter pw = response.getWriter();
		//response.getWriter(); : 현재 페이지에 문자로 출력
		
		if(mid.equals("hong") && mpass.equals("a123456")) {
			pw.write("<script>"
					+ "alert('정상적으로 로그인 하셨습니다.');"
					+ "</script>");
		}
		else {
			pw.write("<script>"
					+ "alert('아이디 및 패스워드를 다시 확인 하세요.');"
					+ "location.href='./login.html';"
					+"</script>");					
		}
		
	}
}
