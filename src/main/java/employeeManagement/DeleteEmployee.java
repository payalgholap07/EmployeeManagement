package employeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {

	public static void main(String[] args) {
		
		Connection connection = ConnectionPool.getConnectionObject();
		String query = "delete from employee where id=11 ";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.execute();
			ConnectionPool.reciveConnection(connection);
			System.out.println("all done");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		}
}
