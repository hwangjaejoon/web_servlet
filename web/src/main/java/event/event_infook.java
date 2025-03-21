package event;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class event_infook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PrintWriter pw = null;
	Statement st = null;
	dbconfig db = new dbconfig();
	
	public event_infook() {
		try {
			/*
			dbconfig db = new dbconfig();
			this.con = db.info();
			를 한 줄로 줄인게 아래
			*/
			//this.con = new dbconfig().info();
			//System.out.println("Database 연결성공");
		}catch(Exception e) {
			//System.out.println("Database 연결실패 ㅠㅠ");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String ename = req.getParameter("ename");
		String etel = req.getParameter("etel");
		String email = req.getParameter("email");
		String ememo = req.getParameter("ememo");
		String info1 = req.getParameter("info1");
		String info2 = req.getParameter("info2");
		
		//SQL Query문 (DDL) - select, insert, update, delete
		String sql = "insert into event (eidx,ename,etel,email,info1,info2,ememo,ejoin)"
				+ "value ('0','"+ename+"','"+etel+"','"+email+"','"+info1+"','"+info2+"','"+ememo+"',now());";
		this.pw = res.getWriter();
		try {
			this.con = this.db.info();
			//SQL 문법을 실행시키는 클래스(기초) ==> insert 어쩌구 를 입력하게 해주는 명령어
			this.st = this.con.createStatement();
			int result = this.st.executeUpdate(sql);	// --> (insert, update, delete) 에만 씀 , int를 쓰는 이유 : 정상 입력 시 1이 날라옴
			if(result > 0) {
				this.pw.write("<script>"
						+ "alert('정상적으로 이벤트에 참여 되었습니다.');"
						+ "location.href='./event_info.html';"
						+ "</script>");
			}
			else {
				this.pw.write("<script>"
						+ "alert('이미 이벤트에 등록 되었습니다.');"
						+ "location.href='./event_info.html';"
						+ "</script>");
			}
			
		}
		catch(Exception e) {
			System.out.println("SQL 문법오류 ㅋㅋ");
		}
		finally {	//정삭적인 Database를 모두 핸들링 후 역순으로 close를 적용해야 함
			try {
			this.st.close();
			this.pw.close();
			this.con.close();	//Database 연결 끊기
			}catch(Exception e) {
				System.out.println("데이터베이스가 올바르게 종료되지 않았습니다");
			}
		}
	}
	

}
