package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public interface IntervistaDAO {
	public default boolean inserisciintervista(String titolo, String npag, String descrizione, String dins,
			String datapubblicazione, JButton btnInserisci) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	 public boolean inserisciautore(String titolo, String autore, JButton btnAutore);
	 public boolean checkautore( String titolo, String autore, JButton btnInserisci2);
	 public boolean inserisciriferimento(String titolo,String cita, JButton btnRiferimenti);
	 public boolean checkriferimento(String titolo, String cita, JButton btnRiferimenti);
}
