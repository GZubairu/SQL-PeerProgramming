//package sqlConnect.com.qac.sqlDemo;
//
//import java.sql.*;
//
//public class Runner {
//
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:3306/gamedb?useSSL=false";
//	static final String USER = "root";
//	static final String PASS = "root";
//
//	public static void main(String[] args) {
//		Connection conn = null;
//		Statement stmt = null;
//
//		int customerId = 9;
//		String name = "'Charlie'";
//		String address = "'55 High Road'";
//		String email = "'gabriel@mail.com'";
//		String password = "'chelsea17'";
//
//		String tableName = "customers";
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("Starting connection to db.");
//
//		try {
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			System.out.println("Connected!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		
//		
//		
//		
//		System.out.println("Starting insert statement.");
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		String sqlInsert = "INSERT INTO " + tableName + " (customerId, name, address, email, password) VALUES("
//				+ customerId + ", " + name + ", " + address + ", " + email + ", " + password + ")";
//
//		try {
//			stmt.executeUpdate(sqlInsert);
//			System.out.println("Record Inserted.");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		
//		
//		
//		
//		System.out.println("Creating a select statement.");
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		String sql2 = "select customerId, name, address, email, password from " + tableName;
//		ResultSet rs = null;
//		try {
//			rs = stmt.executeQuery(sql2);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			while (rs.next()) {
//				int custid = rs.getInt("customerId");
//				String name1 = rs.getString("name");
//				System.out.println("customerId: " + custid + " name: " + name1 + "address: " + address + " email: " + email);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		
//		
//		
//		
//		System.out.println("Update Statement.");
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		String sql3 = "update " + tableName + " set name='Maxwell' where customerId=9;";
//		try {
//			stmt.executeUpdate(sql3);
//			System.out.println("Record has now been updated");
//		} catch (SQLException e) {
//			System.out.println("OH no big error!!!");
//			e.printStackTrace();
//		}
//		
//		
//		
//		System.out.println("Delete Statement");
//		try {
//			stmt = conn.createStatement();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		String sql4 = "delete from customers where CustomerId=69";
//		try {
//			stmt.executeUpdate(sql4);
//			System.out.println("Record has now been deleted from "+tableName);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
