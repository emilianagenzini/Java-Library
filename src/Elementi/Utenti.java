package Elementi;

import java.sql.Connection;

import Controllore.Controllore;

public class Utenti {
	private String nome;
	private String pwd;
	private String pwd2;
	
	public Utenti(String nome, String pwd ) {
		setUsername(nome);
		setPassword(pwd);
	
	}

	public Utenti(String nome, String pwd, String pwd2 ) {
		setUsername(nome);
		setPassword(pwd);
		setPassword2(pwd2);
	}

	 public Utenti(Controllore controller, Connection connection) {
		// TODO Auto-generated constructor stub
	}
	public Utenti(String nome) {
		setUsername(nome);
	}
	public String getPassword() {
			return pwd;
		    }

   public void setPassword(String pwd) {
			this.pwd = pwd;
		    }

   public String getPassword2() {
		return pwd2;
	    }

public void setPassword2 (String pwd2) {
		this.pwd2 = pwd2;
	    }
   public String getUsername() {
			return nome;
		    }
   public void setUsername(String nome) {
			this.nome = nome;
		    }

	}


