package Elementi;

import java.sql.Connection;

import Controllore.Controllore;

public class Intervista {
	 String titolo; 
	 int numpag; 
	 String descrizione;
	 String autore;
	 String username;
public Intervista (Controllore controller, Connection connection) {
		 
	 }
public String getTitolo() {
	return titolo;
}
public void setTitolo(String titolo) {
	this.titolo = titolo;
}
public int getNumpag() {
	return numpag;
}
public void setNumpag(int numpag) {
	this.numpag = numpag;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
public String getAutore() {
	return autore;
}
public void setAutore(String autore) {
	this.autore = autore;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username  = username;
}

}
