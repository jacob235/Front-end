package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import dao.BookDao_Oracle;
import service.BookService;
import service.BookServiceImpl;
import vo.BookVO;


@WebServlet("/listBook.do")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// public 으로 사용해도 된다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/listBook.do 요청 처리");
		
		BookDao dao = new BookDao();
		BookService service = new BookServiceImpl(dao);
		List<BookVO> list = service.bookList();
		
		request.setAttribute("booklist", list);	// forward
		
		
		String view = "/booklist.jsp";
			
		getServletContext().getRequestDispatcher(view).forward(request, response);			
		

		
		
		
//		PrintWriter out = response.getWriter();
//		for(BookVO data:list) {
//			out.print("<h3>" +data.getBookid()+ "</h3>");			
//			out.print("<h3>" +data.getBookname()+ "</h3>");			
//			out.print("<h3>" +data.getPublisher()+ "</h3>");			
//			out.print("<h3>" +data.getPrice()+ "</h3>");			
//		}
	}
}
