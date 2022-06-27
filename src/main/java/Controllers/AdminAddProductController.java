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

import dao.AdminAddProductDao;
import dao.AdminUserSearchDao;
import Models.Product;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminAddProductController")
public class AdminAddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url = "/admin_addproduct.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Map<String, String[]> paramMap = request.getParameterMap();
		
		String serialno = paramMap.get("serialno")[0];
		String productname = paramMap.get("productname")[0];
		String model = paramMap.get("model")[0];
		
		// TODO add error handling 
		if (serialno.isBlank() || productname.isBlank() || model.isBlank()) {
			
			return;
			
		}
		
		AdminAddProductDao aapdao;
		try {
			aapdao = new AdminAddProductDao();
			
			Product product = new Product();
			product.setSerialno(serialno);
			product.setProductname(productname);
			product.setModel(model);
			
			aapdao.doAdd(product);
			
			
			String url = "/AdminHomeController";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			
			// just click search again to see all the entries
			
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}

}
