package web;
//encty : 암호화? 라는 뜻?
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Controller
public class encry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passwd = "a123456";
		//해당 문자를 base64로 encode(암호화)
		encry_model em = new encry_model();		//암호화 model 클래스 로드
		String result = em.dataencode(passwd);		//해당 메소드에 문자값을 전달
		System.out.println(result);		//최종 암호화된 사항을 출력
		
		//문자를 base64로 변환 decode(복호화)
		String repasswd = "YTEyMzQ1Ng==";
		String result2 = em.datadecode(repasswd);
		System.out.println(result2);
		
		
		//md5 암호화
		String result3 = em.md5_encode(passwd);
		System.out.println(result3);
		
		
	}

}
