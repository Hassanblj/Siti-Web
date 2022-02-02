package database;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Users;
import pwdhasher.PasswordHash;

public class DbUser {

	public int createUser(Users user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		int rows = 0;

		DbUser u = new DbUser();
		if(u.controlloEmail(user.getEmail()) != false) {
			return rows = 0;
		}else {

			//preparo la query
			String sqlQuery = "INSERT INTO utenti (cognome, nome, indirizzo, telefono, email, password) VALUES (?, ? , ?, ?, ?, ?)";
			//hash della password
			String passwordHash = PasswordHash.generatePasswordHash(user.getPassword());
			//debug
			System.out.println("createUser passwordHash=" + passwordHash);
			//mi connetto al database
			DbManager dbm = new DbManager();
			Connection conn = dbm.openConnection();
			//precompilazione della query
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setString(1, user.getCognome());
			ps.setString(2, user.getNome());
			ps.setString(3, user.getIndirizzo());
			ps.setString(4, user.getTelefono());
			ps.setString(5, user.getEmail());
			ps.setString(6, passwordHash);
			
			//esecuzione della query
			rows = ps.executeUpdate();
			//chiusura della connessione al db
			dbm.closeConnection();
			//debug
			System.out.println("createUser rows " + rows);
			return rows;
		}
	}

	//cerca l'utente user nella tabella e se lo trova lo restituisce altrimenti restituisce null
	public Users getUser(Users user) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		//preparo la query
		String sqlQuery = "SELECT * FROM utenti WHERE email = ?";
		//mi connetto al database
		DbManager dbm = new DbManager();
		Connection conn = dbm.openConnection();
		//precompilazione della query
		PreparedStatement ps = conn.prepareStatement(sqlQuery);
		ps.setString(1, user.getEmail());
		//debug
		System.out.println("getUser email" + user.getEmail());
		//esecuzione della query
		ResultSet rs = ps.executeQuery();
		//analisi del resultset
		int numRows = 0;
		Integer id = null;
		String password = null;
		while (rs.next()) {
			numRows++;
			id = rs.getInt("id");
			password = rs.getString("password");
		}
		if (numRows == 0) { 
			return null;
		} else {
			if (PasswordHash.validatePassword(user.getPassword(), password)) { 
				return new Users(id, user.getEmail(), password);
			} else {
				return null;
			}
		}

	}
	//controllo email
	public boolean controlloEmail(String email) {
		try {
			String sqlQuery2 = "SELECT * FROM utenti WHERE email = ?";
			//mi connetto al database
			DbManager dbm2 = new DbManager();
			Connection conn2 = dbm2.openConnection();
			//precompilazione della query
			PreparedStatement ps2 = conn2.prepareStatement(sqlQuery2);
			ps2.setString(1,email);
			//esecuzione della query
			ResultSet rs2 = ps2.executeQuery();
			//analisi del resultset
			int numRows = 0;
			while (rs2.next()) {
				numRows++;
			}
			if (numRows > 0) { 
				return true;
			}else {
				return false;
			}
		}catch(SQLException ex) {
			// debug
			System.out.println("Errore");
		}
		return false;
	}
	// main di controllo
	//public static void main (String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {
		
		//DbUser u = new DbUser();
		//Users user = new Users (0,"hassan", "1234567","dddddkk","ssssss","11111","55555");
		//int r =u.createUser(user);
		//if(r>0) {
		//	System.out.println(" Giusto");
		//}else {
			//System.out.println("Sbagliato");
		//}
	//}

}