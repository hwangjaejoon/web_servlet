package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class part2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw = null;
			
	//part1에서 get으로 전송하므로 doGet만 설정
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	//part1 에서 전송받는 값이 한글이 있을 경우
		response.setContentType("text/html;charset=utf-8");	//jsp로 전송하려는 값이 있을 경우
		try {
			this.pw = response.getWriter();	//jsp로 값 전송?
			
			//getParameterValues : 배열로 받을 경우 끝에 s..
			String agree[] = request.getParameterValues("agree");
			//System.out.println(agree.length);	// 4가 출력됨 (선택) 안누르면 3 출력
			int ea = agree.length;
			int ckcount = 0;
			int w = 0;
			while(w<ea) {
				if(agree[w].equals("Y0") || agree[w].equals("Y1") || agree[w].equals("Y2")) {
					ckcount++;
				}
				w++;
			}
			if(ckcount < 3) {
				this.pw.write("<script>"
						+ "alert('올바른 접근방식이 아닙니다');"
						+ "location.href='./part1.jsp';"
						+ "</script>");
			}else {	//해당 조건이 맞을 경우 part2.jsp 로드
				RequestDispatcher rd = request.getRequestDispatcher("./part2.jsp");
				rd.forward(request, response);
			}
			
			
		}catch(Exception e) {
			this.pw.write("<script>"
					+ "alert('백엔드 실수');"
					+ "location.href='./part1.jsp';"
					+ "</script>");
		}finally {
			this.pw.close();
		}
		
	}

}
