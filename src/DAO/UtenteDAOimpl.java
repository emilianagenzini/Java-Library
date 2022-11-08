package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controllore.Controllore;
import DBConnection.Connessione;
import Elementi.Utenti;
import Swng.Login;

import Elementi.Utenti;

public class UtenteDAOimpl implements UtenteDAO{
	Controllore controller;
	Connection connection;
	private Statement sta;
	Login login = new Login(controller);

	public UtenteDAOimpl(Controllore controller, Connection conn) {
		this.controller = controller;
		this.connection =  conn;

	}
     @Override
	public boolean inserisciutente(String nome, String pwd, String pwd2, JButton btnRegistrazione ) throws SQLException {

		try {
			
			
		    String sql = "INSERT INTO public.Utente (username, password, password2) VALUES (?, ? ,?)";
			 
			
	        PreparedStatement pst1 = connection.prepareStatement(sql);
			pst1.setString(1, nome);
			pst1.setString(2, pwd);
			pst1.setString(3, pwd2);
			pst1.execute();
			
			
			
			JOptionPane.showMessageDialog(btnRegistrazione, "Account creato con successo");
			return true; 
			
		} catch (SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Username già in uso!!!", "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
 @Override
    public Utenti checkutente( String nome , String pwd , JButton btnAccedi) {
    	 ResultSet rs = null;
 		try {
 			Statement st = connection.createStatement();
 			String check = "SELECT * FROM public.utente"
 					+ " WHERE username = '" + nome + "' AND password = '" + pwd + "'";
 			
 		
				rs = st.executeQuery(check);
 			if (rs != null) {
				while(rs.next()) {
					Utenti utente = new Utenti(rs.getString("username"), rs.getString("password"));
					return utente;
				}
			}  
 			
 		}
      catch(SQLException e) {
			System.out.println("Errore accesso: " + e.getMessage());
			e.printStackTrace();
		} 
 		return null;  
 }
 @Override
 	public boolean accesso( String nome , JButton btnAccedi) {
 		try {
 			
 		String sql2 = "INSERT INTO public.accessi(	username) VALUES (?);";
		 PreparedStatement pst2 = connection.prepareStatement(sql2);
		
			pst2.setString(1, nome);
			
			pst2.execute();
			return true;
 		} catch(SQLException e) {
 			System.out.println("Errore tab accessi: " + e.getMessage());
			e.printStackTrace();
 			
 		} return false;
}
	
}
