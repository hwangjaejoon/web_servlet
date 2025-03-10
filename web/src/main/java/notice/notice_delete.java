package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;
import shop.m_md5;
//Database 게시물 삭제 Controller
public class notice_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;	//Db 연결
	PreparedStatement ps = null; //뭐지
	String sql = "";	//쿼리문
	int result = 0; 	//결과값 int로
	m_dbinfo db = new m_dbinfo();	//db정보
	m_md5 md5 = new m_md5();	//md5 암호화
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String nidx = request.getParameter("nidx");
		String ori_pw = request.getParameter("opi_pw");		//이게...db에 저장된 비번
		String npw = request.getParameter("npw");	//삭제할 시 입력한 비번
		this.pw = response.getWriter();
		
		try {
			//사용자가 입력한 비밀번호와 자동증가값이 올바르게 post 전송되지 않으면 접근 해제 DB연결도 안됨
			if(nidx.equals(null) || npw.equals(null)) {
				this.pw.write("<script> alert('올바른 접근이 아닙니다.'); history.go(-1); </script>");
			}
			else {
				npw = md5.md5_code(npw);	//사용자가 입력한 패스워드를 md5로 변환 후 DB에 저장된 pw와 비교 후 삭제
				if(npw.equals(ori_pw)) {
					System.out.println("dddddd");
					this.con = this.db.getConnection();	//db랑 연결
					this.sql = "delete from notice where nidx=?";
					this.ps = this.con.prepareStatement(this.sql);
					this.ps.setString(1, nidx);
					this.result = this.ps.executeUpdate();
					if(this.result > 0) {
						this.pw.write("<script> alert('삭제 완료.'); location.href='./notice_list.do'; </script>");
					}
				}
				else {
					this.pw.write("<script> alert('비밀번호를 확인해 주세요.'); history.go(-1); </script>");
				}
			}
		}catch(Exception e) {
			this.pw.write("<script> alert('데이터베이스 삭제 오류 발생.'); history.go(-1); </script>");
		}finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			}catch(Exception e) {
				System.out.println("DB 접속에 따른 해제권한 오류 발생");
			}
		}

	}

}
