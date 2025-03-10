package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig( // front가 enctype 설정 시 무조건 셋팅 해야만 해요~
		fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)

public class mobileok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		rq.setCharacterEncoding("utf-8");
		rp.setContentType("text/html;charset=utf-8");
		String sec = rq.getParameter("security"); // hidden으로 받은 값
		//System.out.println(sec);
		if (!sec.equals("m")) {// hidden에 있는 값이 다를 경우
			PrintWriter pw = rp.getWriter();
			pw.write("<script>alert('ERR'); history.go(-1);</script>");
		} else {// hidden 값이 맞을 경우
			new reviews(rq, rp);
		}

	}

}

class reviews { // 외부 클래스 사용 시 한글 깨짐 처리는 메인 dopost,doget 에서 처리함?
	PrintWriter pw = null;

	public reviews(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		this.pw = rp.getWriter();
		this.pw.write("<script> alert('리뷰 등록 완료'); location.href='./mobile.html'; </script>");
		String mname = rq.getParameter("mname");	//고객명
		String pname = rq.getParameter("pname");	//상품명
		String star = rq.getParameter("star"); 		//별점
		String mtext = rq.getParameter("mtext");	//리뷰 내용
		Part p = rq.getPart("mfile");				//리뷰 이미지
		String filename = p.getSubmittedFileName();
		if(filename != "") {		//이미지가 첨부 됐을 경우
			String url = rq.getServletContext().getRealPath("/review/");
			p.write(url + filename);
		}
		
		System.out.println(mname);
		System.out.println(pname);
		System.out.println(star);
		System.out.println(mtext);
	}
}