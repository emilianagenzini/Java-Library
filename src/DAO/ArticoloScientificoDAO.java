package DAO;

import java.sql.SQLException;

import javax.swing.JButton;

public interface ArticoloScientificoDAO {
	
	public default boolean inserisciarticolo(String titolo, String numpag, String descrizione, String dins,
			String datapubblicazione,String tipo, JButton btnInserisci) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean inserisciautore(String titolo, String autore, JButton btnAutore);
	public boolean checkautore( String titolo, String autore, JButton btnInserisci2);
	public boolean inserisciriferimento(String titolo,String cita, JButton btnRiferimenti);
	public boolean checkriferimento(String titolo, String cita, JButton btnRiferimenti);
}

