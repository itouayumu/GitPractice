package servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.acount;

/**
 * Servlet implementation class acount12
 */
@WebServlet("/acount12")
public class acount12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public acount12() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String gen = request.getParameter("gen");
			String phon = request.getParameter("phon");
			String mail = request.getParameter("mail");
			String pw = request.getParameter("pw");
			
			int Age = Integer.parseInt(age);
			int Phon = Integer.parseInt(phon);
			
			acount account = new acount(-1, name, Age, gen, Phon, mail,null,pw, null);
			
			// セッションスコープのインスタンス取得
			HttpSession session = request.getSession();
			
			// セッションスコープに値の保存
			// 第1引数：キー
			// 第2引数：保存する値
			session.setAttribute("input_data", account);
			
			String view = "WEB-INF/view/acount12.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
