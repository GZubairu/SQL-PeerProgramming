package sqlConnect.com.qac.sqlDemo;

import java.sql.*;

public class Runner2 {

	public static void main(String[] args) {

		CRUD c = new CRUD();

		// c.createUser(51, "'John'", "'50 High Street'", "'john@mail.com'",
		// "'smith123'");
//		c.updateUser(9);
		
		c.deleteUser(51);
		c.selectUser();

	}

}
