package DAO;

import java.sql.SQLException;

import javax.swing.JButton;

import Elementi.Utenti;

public interface UtenteDAO {
public boolean inserisciutente(String nome, String pwd, String pwd2, JButton btnRegistrazione) throws SQLException;
public Utenti checkutente( String nome , String pwd , JButton btnAccedi);
public boolean accesso(String nome, JButton btnAccedi);

}