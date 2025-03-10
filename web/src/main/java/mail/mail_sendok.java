package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;

public class mail_sendok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PrintWriter pw = null;
	PreparedStatement ps = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		m_dbinfo db = new m_dbinfo();
		this.pw = response.getWriter();

		try {
			this.con = db.getConnection();
			String to_name = request.getParameter("to_name");
			String to_mail = request.getParameter("to_mail");
			String subject = request.getParameter("subject");
			String context = request.getParameter("context");

			String sql = "insert into mail (midx,to_name,to_mail,subject,context,mdate) values ('0',?,?,?,?,now())";
			int result = 0;
			this.ps = this.con.prepareStatement(sql);
			this.ps.setString(1, to_name);
			this.ps.setString(2, to_mail);
			this.ps.setString(3, subject);
			this.ps.setString(4, context);
			result = this.ps.executeUpdate();
			System.out.println("dd");
			if (result > 0) {
				this.pw.write("<script>" + "alert('메일 발송 완료');" + "location.href='./mail_sendok.jsp';" + "</script>");
			}
		} catch (Exception e) {
				this.pw.write("<script>" + "alert('어딘가에 문제가');" + "history.go(-1);" + "</script>");
		} finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			} catch (Exception e) {

			}
		}

	}

}
