package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		fileSizeThreshold = 1024*1024*2,
		maxFileSize = 1024*1024*5
)
public class io_ok extends HttpServlet {
	PrintWriter pw = null;
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Part mfile = request.getPart("mfile");
		String filename = mfile.getSubmittedFileName();
		Long filesize = mfile.getSize();
		System.out.println(filename);
		System.out.println(filesize);
		if(filesize > 5242880) {
			pw.print("<script>"
					+ "alert('최대 5메가');"
					+ "history.go(-1);"
					+ "</script>");
		}
		else {
		String url = request.getServletContext().getRealPath("/notice/");
		mfile.write(url + filename);
		this.pw.write("<script>"
				+ "alert('정상적으로 파일 업로드 되었습니다');"
				+ "history.go(-1);"
				+ "</script>");
			
			
		}
		
			
		}catch(Exception e) {
			
		}finally{
			this.pw.close();
		}
	}

}
