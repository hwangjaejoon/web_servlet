package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ajax_postok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CORS를 해결하기 위해서 사용함
		response.addHeader("Access-Control-Allow-Origin","*");
		response.addHeader("Access-Control-Allow-Credentials","true");
		
		String userid = request.getParameter("userid");
		String usermail = request.getParameter("usermail");
		String msg = "";	//ok : 정상 아이디 , no : 아이디 오류 발생 , error : 백엔드 오류
		this.pw = response.getWriter();
		if(userid.equals("hong") && usermail.equals("hong@nate.com")) {
			msg = "no";
		}
		else {
			msg = "ok";
		}
		this.pw.print(msg);	//front end에 보내는 값
	}

}
