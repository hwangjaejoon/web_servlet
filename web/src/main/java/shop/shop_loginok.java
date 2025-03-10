package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class shop_loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	Connection con = null;
	PreparedStatement ps = null;		//PreparedStatement 선언 -> Qurey문에서 ?로 ㅅ씀
	ResultSet rs = null;	//select문 쓸 때 선언 (insert 는 선언 X)
	HttpSession session = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		m_dbinfo db = new m_dbinfo();
		this.pw = response.getWriter();
		String spart = request.getParameter("spart");
		String sid = request.getParameter("sid");
		String spw = request.getParameter("spw");	//사용자가 입력 한 사항?
			try {
			this.con = db.getConnection();	//try 안에 넣어야 하나봐요
			spw = new m_md5().md5_code(spw);	//사용자가 입력 한 값을 암호화로 처리해야만 Database와 비교가 가능 ( db에 암호화해서 저장했기 때문)
			String sql = "";		//DB Query문 미리 선언
			
			//ResultSet 값을 받기 위한 변수
			String id = "";
			String pw = "";
			String nm = "";
			String no = "";
			
			if(spart.equals("P")) {		//개인회원
				sql = "select sid,spw,snm from shop_member where sid=?";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, sid);	//1번부터 들어감
				this.rs = this.ps.executeQuery();
				while(this.rs.next()) {
					id = this.rs.getString("sid");
					pw = this.rs.getString("spw");
					nm = this.rs.getString("snm");
				}
				if(id.equals("") || nm.equals("")) {		//DB에 조회 된 내용 이 없 을경 우
					this.pw.write("<script>"
							+ "alert('해당 아이디를 확인할 수 없습니다.');"
							+ "history.go(-1)"
							+ "</script>");
				}else {		//조회 된 내용이 있을 경우
					if(spw.equals(pw)) { 	//사용자가 입력한 비밀번호와 DB에 저장된 비밀번호를 비교 (암호화)
						this.session = request.getSession();	//세션 생성
						this.session.setAttribute("mid", id);	//id 세션등록
						this.session.setAttribute("mnm", nm);	//고객명 세션등록
						this.pw.write("<script>"
								+ "alert('로그인 완료');"
								+ "location.href='./main.jsp';"
								+ "</script>");
					}
					else {
						this.pw.write("<script>"
								+ "alert('비밀번호가 틀렸습니다.');"
								+ "history.go(-1);"
								+ "</script>");
					}
				}
			}
			else {						//사업자 회원 (if(spart.equals("C"))
				String sno = request.getParameter("sno");
				sql = "select sid,spw,snm,sno from shop_member where sid=? and sno=?";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, sid);
				this.ps.setString(2, sno);
				this.rs = this.ps.executeQuery();
				while(this.rs.next()) {
					id = this.rs.getString("sid");
					pw = this.rs.getString("spw");
					nm = this.rs.getString("snm");
					no = this.rs.getString("sno");
				}
				if(id.equals("") || nm.equals("") || no.equals("")) {
					this.pw.write("<script>"
							+ "alert('해당 아이디를 확인할 수 없습니다.');"
							+ "history.go(-1)"
							+ "</script>");
				}
				else {		//조회 된 내용이 있을 경우
					if(spw.equals(pw)) { 	//사용자가 입력한 비밀번호와 DB에 저장된 비밀번호를 비교 (암호화)
						this.session = request.getSession();	//세션 생성
						this.session.setAttribute("mid", id);	//id 세션등록
						this.session.setAttribute("mnm", nm);	//고객명 세션등록
						this.pw.write("<script>"
								+ "alert('로그인 완료');"
								+ "location.href='./main.jsp';"
								+ "</script>");
					}
					else {
						this.pw.write("<script>"
								+ "alert('비밀번호가 틀렸습니다.');"
								+ "history.go(-1);"
								+ "</script>");
					}
				}
			}
			}catch(Exception e) {
				System.out.println("뭔가 문제가 있음");
			}finally {
				try {
				this.con.close();
				this.pw.close();
				}catch(Exception e) {
					System.out.println("DB 연결 종료 실패");
				}
			}
	}

}
