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


public class AdminAddProductDao extends Database {

	public ResultSet results;
	private static Connection connection;
	public AdminAddProductDao() throws ClassNotFoundException, SQLException {
		
					InputStream inputStream = getClass().getResourceAsStream("property.txt");
					
					Properties properties = new Properties();
					try {
						properties.load(inputStream);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String username = properties.getProperty("username");
					String driver  = properties.getProperty("driver");
					String server = properties.getProperty("server");
					String password = properties.getProperty("password");
					Class.forName(driver);
					   connection =
							  DriverManager.getConnection(server, username, password);		   
		}
	
	public void doAdd(Product product) {
		try {
			String query = "insert into product (serialno, productname, model) values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, product.getSerialno());
			ps.setString(2, product.getProductname());
			ps.setString(3, product.getModel());
			ps.executeUpdate();
			ps.close();
			
			this.connection.close();
			
		} catch (SQLException ex) {
			//Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, "Error");
			ex.printStackTrace();
		}
	}
	
	

	
	
}
