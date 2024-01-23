package employeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class SaveEmployee {

public static void main(String[] args) {
		
		Connection connection = ConnectionPool.getConnectionObject();
		String query = "insert into employee values(?,?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, 11);
			ps.setString(2, "snehal");
			ps.setInt(3, 50000);
			ps.setInt(4, 22);
			ps.setString(5, "F");
			ps.setString(6, "Android Developer");
			
			ps.execute();
			ConnectionPool.reciveConnection(connection);
			System.out.println("all done");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
