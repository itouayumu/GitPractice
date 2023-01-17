package servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.acountdao;
import dto.acount;
import util.GenerateHashedPw;

/**
 * Servlet implementation class acountloginr
 */
@WebServlet("/acountloginr")
public class acountloginr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acountloginr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getParameter("UTF-8");
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		String salt=acountdao.getSalt(mail);
		if(salt == null) {
			String view = "WEB-INF/view/acountlogin.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		String hashedPw = GenerateHashedPw.getSafetyPassword(pw, salt);
		 acount acount = acountdao.login(mail, hashedPw);
		 if(acount == null) {
				String view = "WEB-INF/view/sample-login.jsp?error=1";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			} else {
				String view = "WEB-INF/view/acountloginr.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
