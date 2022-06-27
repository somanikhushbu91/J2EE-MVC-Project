package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminClaimApprovalDao;
import dao.AdminProductSearchDao;
import dao.AdminUserSearchDao;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminClaimApprovalController")
public class AdminClaimApprovalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminClaimApprovalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String claimid = request.getParameter("claimid");
		String approvalstatus = request.getParameter("approvalstatus");
		
		
		AdminClaimApprovalDao acadao;
		try {
			acadao = new AdminClaimApprovalDao();
			// if these aren't null, update the status
			if (claimid != null) {
				System.out.println(approvalstatus + claimid);
				acadao.doUpdate(Integer.parseInt(approvalstatus), Integer.parseInt(claimid));
				
			}
			
			
			acadao.doGet();
			
			String table = acadao.getHTMLTable();
			
			request.setAttribute("table", table);
			
			String url = "/admin_claimapproval.jsp";
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
