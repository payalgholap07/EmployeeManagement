package employeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

static int pool_size = 4;
	
	static String url = "jdbc:postgresql://localhost:5432/employeemanagement?user=postgres&password=root";

	static List<Connection> connectionpool = new ArrayList<Connection>();
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			for(int i=0;i<pool_size;i++) {
				Connection connection =createConnection();
				connectionpool.add(connection);
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection createConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static Connection getConnectionObject() {
		if(!connectionpool.isEmpty()) {
			return connectionpool.remove(0);
		}else {
			return createConnection();
		}
	}
	
	static public void reciveConnection(Connection connection) {
		if(connectionpool.size()<pool_size) {
			connectionpool.add(connection);
		}else {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

