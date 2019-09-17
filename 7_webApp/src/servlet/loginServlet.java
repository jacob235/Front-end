package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet({"/login.do","/logout.do"})
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 객체를 파괴시키면 된다.
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		response.sendRedirect("./index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("/login.do 요청 처리");
		System.out.println(id + "/" + pw);
		
		if(id == null || pw == null || id.length() == 0 || pw.length() == 0) {
			// 돌려 보내는 방법 sendredirect, forward
			//response.sendRedirect("./login.jsp");
			request.setAttribute("msg", "패스워드 정보를 다시 입력하세요.");
			request.setAttribute("id", id);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(id.equals("java01") && pw.equals("java01")) {
			// 로그인 성공 뒤 로그아웃하기 전까지 서비스 이용 하며 index로 이동한다.
			HttpSession session = request.getSession();
			session.setAttribute("login", id+"/홍자바");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("id", id);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}





