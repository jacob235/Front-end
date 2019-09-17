package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;


@WebServlet("/insertBook.do")
public class insertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/listBook.do 요청 처리");
		
		BookDao dao = new BookDao();
		BookService service = new BookServiceImpl(dao);
		
		BookVO vo = new BookVO();
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setBookname(request.getParameter("bookname"));
		vo.setPublisher(request.getParameter("publisher"));
		
		try {
			service.addBook(vo);
			response.sendRedirect("listBook.do");			
		}catch (Exception e) {
			request.setAttribute("exception", new Exception("등록 데이터를 확인해주세요."));
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}
