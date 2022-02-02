package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DbUser;
import pojo.Users;
import util.Messages;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cognome = request.getParameter("cognome");
		String nome = request.getParameter("nome");
		String indirizzo = request.getParameter("indirizzo");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		Users user = new Users (0, cognome, nome, indirizzo, telefono, email, password);
		DbUser dbu = new DbUser();
		String risposta = null; 
		try {
			int rows = dbu.createUser(user);
			if (rows == 1) {
				risposta = Messages.USER_SIGNUP_OK;
			} else if(rows == 0){
				risposta = Messages.USER_SIGNUP_KO;
				} else {
					risposta = Messages.TECH_ERROR;
			}
		} catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			//log + notifica all'admin
			risposta = Messages.TECH_ERROR;
		}
		PrintWriter writer = response.getWriter();
		writer.println(risposta);
	}

}
