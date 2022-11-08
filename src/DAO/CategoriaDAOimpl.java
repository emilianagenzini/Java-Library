package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Controllore.Controllore;
import Elementi.Utenti;

public class CategoriaDAOimpl implements CategoriaDAO {
	Controllore controller;
	Connection connection;
	Utenti utente = new Utenti(controller, connection);
	String username;
	
	public CategoriaDAOimpl(Controllore controller, Connection conn) {
		this.controller = controller;
		this.connection =  conn;
	} 
	@Override
	public void elementicategoria(JList list , String categoria) {
		
		try {
			String sql ="SELECT \"titolo-riferimento\" FROM  public.\"Appartiene\" WHERE \"titolo-categoria\" = '" + categoria + "'" ;
			PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		DefaultListModel DLM = new DefaultListModel();
		
		while(rs.next()) {
			DLM.addElement(rs.getString("titolo-riferimento"));
		}
		list.setModel(DLM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void lemiecategorie(JList list) {
		 username= getUtente();
		try {
			String sql ="SELECT nome_categoria FROM public.\"Categoria\" WHERE \"Utente\" = '" + username + "'" ;
			PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		DefaultListModel DLM = new DefaultListModel();
		
		while(rs.next()) {
			DLM.addElement(rs.getString("nome_categoria"));
		}
		list.setModel(DLM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
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
	public boolean inseriscicategoria( String nome, JButton btnNewButton) {
		if(nome.length()>0) {
		try {
			username = getUtente();
			 String sql =" INSERT INTO public.\"Categoria\"(\r\n" + 
			 		"	\"Utente\", nome_categoria)\r\n" + 
			 		"	VALUES (?, ?);";
			 PreparedStatement pst = connection.prepareStatement(sql);
			 pst.setString(1,username);
		     pst.setString(2,nome);
			 pst.execute();			
			
			
	

			JOptionPane.showMessageDialog(btnNewButton, "Categoria creata con successo");
			return true;
		} catch (SQLException e) {
			System.out.println("Errore inserimento: " + e.getMessage());
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			
		return false;
		}

	} else {
		JOptionPane.showMessageDialog(btnNewButton, "Inserisci un titolo");
		}return false;
	}
	@Override
	public boolean checkcategoria(String categoria, JButton btnNewButton) {
		 ResultSet rs = null;
		 String tit;
		 Statement st; 
		 try { 
				st = connection.createStatement();
				String check = "SELECT COUNT(nome_categoria) AS num FROM public.\"Categoria\" WHERE  nome_categoria =  '" + categoria + "'";
				rs= st.executeQuery(check);
				if (rs != null) {
				while(rs.next()) {
					int contr = (rs.getInt("num"));
					System.out.println(contr);
					if(contr != 0) {
						//JOptionPane.showMessageDialog(btnRiferimenti, "Riferimento inserito con successo");
						return true;
						
					} else  {
						JOptionPane.showMessageDialog(btnNewButton, "Categoria non presente");
						return false;
						
					}
						
					} }
				
				
				}   catch (SQLException e) {
				// TODO Auto-generated catch block
					
						JOptionPane.showMessageDialog(btnNewButton, "Inserire un titolo valido");
						e.printStackTrace();
						return false;
				
				
			}
			return false;
		  
	  }
	@Override
public boolean inseriscititolo(String categoria, String titolo,JButton btnNewButton) {
	
	
	try {
	String sql ="INSERT INTO public.\"Appartiene\"(\r\n" + 
			"	\"titolo-categoria\", \"titolo-riferimento\")\r\n" + 
			"	VALUES (?, ?);";
	 PreparedStatement pst = connection.prepareStatement(sql);
	 pst.setString(1,categoria);
     pst.setString(2,titolo);
	 pst.execute();			
	
	


	JOptionPane.showMessageDialog(btnNewButton, "Operazione effettuata con successo");
	return true;
} catch(SQLException e) {
	System.out.println("Errore inserimento: " + e.getMessage());
	//e.printStackTrace();
	JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	
return false;
}
}
	@Override
public boolean rimuovi_riferimento(String categoria,String titolo, JButton btnNewButton) {
	 ResultSet rs = null;
		Statement st;
	   if((titolo.length()>0)&&(categoria.length()>0)){
		   
				 String sql = "DELETE FROM public.\"Appartiene\"\r\n" + 
				 		"	WHERE \"titolo-categoria\" = ? AND \"titolo-riferimento\" =?;";
				
				
				PreparedStatement pst;
				
				
			
				try {
					pst = connection.prepareStatement(sql);
				
					pst.setString(1, categoria);
					pst.setString(2, titolo);
					
					pst.executeUpdate();
					 
					JOptionPane.showMessageDialog(btnNewButton, "Elemento rimosso con successo");
					return true;
				} catch (SQLException e) {
					//JOptionPane.showMessageDialog(btnRimuovi, "Errore rimozione");
					JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					//e.printStackTrace();
					return false;
				}
			
				
			}
			    else {
				JOptionPane.showMessageDialog(btnNewButton, "Compilare i campi");
			}return false;
	}
	@Override
public boolean rimuovicategoria(String categoria, JButton btnNewButton) {
	 ResultSet rs = null;
		Statement st;
	   if((categoria.length()>0)){
		          
				 String sql = "DELETE FROM public.\"Appartiene\"\r\n" + 
				 		"	WHERE \"titolo-categoria\" = ?;";
				 String sql2 ="DELETE FROM public.\"Categoria\"\r\n" + 
				 		"	WHERE  nome_categoria =?;";
				
				
				PreparedStatement pst;
				PreparedStatement pst2;
				
				
				
			
				try {
					pst = connection.prepareStatement(sql);
					pst2 = connection.prepareStatement(sql2);
				
					pst.setString(1, categoria);
					pst2.setString(1, categoria);
					
				
					
					pst.executeUpdate();
					pst2.executeUpdate();
					 
					JOptionPane.showMessageDialog(btnNewButton, "Categoria rimossa con successo");
					return true;
				} catch (SQLException e) {
					//JOptionPane.showMessageDialog(btnRimuovi, "Errore rimozione");
					JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					//e.printStackTrace();
					return false;
				}
			
				
			}
			    else {
				JOptionPane.showMessageDialog(btnNewButton, "Compilare i campi");
			}return false;
	}



}
	
	

