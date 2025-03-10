package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//cos 사용 없이 자체 라이브러리를 이용하여 설정
@MultipartConfig(		//첨부파일 환경설정 파트
	fileSizeThreshold = 1024*1024*2,	//한 개의 파일 전송 크기 : 2MB
	maxFileSize = 1024*1024*5,			//파일 최대 크기 용량 : 5MB
	maxRequestSize = 1024*1024*100		//여러 개의 첨부파일 전체의 용량 : 100MB
)
public class fileupload extends HttpServlet {
	PrintWriter pw = null;
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			//Front-end에서 전송 된 name 값에 대한 i/o 처리 방식
			//Part(클라이언트) <=> Multipart(서버)
			Part mfile = request.getPart("mfile");
			String filename = mfile.getSubmittedFileName();		//파일명 핸들링
			Long filesize = mfile.getSize();	//파일 용량 크기 핸들링		
			//System.out.println(filename);	//파일명 출력
			//System.out.println(filesize);	//파일 용량 크기 출력(byte)
			if(filesize > 2097152) {
				pw.print("<script>"
						+ "alert('파일 첨푸 용량은 최대 2MB까지 입니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {
				/* WEB I/O 는 웹 전용 디렉토리를 별도로 구성 해야만 정상적으로 웹에서 이미지를 확인할 수 있음.
				   getServletContext(웹 경로) + getRealPath(저장 디렉토리)
				   
				   APP I/O -> File -> InputStream -> OutStream
				*/
				//WEB Server에서 적용된 디렉토리에 저장되도록 함? (src경로 X)
				String url = request.getServletContext().getRealPath("/upload/");
				mfile.write(url + filename);
				this.pw.write("<script>"
						+ "alert('정상적으로 파일 업로드 되었습니다');"
						+ "history.go(-1);"
						+ "</script>");
			}
			
		}catch(Exception e) {
			this.pw.write("<script>"
						+ "alert('올바른 접근방식이 아닙니다.');"
						+ "</script>");
		}finally {
			this.pw.close();
		}
		
		
		
	}

}
