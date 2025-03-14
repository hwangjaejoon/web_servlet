package mallpage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mallpage/product_list.do")
public class product_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// DTO
	dto_product pd = new dto_product();
	// select Model
	m_product mp = new m_product();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//상품 한 가지를 클릭했을 경우 Front-end에서 GET 전송값
		String midx = request.getParameter("midx");
		String pagename = "";	//하나의 Controller에 두개의 view 가 존재

		if (midx == null) {
			ArrayList<ArrayList<String>> all = this.mp.product_all();
			request.setAttribute("all", all);

			// jsp 로드하여 View 역할로 데이터 출력
			pagename = "./product_list.jsp";
		} else {	// 상품 상세정보
			this.pd.setMidx(Integer.parseInt(midx));// DTD로 전달
			this.mp.oneproduct(this.pd);//dto 객체를 model로 전달
			
			this.pd = this.mp.pd;		//Controoller에서 Model에 있는 DTO 객체 가져오기
//			System.out.println(this.pd.getPnm());
			
			request.setAttribute("dto", this.pd);	//DTO Model을 JSP로 전달하기 위한 Attribute??
			
			pagename = "./product_view.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(pagename);
		rd.forward(request, response);


	}

}
