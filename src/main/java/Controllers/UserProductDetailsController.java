package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClaimDao;
import dao.UserProductDetailsDao;
import dao.UserProductDisplayDao;
import Models.Claim;
import Models.UserProduct;

/**
 * Servlet implementation class UserProductDetailsController
 */
@WebServlet("/UserProductDetailsController")
public class UserProductDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProductDetailsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		UserProduct userproduct = new UserProduct();
		Claim claim = new Claim();
		String serialno = request.getParameter("serialno");
		String username = request.getParameter("username");
		UserProductDetailsDao updd = null;
		ClaimDao cldao = null;

		try {
			updd = new UserProductDetailsDao();
			cldao = new ClaimDao();

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		updd.doGetUserProduct(serialno,username);
		
		String table = "";

	
		cldao.doReadClaim(serialno,username); 
		  String tableClaim = "";
		 
		try {
			table = updd.getHTMLTable();
			tableClaim = cldao.getHTMLTable();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("table", table);
		request.setAttribute("tableClaim", tableClaim);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userproductdetails.jsp");
		dispatcher.forward(request, response);

	}
}
