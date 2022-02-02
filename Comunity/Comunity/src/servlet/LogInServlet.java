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
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recupero dati del form
		String email = request.getParameter("emailLog");
		String pwd = request.getParameter("pwdLog");
		Users user = new Users(0, email, pwd);
		DbUser dbu = new DbUser();
		//verificare che l'utente sia effettivamente registrato (creando un'istanza di User)
		//se registrato gli inviamo msg di benvenuto altrimenti msg di errore
		String risposta = null; 
		try {
			Users numRows = dbu.getUser(user);
			//debug
			System.out.println("LogInServlet numRows " + numRows);
			if(numRows != null) {
				risposta = Messages.USER_LOGIN_OK;
			}else {
				risposta = Messages.USER_LOGIN_KO;
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
			e.printStackTrace();
			risposta = Messages.TECH_ERROR;
		}
		PrintWriter writer = response.getWriter();
		//debug
		System.out.println("LogInServlet risposta " + risposta);
		writer.println(risposta);

	}

}
