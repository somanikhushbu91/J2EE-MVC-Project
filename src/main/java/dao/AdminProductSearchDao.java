package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import Models.Product;
import Models.User;


public class AdminProductSearchDao extends Database {

	public ResultSet results;
	private static Connection connection;
	
	public AdminProductSearchDao() throws ClassNotFoundException, SQLException {
				InputStream inputStream = getClass().getResourceAsStream("property.txt");
				
				Properties prop = new Properties();
				try {
					prop.load(inputStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String username = prop.getProperty("username");
				String driver  = prop.getProperty("driver");
				String server = prop.getProperty("server");
				String password = prop.getProperty("password");
				Class.forName(driver);
				   connection =
						  DriverManager.getConnection(server, username, password);		   
	}

	
	
	
	public void doRead() {
		try {
			String query = "select * from product";
			PreparedStatement ps = connection.prepareStatement(query);
			results = ps.executeQuery();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(AdminProductSearchDao.class.getName()).log(Level.SEVERE, "Error");
		}
	}
	
	public void doGetUsername(String serialno) {
		try {
			
			String query;
			if (serialno.isEmpty()) {
				doRead();
				return;
				
			} else {
				query = "select * from product where serialno = ?";
			}
			
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serialno);
			results = ps.executeQuery();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(AdminProductSearchDao.class.getName()).log(Level.SEVERE, "Error");
		}
	}
	
	public String getHTMLTable() {
		String table = "";
		table += "<table width=100% border=1 style='border-collapse: collapse;text-align:center'>"
				+ "<thead>"
				+ "<tr>"
				+ "<th>Serial Number</th>"
				+ "<th>Product Name</th>"
				+ "<th>Model</th>"
				+ "</tr>"
				+ "</thead>"
				+ "<tbody>";
		
		try {
			while(this.results.next()) {
				Product product = new Product();
				product.setSerialno(results.getString("serialno"));
				product.setProductname(results.getString("productname"));
				product.setModel(results.getString("model"));
				
				table += "<tr>"
						+ "<td>"
						+ product.getSerialno()
						+ "</td>"
						+ "<td>"
						+ product.getProductname()
						+ "</td>"
						+ "<td>"
						+ product.getModel()
						+ "</td>"
				;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(AdminProductSearchDao.class.getName()).log(Level.SEVERE, "Error");
		}
		
		table += "</tbody>"
				+ "</table>";
		
		return table;
		
	}

	
	
}
