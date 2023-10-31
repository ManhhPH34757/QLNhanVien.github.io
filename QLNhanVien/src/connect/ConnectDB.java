package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private final String ServerName = "localhost";
	private final String DBName = "NhanVien";
	private final String PortNumber = "1433";
	private final String User = "sa";
	private final String Pass = "nguyenmanh2707";
	
	String url = "jdbc:sqlserver://"+ServerName+":"+PortNumber+";databaseName="+DBName+";user="+User+";password="+Pass+";encrypt=false";
	
	public Connection Connect() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Lỗi");
		}
		
		return connection;
	}
	
}
