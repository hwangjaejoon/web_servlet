package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;


public class join_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;   //Database 연결 (SQL Query문을 실행)

	/*doGet + doPost = service(모두 사용 가능) 보안 약해서 잘 안 씀
		protected void Service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("get,post 모두 받는");
	*/
	
/*	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		m_dbinfo db = new m_dbinfo();
		try {
		this.con = db.getConnection();
		}catch(Exception e) {
			System.out.println("DB연결 실패 ㅋㅋ");
		}finally {
			try {
			this.con.close();
			}catch(Exception e) {
				System.out.println("DB 제대로 해제 X");
			}
		}
	}
*/
	PrintWriter pw = null;
	PreparedStatement ps = null;
	//회원가입 진행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		m_dbinfo db = new m_dbinfo();
		try {
			this.con = db.getConnection();
			String spart = request.getParameter("spart");
			String sid = request.getParameter("sid");
			String spw = request.getParameter("spw");
			String snm = request.getParameter("snm");
			String stel = request.getParameter("stel");
			String semail = request.getParameter("semail");
			
			spw = new m_md5().md5_code(spw);	//문자 패스워드를 MD5로 암호화
			String sql = ""; 	//Database Query문 
			if(spart.equals("P")) {		//일반회원
				sql = "insert into shop_member values ('0',?,?,?,?,?,?,null,now());";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, spart);
				this.ps.setString(2, sid);
				this.ps.setString(3, spw);
				this.ps.setString(4, snm);
				this.ps.setString(5, stel);
				this.ps.setString(6, semail);
				int result = this.ps.executeUpdate();
				if(result > 0) {	//정삭적으로 db에 insert 되었을 경우
					this.pw.write("<script>"
							+ "alert('회원가입이 완료 되었습니다.');"
							+ "location.href='./login.jsp';"
							+ "</script>");
				}
									
			}else {		//사업자
				String sno = request.getParameter("sno");
				sql = "insert into shop_member values ('0',?,?,?,?,?,?,?,now());";
				this.ps = this.con.prepareStatement(sql);
				this.ps.setString(1, spart);
				this.ps.setString(2, sid);
				this.ps.setString(3, spw);
				this.ps.setString(4, snm);
				this.ps.setString(5, stel);
				this.ps.setString(6, semail);
				this.ps.setString(7, sno);
				int result = this.ps.executeUpdate();
				if(result > 0) {	//정삭적으로 db에 insert 되었을 경우
					this.pw.write("<script>"
							+ "alert('사업자 회원가입이 완료 되었습니다.');"
							+ "location.href='./login.jsp';"
							+ "</script>");
				}
			}
		}

		catch(java.sql.SQLIntegrityConstraintViolationException ie) {	//DB 에 unique 값이 중복 되었을 경우
			this.pw.write("<script>"
					+ "alert('연락처 및 이메일이 중복 되어 가입이 취소 되었습니다..');"
					+ "history.go(-1);"
					+ "</script>");
		}		
		catch(Exception e) {
			
		}finally {
			try {
			this.ps.close();
			this.con.close();
			this.pw.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		
		
	}

}
