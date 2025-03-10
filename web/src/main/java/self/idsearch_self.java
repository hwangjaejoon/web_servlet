package self;

/*
  
 @@@ 아이디 찾기 만들기 자바 파일 @@@ 
  
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idsearch_self extends HttpServlet {
	private static final long serialVersionUID = 1L;  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();	//자바스크립트로 프린트 하기 위하 선언
	try {
	
	String mname = request.getParameter("mname");
	System.out.println(mname);  ///////
	String number = request.getParameter("number");
	System.out.println(number);  ////////
	int number_check = Integer.parseInt(number); //number값이 숫자가 아니면 catch 띄우기 위해
	// ++ 문자가 입력됐다면 숫자로 변환이 불가능
	//System.out.println(number_check);  ///////
	String email = request.getParameter("email");
	System.out.println(email);  	///////
	String mid = "";	//이름, 전화번호, 이메일 일치 시 아이디 띄우기 위해 빈 값 선언
	if(mname.equals("황재준") && number.equals("01012345678") && email.equals("hwang@naver.com")) {
		mid = "hwang777";
		System.out.println(mid);
	}
	else {
		mid = "가입 정보가 확인되지 않습니다";
		System.out.println(mid);
	}
	
	request.setAttribute("mid", mid);	//자바스크립트에 mid 값 전달
	RequestDispatcher rd = request.getRequestDispatcher("./idsearch_self.jsp");	//jsp파일 경로 선언
	rd.forward(request, response); //뭔진 모르곘지만 선언해야 하는듯?
	
}catch(Exception e) {
	pw.write("<script>"
			+ "alert('연락처 칸에는 숫자만 입력해 주세요');"
			+ "history.go(-1);"
			+ "</script>");
}finally {
	pw.close();
}
	}

}
