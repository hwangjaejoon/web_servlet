package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class pollok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		//front end 한글 깨짐 방지
		
		//backend 한글 깨짐 방지 한 문장으로
		response.setContentType("text/html;charset=utf-8");
		
		//backend 한글 깨짐방지
		//response.setCharacterEncoding("utf-8");
		//response.setContentType("text/html");
		
		//동일한 name 값으로 radio로 보낸다면 여러 개 오브젝트중에 한 가지만 선택됨으로 배열이 아닌 일반변수?
		//request.getParameter : get, post name 전달된 값 동일? 
		String subject = request.getParameter("subject");
		String etc[] = request.getParameterValues("etc");		//같은 name 값을 가진 checkbox 배열
		//ArrayList<String> etc = new ArrayList<String>(Arrays.asList(request.getParameterValues("etc")));
		PrintWriter pw = response.getWriter();
		try {
		
		request.setAttribute("etc", etc);
		//System.out.println(Arrays.toString(etc));
		request.setAttribute("subject", subject);		//View 에 출력하는 메소드	
		//RequestDispatcher 사용 시 PrintWriter 사용 X	 catch문에서는 가능
		RequestDispatcher rd = request.getRequestDispatcher("./pollok.jsp");
		rd.forward(request, response);
		}catch(Exception e) {
			pw.write("<script>"
					+"alert('올바른 접근이 아닙니다.');"
					+"history.go(-1)"
					+"</script>");
			
		}finally {
			pw.close();
		}
		
	}

}
