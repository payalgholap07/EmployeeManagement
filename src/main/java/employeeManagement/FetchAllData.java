package employeeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchAllData {

public static void main(String[] args) {
		
		Connection connection = ConnectionPool.getConnectionObject();
		
		Statement ps;
		String query = "select * from employee ";
		
		try {
			
			ps = connection.createStatement();
			ResultSet rs = ps.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name= rs.getString(2);
				int salary = rs.getInt(3);
				int age = rs.getInt(4);
				String gender= rs.getString(5);
				String designation= rs.getString(6);
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(salary);
				System.out.println(age);
				System.out.println(gender);
				System.out.println(designation);
				System.out.println("======================");
			}
			
			
			ConnectionPool.reciveConnection(connection);
			System.out.println("all done");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		}
}
