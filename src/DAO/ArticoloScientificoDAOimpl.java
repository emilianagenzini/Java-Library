package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controllore.Controllore;
import Elementi.Utenti;

public class ArticoloScientificoDAOimpl  implements ArticoloScientificoDAO{
	Controllore controller;
	Connection connection;
	Utenti utente = new Utenti(controller, connection);
	String username;
	 
	
	public ArticoloScientificoDAOimpl(Controllore controller, Connection conn) {
		this.controller = controller;
		this.connection =  conn;
	} 
	
	public String getUtente() {
		ResultSet rs = null;
		Statement st;
		try {
			st = connection.createStatement();
			String check = " SELECT username FROM public.accessi ORDER BY data_accesso DESC LIMIT 1";
			rs = st.executeQuery(check);
			if (rs != null) {
			while(rs.next()) {
				String utente = (rs.getString("username"));
					return utente;
				}
			}  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
			}
	@Override
	public boolean inserisciarticolo(String titolo, String numpag, String descrizione, String dins, String datapubblicazione, String tipo ,JButton btnInserisci) throws SQLException{
		try { 
			username = getUtente();
			 
			
			int npag = Integer.parseInt(numpag);
			
		   
			 String sql1 = "INSERT INTO public.\"riferimenti_bibliografici \"(\r\n" + 
			 		"	\"Titolo\", \"Descrizione\", \"Utente\", data_inserimento, data_pubblicazione)\r\n" + 
			 		"	VALUES (?, ?, ?, ?, ?);";
			 
			 PreparedStatement pst = connection.prepareStatement(sql1);
			 pst.setString(1,titolo);
		
			 
			 pst.setString(2, descrizione);
			 pst.setString(3,username);
			 pst.setString(4,dins);
			 pst.setString(5,datapubblicazione); 
		
	         pst.execute();
	         
		   String sql2 = "INSERT INTO public.articoli_scientifici(\r\n" + 
		   		"	num_pag, titolo, tipo)\r\n" + 
		   		"	VALUES (?, ?, ?);";
			 
		    
	        PreparedStatement pst1 = connection.prepareStatement(sql2);
	       
	    
			pst1.setInt(1, npag);
			pst1.setString(2, titolo);
			pst1.setString(3, tipo);
			pst1.execute();
			
			JOptionPane.showMessageDialog(btnInserisci, "Articolo inserito con successo");
			return true; 
			
		}catch (SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		
		}
	
	 @Override
	 public boolean inserisciautore(String titolo, String autore, JButton btnAutore) {
			
			
			
		 String sql2 = "INSERT INTO public.\"Scrive\"(\r\n" + 
		 		"	\"Titolo\", \"Nome\")\r\n" + 
		 		"	VALUES (?, ?);";
	
	PreparedStatement pst2;
	try {
		
	    
	     pst2 = connection.prepareStatement(sql2);
	     pst2.setString(1,titolo);
	     pst2.setString(2,autore);
	     pst2.execute();
	     JOptionPane.showMessageDialog(btnAutore, "Autore inserito con successo");
	     return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(btnAutore, "Inserire un autore valido ");
		return false;
	}
	
	}
	 @Override
	 public boolean inserisciriferimento(String titolo,String cita, JButton btnRiferimenti) {
			
			
			
		 String sql2 = "INSERT INTO public.\"Citazione\"(\r\n" + 
		 		"	\"Titolo-Cita\", \"Titolo_Citato\")\r\n" + 
		 		"	VALUES (?, ?);";
	PreparedStatement pst2;
	try {
		
	    
	     pst2 = connection.prepareStatement(sql2);
	     pst2.setString(1,titolo);
	     pst2.setString(2,cita);
	     pst2.execute();
	     JOptionPane.showMessageDialog(btnRiferimenti, "Riferimento inserito con successo");
	     return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		JOptionPane.showMessageDialog(btnRiferimenti, "Inserire un riferimento valido ");
		return false;
	}
	
	}
	 @Override
	 public boolean checkriferimento(String titolo, String cita, JButton btnRiferimenti) {
		 ResultSet rs = null;
		 String tit;
		 Statement st; 
		 try { 
				st = connection.createStatement();
				String check = "SELECT COUNT(\"Titolo\") AS num FROM public.\"riferimenti_bibliografici \" WHERE \"Titolo\" =  '" + cita + "'";
				rs= st.executeQuery(check);
				if (rs != null) {
				while(rs.next()) {
					int contr = (rs.getInt("num"));
					System.out.println(contr);
					if(contr != 0) {
						//JOptionPane.showMessageDialog(btnRiferimenti, "Riferimento inserito con successo");
						return true;
						
					} else  {
						JOptionPane.showMessageDialog(btnRiferimenti, "Un riferimento può essere associato ad un titolo già presente");
						return false;
						
					}
						
					} }
				
				
				}   catch (SQLException e) {
				// TODO Auto-generated catch block
					
						JOptionPane.showMessageDialog(btnRiferimenti, "Inserire un titolo valido");
						e.printStackTrace();
						return false;
				
				
			}
			return false;
		  
	  }
	@Override
	public boolean checkautore( String titolo, String autore, JButton btnInserisci2) {
		 if(autore.length() >0 ) {
		  ResultSet rs = null;
		  String tit;
			Statement st; 
			System.out.println(autore);
			try { 
				st = connection.createStatement();
				String check = "SELECT COUNT(\"Titolo\") AS num FROM public.\"Scrive\" WHERE \"Nome\" =  '"+ autore + "'";
				rs= st.executeQuery(check);
				if (rs != null) {
				while(rs.next()) {
					int contr = (rs.getInt("num"));
					System.out.println(contr);
					if(contr != 0) {
					
						return true;
						
					}else  {
						JOptionPane.showMessageDialog(btnInserisci2, "Inserire almeno un autore ");
						return false;
						
					}
				
					} }
			}
				
				catch (SQLException e) {
				// TODO Auto-generated catch block
					
						JOptionPane.showMessageDialog(btnInserisci2, "Inserire un titolo valido");
						e.printStackTrace();
						return false;
				
				
			}
			} else {
				JOptionPane.showMessageDialog(btnInserisci2, "Inserire un autore ");
				return false;
			}
			return false;
		  
	  } 	




}
