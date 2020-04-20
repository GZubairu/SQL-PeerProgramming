package sqlConnect.com.qac.sqlDemo;

import java.sql.*;

public class CRUD {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	Connection conn = null;
	Statement stmt = null;
	String tableName = "customers";

	

	public CRUD() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Starting connection to db.");

		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

	public void createUser(int customerId, String name, String address, String email, String password) {
		System.out.println("Starting insert statement.");
		String sqlInsert = "INSERT INTO "+tableName+"  (customerId, name, address, email, password) VALUES("+customerId+", "+name+", "+address+", "+email+", "+password+")";
		
		try {
			stmt.executeUpdate(sqlInsert);
			System.out.println("Record Inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void selectUser() {
		
		String sql2 = "select customerId, name, address, email, password from " + tableName;
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				int custid = rs.getInt("customerId");
				String name1 = rs.getString("name");
				String address1 = rs.getString("address");
				String email1 = rs.getString("email");
				String pass1 = rs.getString("password");
				System.out.println("customerId: " + custid + " name: " + name1 + " address: " + address1 + " email: " + email1 + " password: " + pass1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void updateUser(int customerId) {
		System.out.println("Update Statement.");
		String sql3 = "update " + tableName + " set name='Maxwell' where customerId= "+customerId+";";
		try {
			stmt.executeUpdate(sql3);
			System.out.println("Record has now been updated");
		} catch (SQLException e) {
			System.out.println("OH no big error!!!");
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(int customerId) {
		System.out.println("Delete Statement");
		String sql4 = "delete from customers where customerId= "+customerId+";";
		try {
			stmt.executeUpdate(sql4);
			System.out.println("Record has now been deleted from "+tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
