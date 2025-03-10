package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	
	//Ajax 통신을 받는 메소드 (아이디 중복체크)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Back-end가 Front-end에게 결과값을 통보하는 역할
		String msg = ""; 	//Front-end에게 결과값을 보내는 변수
		PrintWriter pw = response.getWriter();
		
		//Ajax로 Front-end가 보낸 데이터를 받는 역할
		try {
		String id = request.getParameter("sid");
		if(id.equals("")) {
			msg="error";
		}
		else {
			m_dbinfo db = new m_dbinfo();
			this.con = db.getConnection();	//Database 연결시작
			//sql query문 작성 밥법
			//1. select => ResultSet, executequery
			String sql = "select count(*) as ctn from shop_member where sid='"+id+"'";
			//Statement : Database에 쿼리문을 작성할 수 있도록 사용하는 메소드
			//createStatement() : create, alter, drop
			//ResultSet : executeQuery 결과값을 받는 역할
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery(sql);	//rs.next() : 결과값에 대해서 반복문이 실행 (true,false)
			/* 반복문 사용 했을 경우
			while(rs.next()) {	//rs.next() : 결과값에 대해
			System.out.println(rs.getString("ctn"));
			}
			*/
			
			//조건문 사용 했을 경우
			if(rs.next() == true) {		//qurey문 이 정상적으로 작성 되었을 경우
				if(rs.getString("ctn").equals("0")) {	//카운트 0일 떄 (중복안됨)
					msg="ok";
				}else {
					msg="no";	//카운트 0 이 아닐 때(중복 됨)
				}
			}
			rs.close();
			st.close();
		}
		pw.print(msg);
		}catch(NullPointerException ne) {	 //Front-end가 올바른 값을 전달하지 않을 경우
			msg="error";
			pw.print(msg);	//ok : 사용가능 아이디, no : 사용불가능 아이디, error : 데이터 오류
		}catch(Exception e) {
			msg="DB error";
			pw.write(msg);
		}
		finally {
			pw.close();
		}
		
	}

}
