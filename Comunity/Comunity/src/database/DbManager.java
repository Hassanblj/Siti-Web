package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String CATALOG = "genetorialitaconsapevole";//il nome deve corrispondere a quello sul database
	
	//connesione al database
	private Connection conn;
	
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//apre la connessione al database
	public Connection openConnection() throws SQLException {
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		conn.setCatalog(CATALOG);
		return conn;
	}
	
	//chiude la connessione al database
	public void closeConnection() throws SQLException {
		conn.close();
	}
	
	
}
