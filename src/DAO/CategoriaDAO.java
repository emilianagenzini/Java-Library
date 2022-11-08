package DAO;

import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JList;

import Controllore.Controllore;

public interface CategoriaDAO {

	void elementicategoria(JList list, String categoria);

	void lemiecategorie(JList list);

	String getUtente();

	boolean inseriscicategoria(String nome, JButton btnNewButton);

	boolean checkcategoria(String categoria, JButton btnNewButton);

	boolean inseriscititolo(String categoria, String titolo, JButton btnNewButton);

	boolean rimuovi_riferimento(String categoria, String titolo, JButton btnNewButton);

	boolean rimuovicategoria(String categoria, JButton btnNewButton);
	
	
}
