package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,	//파일 한 개의 최대 용량
	maxRequestSize = 1024 * 1024 * 100	//여러 개의 파일을 전송 시 총 용량
)
public class part3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//회원가입완료
	PrintWriter pw = null;
	String url = null;	//웹 경로를 저장하는 변수
	String filenm = null;	//파일 명을 저장하는 변수
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			this.pw = response.getWriter();	//try 에 첫줄에 넣어줌
			String mid = request.getParameter("mid");
			String mname = request.getParameter("mname");
			String mpass = request.getParameter("mpass");
			String memail = request.getParameter("memail");
			String mtel = request.getParameter("mtel");	//숫자지만 int로 받음녀 조됨
			Part mfile = request.getPart("mfile");	//파일 받을 때
			
			if(mid.equals("") || mname.equals("") || mpass.equals("") || memail.equals("") || mtel.equals("")) {
				this.pw.write("<script>"
						+ "alert('올바른 데이터 접근이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {
				this.filenm = mfile.getSubmittedFileName();	//파일명이 있나 없나 확인?
				if(this.filenm != null && this.filenm != "") {
					long filesize = mfile.getSize();	//사이즈 확인?
					if(filesize > 2097152) {
						this.pw.write("<script>"
								+ "alert('첨부파일 용량은 최대 2MB 입니다.');"
								+ "history.go(-1);"
								+ "</script>");
					}
					else {	//첨부파일이 용량 내 일경우 서버에 저장
						this.url = request.getServletContext().getRealPath("/user/");	//웹 경로
						//System.out.println(url);	//경로 확인하고 user폴더 만들거나 해서 위에 추가
						mfile.write(this.url + this.filenm);
						System.out.println(this.url + this.filenm);
					}
				}
			}
			
			//jsp에 값을 전달
			request.setAttribute("mid", mid);
			request.setAttribute("mname", mname);
			request.setAttribute("memail", memail);
			request.setAttribute("mtel", mtel);
			request.setAttribute("image", this.filenm);		//첨부파일 이미지?
			
			RequestDispatcher rd = request.getRequestDispatcher("./part3.jsp");  //part3.jsp로 보내겠다.
			rd.forward(request, response);
			
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
		
		
		
	}

}
