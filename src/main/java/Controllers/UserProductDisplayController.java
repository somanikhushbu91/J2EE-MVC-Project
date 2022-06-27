package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserProductDao;
import dao.UserProductDisplayDao;
import Models.UserProduct;

/**
 * Servlet implementation class UserProductDisplayController
 */
@WebServlet("/UserProductDisplayController")
public class UserProductDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProductDisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		  Cookie cookies[] = request.getCookies();	 
		  String usernamecook = ""; 
		  for (Cookie c : cookies) {
			  if(c.getName().equals("un")) { usernamecook = c.getValue(); } }
		 
		UserProductDisplayDao upd = null;
		
		try {
			upd = new UserProductDisplayDao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
			upd.doGetUserProduct(usernamecook); 
			
			String table = "";
		try {	
			table = upd.getHTMLTable();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("username", usernamecook); 
		request.setAttribute("table", table);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userproductdisplay.jsp");
		dispatcher.forward(request, response);
	}
}
