package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.LoginDao;
import Models.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		 LoginDao login = null;
		 
		 LoginDao isAdminLogin = null;
		try {
			login = new LoginDao();
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 		
			String result;
			String isadmin;
			try {
				result = login.doLogin(username, password);
				
				// check if this user is admin
				isAdminLogin = new LoginDao();
				isadmin = isAdminLogin.doAdminCheck(username, password);
				
				if (result.equals("success")) {
					Cookie cookie = new Cookie("un", username);
					response.addCookie(cookie);
						
					if (isadmin.equals("success")){
						response.addCookie( new Cookie("isAdmin", username + "_" + isadmin));
						response.sendRedirect("AdminHomeController");
					} else {
						response.sendRedirect("UserProductDisplayController");
						
					};
			} else {
				rd = request.getRequestDispatcher("/errorlogin.jsp");
				rd.forward(request, response);
			}
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		 
}

