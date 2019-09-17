package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import service.BookService;
import service.BookServiceImpl;


@WebServlet("/deleteBook.do")
public class deleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 하나만 넘겨간다. 여러개 넘겨 받으려면 다른 메소드 사용
//		String bookid = request.getParameter("bookid");
		String[] bookid = request.getParameterValues("bookid");
		
		System.out.println("deleteBook.do => " + Arrays.toString(bookid));
		
		BookDao dao = new BookDao();
		BookService service = new BookServiceImpl(dao);

		try {
			for(String data : bookid) {
				service.deleteBook(Integer.parseInt(data));		
			}
			
			response.sendRedirect("listBook.do");
		}catch (Exception e) {
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}
		
		
	}

}
