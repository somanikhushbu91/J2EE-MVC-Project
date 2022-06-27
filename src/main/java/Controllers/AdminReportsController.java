package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminReportsDao;
import dao.AdminUserSearchDao;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminReportsController")
public class AdminReportsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReportsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		AdminReportsDao a;
		
		try {
			a = new AdminReportsDao();
			
			a.doRead();
			
			String table = a.getHTMLTable();
			request.setAttribute("table", table);
			
			String url = "/admin_reports.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
